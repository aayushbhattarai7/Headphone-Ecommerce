package controller.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utils.StringUtils;
import controller.DatabaseController;
import model.userModel;

@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.LOGIN})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DatabaseController dbController = new DatabaseController();

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Check login credentials
        int loginResult = dbController.getUserLoginInfo(email, password);

        if (loginResult == 1) {
        	
        	HttpSession userSession = request.getSession();
        	userSession.setAttribute("emailSession", email);
        	userSession.setMaxInactiveInterval(30*3);
        	
        	Cookie userCookie = new Cookie("emailSession", email);
        	userCookie.setMaxAge(30*60);
        	response.addCookie(userCookie);
        	
            userModel users = null;
			try {
				users = dbController.getUserDetails(email);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
            if (users != null) {
                request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_LOGIN_MESSAGE);
                request.getRequestDispatcher(StringUtils.HOME_PAGE).forward(request, response);
            } else {
                request.setAttribute(StringUtils.ERROR_MESSAGE, "User not found");
                request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
            }
        } else if (loginResult == 0) {
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.ERROR_LOGIN_MESSAGE);
            request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
        } else {
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
            request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
        }
    }
}


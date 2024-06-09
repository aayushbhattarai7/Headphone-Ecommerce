package controller.servlets;
	import java.io.IOException;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.Cookie;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

import Utils.adminStringUtils;
import controller.adminController;
import model.adminModel;

	@WebServlet(asyncSupported = true, urlPatterns = {adminStringUtils.LOGIN})
	public class adminLogin extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    adminController adController = new adminController();

	    public adminLogin() {
	        super();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        // Check login credentials
	        int loginResult = adController.getAdminLoginInfo(email, password);

	        if (loginResult == 1) {
	        	
	        	HttpSession adminSession = request.getSession();
	        	adminSession.setAttribute("adminSession", email);
	        	adminSession.setMaxInactiveInterval(30*3);
	        	
	        	Cookie adminCookie = new Cookie("adminSession", email);
	        	adminCookie.setMaxAge(30*60);
	        	response.addCookie(adminCookie);
	        	
	            adminModel admins = null;
				try {
					admins = adController.getAdminDetails(email);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				
	            if (admins != null) {
	                request.setAttribute(adminStringUtils.SUCCESS_MESSAGE, adminStringUtils.SUCCESS_LOGIN_MESSAGE);
	                request.getRequestDispatcher(adminStringUtils.HOME_PAGE).forward(request, response);
	            } else {
	                request.setAttribute(adminStringUtils.ERROR_MESSAGE, "Admin not found");
	                request.getRequestDispatcher(adminStringUtils.ADMIN_LOGIN_PAGE).forward(request, response);
	            }
	        } else if (loginResult == 0) {
	            request.setAttribute(adminStringUtils.ERROR_MESSAGE, adminStringUtils.ERROR_LOGIN_MESSAGE);
	            request.getRequestDispatcher(adminStringUtils.ADMIN_LOGIN_PAGE).forward(request, response);
	        } else {
	            request.setAttribute(adminStringUtils.ERROR_MESSAGE, adminStringUtils.SERVER_ERROR_MESSAGE);
	            request.getRequestDispatcher(adminStringUtils.ADMIN_LOGIN_PAGE).forward(request, response);
	        }
	    }
	}




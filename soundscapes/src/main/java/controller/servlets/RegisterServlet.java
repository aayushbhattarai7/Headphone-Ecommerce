package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import model.userModel;
import Utils.StringUtils;

@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.REGISTER})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	DatabaseController dbController = new DatabaseController();


	public RegisterServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(req, res);
	}
	

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String fullName = req.getParameter(StringUtils.FULLNAME);
        String email = req.getParameter(StringUtils.EMAIL);
        String phoneNumber = req.getParameter(StringUtils.PHONENUMBER);
        String password = req.getParameter(StringUtils.PASSWORD);
        String confirmPassword = req.getParameter(StringUtils.CONFIRMPASSWORD);

       

        userModel userModel = new userModel(fullName, email, phoneNumber, password);
        int result = 0;
		try {
			result = dbController.addUser(userModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(result);
        
        if(password.equals(confirmPassword)) {
        	switch (result) {
        	case 1 -> {
        		req.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_REGISTER_MESSAGE);
                req.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(req, res);
        	}
        	case -1 ->{
        		req.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
                req.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(req, res);
        	}
        	case -2 -> {
        		req.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.DUPLICATE_EMAIL_MESSAGE);
                req.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(req, res);
        	}
     
        	case -3 ->{
        		 req.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.PHONE_EXIST_MESSAGE);
                 req.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(req, res);
        	}
        	default -> {
        		req.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
                req.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(req, res);
        	}
        	
        }
        	 
          
        }else{  
              req.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.CONFIRMPASSWORD_ERROR_MESSAGE);
              req.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(req, res);
              
      }
        }
        
}

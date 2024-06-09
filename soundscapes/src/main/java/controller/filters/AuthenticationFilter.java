package controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utils.StringUtils;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);
        boolean isLoggedIn = session != null && session.getAttribute("emailSession") != null;
        boolean isAdmin = session != null && session.getAttribute("Adminemail") != null;
		boolean isHome = uri.endsWith("home.jsp");
		boolean isAdmins = uri.endsWith("admin.jsp");

        // Allow access to login and signup pages without checking for authentication
        if( isHome) {
        	 res.sendRedirect(req.getContextPath() + "/pages/Home.jsp");
             return;
        }
       
        
        
        if(isLoggedIn) {
       	 res.sendRedirect(req.getContextPath() + "/pages/Home.jsp");
            return;
       }
        if (uri.endsWith("adminLogin.jsp") ||  uri.endsWith(".css")) {
            chain.doFilter(req, res);
            return;
        }

        // Redirect to login page if not logged in and trying to access restricted pages
//        if (!isLoggedIn && !(uri.endsWith("LoginServlet") || uri.endsWith("RegisterServlet") || uri.endsWith("cart.jsp"))) {
//            res.sendRedirect(req.getContextPath() + "/pages/Login.jsp");
//            return;
//        }
//      
        // Allow access to other pages if logged in
        chain.doFilter(request, response);
    }


    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // Initialization code, if any
    }
}
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

	

	@WebFilter("/*")
	public class adminAuthFilter implements Filter {

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
	        boolean isAdmin = session != null && session.getAttribute("adminSession") != null;
			boolean isAdmins = uri.endsWith("adminHome.jsp");

	        // Allow access to login and signup pages without checking for authentication
	        if( isAdmin) {
	        	 res.sendRedirect(req.getContextPath() + "/pages/adminHome.jsp");
	             return;
	        }
	        
	        if(isAdmins) {
	       	 res.sendRedirect(req.getContextPath() + "/pages/adminHome.jsp");
	            return;
	       }
	        if (uri.endsWith("adminLogin.jsp") ||  uri.endsWith(".css") || uri.endsWith(".png") ||uri.endsWith("UsersServlet") ||uri.endsWith("ProductsServlet") ||uri.endsWith("ProductServlet") ||uri.endsWith("CartServlet")) {
	            chain.doFilter(req, res);
	            return;
	        }

	       
	        chain.doFilter(request, response);
	    }


	    @Override
	    public void init(FilterConfig arg0) throws ServletException {
	        // Initialization code, if any
	    }
	}


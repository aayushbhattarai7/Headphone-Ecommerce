package Utils;

public class adminStringUtils {

	  public static final String ADD_ADMIN ="INSERT INTO admin_info"
	    		+"(email, password)"
	    		+"VALUES(?, ?)";
	    public static final String ADMIN_INFO = "SELECT * from admin_info WHERE email=?";
		public static final String GET_ADMIN_EMAIL = "SELECT COUNT(*) FROM admin_info WHERE email = ?";

	    public static final  String EMAIL ="email";
	    public static final  String PASSWORD ="password";

	    
	    public static final  String SUCCESS_REGISTER_MESSAGE ="Successfully Registered";
	    public static final  String EMAIL_ERROR_MESSAGE ="Please Enter the Valid Email";
	    public static final  String PASSWORD_ERROR_MESSAGE ="Password must be atleast 6 character, uppercase, lowercase, number and special character";
	    public static final  String SERVER_ERROR_MESSAGE ="SERVER ERROR OCCURRED";
	    public static final  String SUCCESS_LOGIN_MESSAGE ="logged in Successfully";
	    public static final  String ERROR_LOGIN_MESSAGE ="Email or pasword is incorrect";
	    public static final  String SUCCESS_MESSAGE ="Successfull";  


	    public static final  String ADMIN_LOGIN_PAGE ="/pages/adminLogin.jsp";
	    public static final  String REGISTER_PAGE ="/pages/register.jsp";
	    public static final  String HOME_PAGE ="/pages/adminHome.jsp";
	    public static final String REGISTER ="/RegisterServlet";
	    public static final String LOGIN ="/adminLogin";

	   

		public static final String ERROR_MESSAGE = "ErrorMessage";
}

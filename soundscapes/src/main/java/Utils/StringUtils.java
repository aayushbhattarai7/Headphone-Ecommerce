package Utils;

public class StringUtils {
    public static final String INSERT_USER ="INSERT INTO user_info " // Added space after table name
            + "(fullName, email, phoneNumber, password) "
            + "VALUES (?,?,?,?)";
  
    public static final String LOGIN_INFO ="SELECT * from user_info WHERE email=?";
	public static final String GET_EMAIL = "SELECT COUNT(*) FROM user_info WHERE email = ?";
    public static final  String FULLNAME ="fullName";
    public static final  String EMAIL ="email";
    public static final  String PHONENUMBER ="phoneNumber";
    public static final  String PASSWORD ="password";
    public static final  String CONFIRMPASSWORD ="confirmPassword";

    
    public static final  String ERROR_REGISTER_MESSAGE ="Please enter the correct data";
    public static final  String DUPLICATE_EMAIL_MESSAGE ="This email is already registered";
    public static final  String SUCCESS_REGISTER_MESSAGE ="Successfully Registered";
    public static final  String FULLNAME_ERROR_MESSAGE ="please enter the valid fullName";
    public static final  String EMAIL_ERROR_MESSAGE ="Please Enter the Valid Email";
    public static final  String PHONE_ERROR_MESSAGE ="please enter the valid phone number";
    public static final  String PHONE_EXIST_MESSAGE ="This Phone Number is already registered";
    public static final  String PASSWORD_ERROR_MESSAGE ="Password must be atleast 6 character, uppercase, lowercase, number and special character";
    public static final  String CONFIRMPASSWORD_ERROR_MESSAGE ="please enter the same password in both fields";
    public static final  String SERVER_ERROR_MESSAGE ="SERVER ERROR OCCURRED";
    public static final  String SUCCESS_LOGIN_MESSAGE ="logged in Successfully";
    public static final  String ERROR_LOGIN_MESSAGE ="Email or pasword is incorrect";
    public static final  String SUCCESS_MESSAGE ="Successfull";  


    public static final  String LOGIN_PAGE ="/pages/Login.jsp";
    public static final  String REGISTER_PAGE ="/pages/register.jsp";
    public static final  String HOME_PAGE ="/pages/Home.jsp";
    public static final String REGISTER ="/RegisterServlet";
    public static final String LOGIN ="/LoginServlet";

   

	public static final String ERROR_MESSAGE = "ErrorMessage";
}


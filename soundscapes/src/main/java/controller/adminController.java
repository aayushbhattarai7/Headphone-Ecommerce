package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Utils.adminStringUtils;
import model.adminModel;

public class adminController {

		public Connection getConnection() throws SQLException, ClassNotFoundException {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/sound";
	        String user = "root";
	        String pass = "";
	        return DriverManager.getConnection(url, user, pass);
	    }
		
		
		public int getAdminLoginInfo(String email, String password) {
		    try (Connection con = getConnection()) {
		        PreparedStatement st = con.prepareStatement(adminStringUtils.ADMIN_INFO);
		        st.setString(1, email);
		        ResultSet result = st.executeQuery();


		        if (result.next()) {
		        	  String admins = result.getString("email");
		                String adminPassword = result.getString("password");
		                if(adminPassword !=null && admins.equals(email)) {
		                	return 1;
		                }
		                else {
		                	return 0;
		                }
		        }else {
		        	return 0;
		        }
		    }catch(SQLException | ClassNotFoundException ex) {
		    	ex.printStackTrace();
		    	return -1;
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return -1;
		    }
			
		}

		public adminModel getAdminDetails(String email) throws ClassNotFoundException {
		    try (Connection connection = getConnection();
		         PreparedStatement statement = connection.prepareStatement(adminStringUtils.ADMIN_INFO)) {
		        statement.setString(1, email);
		        try (ResultSet resultSet = statement.executeQuery()) {
		            if (resultSet.next()) {
		                // Fetch user details from the result set and create a userModel object
		                adminModel admin = new adminModel();
		                admin.setEmail(resultSet.getString("email"));
		                admin.setPassword(resultSet.getString("password"));
		               
		                // Set other fields as needed
		                return admin;
		            } else {
		                return null;
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace(); 
		        return null;
		    }
		}

	    
		public List<adminModel> getAllAdmin() {
	        List<adminModel> admins = new ArrayList<>();
	        try (Connection con = getConnection()) {
	            PreparedStatement st = con.prepareStatement(adminStringUtils.ADMIN_INFO);
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	                adminModel adminmodels = new adminModel();
	                adminmodels.setEmail(rs.getString("email"));
	                adminmodels.setPassword(rs.getString("password"));
	                admins.add(adminmodels);
	            }
	        } catch (SQLException | ClassNotFoundException ex) {
	            ex.printStackTrace(); 
	        }
	        return admins;
	    }
	}



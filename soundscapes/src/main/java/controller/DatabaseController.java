package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utils.StringUtils;
import model.passwordEncrypt;
import model.userModel;



public class DatabaseController {
	

	public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/sound";
        String user = "root";
        String pass = "";
        return DriverManager.getConnection(url, user, pass);
    }
	
	public int addUser(userModel userModel) throws Exception {
	    try (Connection con = getConnection()) {
	        PreparedStatement st = con.prepareStatement(StringUtils.INSERT_USER);
	        PreparedStatement checkEmail = con.prepareStatement(StringUtils.GET_EMAIL);
            checkEmail.setString(1, userModel.getEmail());
            ResultSet checkEmails = checkEmail.executeQuery();

            checkEmails.next();

            if (checkEmails.getInt(1) > 0) {
                return -2; // Email already exists
            }
            String encryptPassword = passwordEncrypt.encryptPassword(userModel.getPassword(), "U3CdwubLD5yQbUOG92ZnHw==");
	        st.setString(1, userModel.getFullName());
			st.setString(2, userModel.getEmail());
			st.setString(3, userModel.getPhoneNumber());
			st.setString(4, encryptPassword);

	        int result = st.executeUpdate();
	        return result > 0 ? 1 : 0;
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace(); 
	        return -1;
	    }
	}
	
	public int getUserLoginInfo(String email, String password) {
	    try (Connection con = getConnection()) {
	        PreparedStatement st = con.prepareStatement(StringUtils.LOGIN_INFO);
	        st.setString(1, email);
	        ResultSet result = st.executeQuery();


	        if (result.next()) {
	        	  String users = result.getString("email");
	                String encryptedPassword = result.getString("password");
	                String decryptedPassword =passwordEncrypt.decryptPassword(encryptedPassword, "U3CdwubLD5yQbUOG92ZnHw==");
	                if(decryptedPassword !=null && users.equals(email)&&decryptedPassword.equals(password)) {
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
	                
	                
	                /*public int getLogin(String email, String password, String isAdmin) {
        try (Connection con = getConnection()) {
            PreparedStatement user = con.prepareStatement(StringUtils.GET_LOGIN_INFO);
            user.setString(1, email);
            ResultSet rs = user.executeQuery();
            if (rs.next()) {
                String userDb = rs.getString("email");
                String encryptedPassword = rs.getString("password");
            
//               
//               
//                System.out.println("is admin is"+admin);
                // Decrypt password from database and compare
                String decryptedPassword = PasswordEncryptionWithAes.decryptPassword(encryptedPassword, "U3CdwubLD5yQbUOG92ZnHw==");
                System.out.println("Decrypted Password: " + decryptedPassword);

                if (decryptedPassword != null && userDb.equals(email) && decryptedPassword.equals(password)) {
                   if(admin != null) {
                	   return 2;//login as admin successfull.
                   }else {
                	return 1;
                   }// Login successful
                } else {
                    return 0; // Password mismatch
                }
            } else {
                // No matching record found
                return 0;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); // Log the exception for debugging
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }*/

	public userModel getUserDetails(String email) throws ClassNotFoundException {
	    try (Connection connection = getConnection();
	         PreparedStatement statement = connection.prepareStatement(StringUtils.LOGIN_INFO)) {
	        statement.setString(1, email);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                // Fetch user details from the result set and create a userModel object
	                userModel user = new userModel();
	                user.setEmail(resultSet.getString("email"));
	                user.setPassword(resultSet.getString("password"));
	                user.setFullName(resultSet.getString("fullName")); 
	                user.setPhoneNumber(resultSet.getString("phoneNumber")); 
	                // Set other fields as needed
	                return user;
	            } else {
	                return null;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	        return null;
	    }
	}

    
	public List<userModel> getAllUsers() {
        List<userModel> users = new ArrayList<>();
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement(StringUtils.LOGIN_INFO);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                userModel usermodels = new userModel();
                usermodels.setEmail(rs.getString("email"));
                usermodels.setPassword(rs.getString("password"));
                users.add(usermodels);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); 
        }
        return users;
    }
}

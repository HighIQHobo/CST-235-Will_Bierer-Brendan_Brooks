package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Lobby;
import models.User;

public class UserDataService {
	Connection conn = null;
	String url = "jdbc:mysql://brendanbrooks.net/checkers?" + "user=userforclass&password=MemeBoi27";
	
	public List<User> getUsers()
	{
		List<User> users = new ArrayList<User>();
		String query = "SELECT * FROM users";
		try {
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println(rs.getString("firstName") + " " + rs.getString("lastName"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return users;
	}
	
	public User login(User loginFormData)
	{
		User user = new User();
		
		String query = "SELECT * FROM users WHERE username='" + loginFormData.getUsername()+ "' AND password='" + loginFormData.getPassword() + "'";
		try {
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
		
			while(rs.next())
			{
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//if user id = -1 printout that login failed, else print success
		System.out.println("User id: " + user.getId());
		
		return user;
	}
	
	public boolean register(User registerFormData)
	{
		String sql = "INSERT INTO users (firstName, lastName, email, phone, username, password) VALUES('" + registerFormData.getFirstName() +"', '" + registerFormData.getLastName() +"', '" + registerFormData.getEmail() + "', '" + registerFormData.getPhone() + "', '" + registerFormData.getUsername() + "', '" + registerFormData.getPassword() +"')";
		boolean status = false;
		
		try
		{
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			status = true;
		}
		catch(SQLException e)
		{
			 e.printStackTrace();
		}
		finally
		{
		 if(conn != null)
            {
                try
                {
                    conn.close();
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
		 //System.out.println("------------------------!!!!!!!!DONE!!!!!!!---------------------------");
		}
		
		return status;
	}

}

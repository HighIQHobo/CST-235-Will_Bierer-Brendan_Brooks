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
				user.setPhone(rs.getString("phone"));
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
		}
		
		return status;
	}
	
	public boolean updateUser(User user)
	{
		String sql = "UPDATE users SET firstName='" + user.getFirstName() + "', lastName='" + user.getLastName() + "', email='" + user.getEmail() + "', phone='" + user.getPhone() + "', username='" + user.getUsername() + "' WHERE id=" + user.getId();
		System.out.println(sql);
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
		 if(!user.getPassword().equals(null) || !user.getPassword().equals("") || !user.getPassword().equals(" "))
		 {
			 System.out.println(user.getPassword());
			 this.updatePassword(user);
		 }
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
		}
		
		return status;
	}
	
	public boolean updatePassword(User user)
	{
		String sql = "UPDATE users SET password='" + user.getPassword() + "' WHERE id=" + user.getId();
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
		}
		
		return status;
	}
	public boolean deleteUser(User user)
	{
		String sql = "DELETE FROM users WHERE id=" + user.getId();
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
		}
		
		return status;
	}
}

package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Lobby;

public class LobbyDataService {
	Connection conn = null;
	String url = "jdbc:mysql://brendanbrooks.net/checkers?" + "user=userforclass&password=MemeBoi27";
	
	public List<Lobby> getLobbies()
	{
		List<Lobby> lobbies = new ArrayList<Lobby>();
		String query = "SELECT * FROM lobbies";
		try {
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				lobbies.add(new Lobby(rs.getInt("id"), rs.getString("name"), rs.getString("host"), rs.getString("password"), rs.getInt("players")));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lobbies;
	}
	
	public boolean addLobby(Lobby lobby)
	{
		String sql = "INSERT INTO lobbies (name, host, password, players) VALUES('" + lobby.getName() +"', '" + lobby.getHost() +"', '" + lobby.getPassword() + "', '" + lobby.getPlayers() + "')";
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
	
	public Lobby getLobbyFromId(int id)
	{
		Lobby lobby = new Lobby();
		String query = "SELECT * FROM lobbies WHERE id=" + id;
		try {
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				lobby.setId(id);
				lobby.setHost(rs.getString("host"));
				lobby.setName(rs.getString("name"));
				lobby.setPlayers(rs.getInt("players"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lobby;
	}
	
	public boolean updateLobby(int id, String name, String password)
	{
		String sql = "UPDATE lobbies SET name='" + name + "', password='" + password + "' WHERE id=" + id;
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
	
	public boolean deleteLobby(int id)
	{
		String sql = "DELETE FROM lobbies WHERE id=" + id;
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

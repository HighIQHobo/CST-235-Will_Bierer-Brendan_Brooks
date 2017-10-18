package services;

import java.util.ArrayList;
import java.util.List;

import models.LobbyModel;
import models.User;

public class UserService
{
	public List<User> users = new ArrayList<User>();
	
	public UserService()
	{
		users.add(new User("Will", "Bierer", "will@gamil.com", "555-123-1776", "wbierer", "pass"));
	}
	
	public void addUser(User user)
	{
		users.add(user);
	}
}

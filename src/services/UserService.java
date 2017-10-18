//Authors: Will Bierer, Brendan Brooks
// Class: CST-235
// Prof. Reha
// 
// File Description: Service for user model that stores an ArrayList of Users
package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import interfaces.UserBusinessInterface;
import models.User;

@Stateless
@Local(UserBusinessInterface.class)
public class UserService implements UserBusinessInterface
{
	public List<User> users = new ArrayList<User>();
	
	public UserService()
	{
		users.add(new User("Will", "Bierer", "will@gmail.com", "555-123-1776", "wbierer", "pass"));
		users.add(new User("Brendan", "Brooks", "Brendan@IAmDumb.net", "555-555-5555", "bbrooks", "pass"));
	}
	//add user to the list
	public void addUser(User user)
	{
		users.add(user);
	}
	//get a user from the list
	public User getUser(int index)
	{
		return users.get(index);
	}
	//get the ArrayList
	public List<User> getUserList()
	{
		return this.users;
	}
}

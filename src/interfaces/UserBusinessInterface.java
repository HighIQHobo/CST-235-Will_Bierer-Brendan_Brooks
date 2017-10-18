//Authors: Will Bierer, Brendan Brooks
// Class: CST-235
// Prof. Reha
// 
// File Description: Interface for the UserService
package interfaces;

import java.util.List;

import models.User;

public interface UserBusinessInterface
{
	public void addUser(User user);
	public User getUser(int index);
	public List<User> getUserList();
}

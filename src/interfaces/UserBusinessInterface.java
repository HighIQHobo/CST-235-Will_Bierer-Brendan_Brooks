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
	public User login(User loginFormData);
	public boolean register(User registerFormData);
	public void setUser(User user);
	public User getLoggedUser();
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
}

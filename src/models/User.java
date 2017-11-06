//Authors: Will Bierer, Brendan Brooks
// Class: CST-235
// Prof. Reha
// 
// File Description: Model for a user
package models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class User 
{
	private int id = -1;
	
	@NotNull(message = "Required field")
	@Size(min=2, max=25)
	private String firstName="";
	
	@NotNull(message = "Required field")
	@Size(min=2, max=25)
	private String lastName="";
	
	@NotNull(message = "Required field")
	@Size(min=2, max=50)
	private String email="";
	
	@NotNull(message = "Required field")
	@Size(min=0, max=15)
	private String phone="";
	
	@NotNull(message = "Required field")
	@Size(min=2, max=25)
	private String username="";
	
	private String password="";
	
	public User() 
	{
		
	}

	public User(String firstName, String lastName, String email, String phone, String username, String password)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

//Authors: Will Bierer, Brendan Brooks
// Class: CST-235
// Prof. Reha
// 
// File Description: Controller for the Login Form at login.xhtml
package controllers;

import java.util.List;
import javax.faces.bean.*;
import javax.faces.context.*;
import javax.inject.Inject;

import interfaces.LobbyBusinessInterface;
import interfaces.UserBusinessInterface;
import models.Lobby;
import models.User;
import services.LobbyService;

@ManagedBean
@ViewScoped
public class LoginController {
		
	@Inject
	private UserBusinessInterface service;
	
	//Validate username and password entered in the login form
	public String login()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		//Use a foreach loop to check each object in the ArrayList
		for (User u : service.getUserList())
		{
			System.out.println("LOOP user + pass: " + u.getUsername() + " " + u.getPassword() + " ||| " + user.getUsername() + " " + user.getPassword());
			if( u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) 
			{
				//go to main page if login data is correct
				return "main.xhtml";
			}
		}
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("User", user);
		//refresh page if login data is incorrect
		return "login.xhtml";
	}
	
	public UserBusinessInterface getService() 
	{
		return service;
	}
}

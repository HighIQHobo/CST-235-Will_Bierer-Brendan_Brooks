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

import data.LobbyDataService;
import data.UserDataService;
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
		
		user = service.login(user);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		if(user.getId() == -1)
		{
			return "login.xhtml";
		}
		else
		{
			service.setUser(user);
			System.out.println(service.getLoggedUser().getUsername());
			return "main.xhtml";
		}
	}
	
	public String register()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("User", user);
		
		boolean status = service.register(user);
		
		if(status)
		{
			service.setUser(user);
			return "main.xhtml";
		}
		else
		{
			return "login.xhtml";
		}
	}
	
	public String updateUser()
	{
		if(service.getLoggedUser().getId() == -1) return "login.xhtml";
		
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		service.updateUser(user);
		service.setUser(user);
		
		return "main.xhtml";
		
	}
	
	public String deleteUser()
	{
		User user = service.getLoggedUser();
		
		service.deleteUser(user);
		
		return "login.xhtml";
	}
	
	public UserBusinessInterface getService() 
	{
		return service;
	}
}

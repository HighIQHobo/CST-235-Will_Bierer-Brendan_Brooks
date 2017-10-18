package controllers;

import java.util.List;
import javax.faces.bean.*;
import javax.faces.context.*;
import javax.inject.Inject;

import interfaces.LobbyBusinessInterface;
import models.LobbyModel;
import models.User;
import services.LobbyService;

@ManagedBean
@ViewScoped
public class LoginController {
		
	public String login()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		System.out.println("Username: " + user.getUsername() 
		+ "Password: " + user.getPassword());
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("User", user);

		return "login.xhtml";
	}
}

package controllers;
import javax.faces.bean.*;
import javax.faces.context.*;

import models.User;

@ManagedBean
@ViewScoped
public class FormController {
	public String onSubmit()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		if(user.getUsername() == "user" && user.getPassword() == "pass") 
		{
			return "main.xhtml";
		}
		return "login.xhtml";
	}
}

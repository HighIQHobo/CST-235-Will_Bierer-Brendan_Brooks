package controllers;
import javax.faces.bean.*;
import javax.faces.context.*;

@ManagedBean
@ViewScoped
public class LoginController {
	public String login()
	{
		FacesContext context = FacesContext.getCurrentInstance();

		return "main.xhtml";
	}
}

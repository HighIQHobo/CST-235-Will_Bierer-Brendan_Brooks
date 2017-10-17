package controllers;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.faces.context.*;

import models.LobbyFormModel;
import models.LobbyModel;
import services.LobbyService;

@ManagedBean
@ViewScoped
public class LoginController {
	public String login()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		
		LobbyService service = new LobbyService();
		
		List<LobbyModel> lobbies = service.getLobbies();
		System.out.println("meme");
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("lobbies", lobbies);

		return "main.xhtml";
	}
	
	public String addLobby()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		LobbyFormModel lobby = context.getApplication().evaluateExpressionGet(context, "#{lobbyFormModel}", LobbyFormModel.class);
		
		
		//LobbyService service = new LobbyService();
		
		//List<LobbyModel> lobbies = service.getLobbies();
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("lobbyFormModel", lobby);

		System.out.println("lobby name " + lobby.name);
		return "main.xhtml";
	}
}

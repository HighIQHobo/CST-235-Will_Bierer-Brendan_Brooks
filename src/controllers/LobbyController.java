package controllers;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.faces.context.*;
import javax.ws.rs.POST;

import models.LobbyFormModel;
import models.LobbyModel;
import services.LobbyService;

@ManagedBean
@ViewScoped
public class LobbyController {
	
	public String addLobby()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		LobbyFormModel lobby = context.getApplication().evaluateExpressionGet(context, "#{lobby}", LobbyFormModel.class);
		
		//LobbyService service = new LobbyService();
		
		//List<LobbyModel> lobbies = service.getLobbies();
		System.out.println("lobby name" + lobby.name);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("lobby", lobby);

		return "main.xhtml";
	}
}

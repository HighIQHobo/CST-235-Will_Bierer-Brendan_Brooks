package controllers;

import javax.faces.bean.*;
import javax.faces.context.*;
import javax.inject.Inject;

import interfaces.LobbyBusinessInterface;
import models.LobbyFormModel;
import models.LobbyModel;

@ManagedBean
@ViewScoped
public class LobbyController {
	
	@Inject
	private LobbyBusinessInterface service;
	
	public String addLobby()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		LobbyFormModel lobby = context.getApplication().evaluateExpressionGet(context, "#{lobbyFormModel}", LobbyFormModel.class);
		
		service.addLobby(new LobbyModel(0, lobby.getName(), "host", lobby.getPassword(), 0));

		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("lobbyFormModel", lobby);

		return "main.xhtml";
	}
	
	public LobbyBusinessInterface getService() {
		return service;
	}
}

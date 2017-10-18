//Authors: Will Bierer, Brendan Brooks
// Class: CST-235
// Prof. Reha
// 
// File Description: Controller for the CreateLobby Form at main.xhtml
package controllers;

import javax.faces.bean.*;
import javax.faces.context.*;
import javax.inject.Inject;

import interfaces.LobbyBusinessInterface;
import models.Lobby;

@ManagedBean
@ViewScoped
public class LobbyController {
	
	@Inject
	private LobbyBusinessInterface service;
	
	//Add a new lobby to the ArrayList
	public String addLobby()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		Lobby lobby = context.getApplication().evaluateExpressionGet(context, "#{lobby}", Lobby.class);
		
		service.addLobby(new Lobby(0, lobby.getName(), "host", lobby.getPassword(), 0));

		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("lobby", lobby);
		
		//Refresh the page with new lobby displayed
		return "main.xhtml";
	}
	
	public LobbyBusinessInterface getService() {
		return service;
	}
}

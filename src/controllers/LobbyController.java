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
import interfaces.UserBusinessInterface;
import models.Lobby;

@ManagedBean
@ViewScoped
public class LobbyController {
	
	@Inject
	private LobbyBusinessInterface service;
	
	@Inject
	private UserBusinessInterface userService;
	
	//Add a new lobby to the ArrayList
	public String addLobby()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		Lobby lobby = context.getApplication().evaluateExpressionGet(context, "#{lobby}", Lobby.class);
		
		if(userService.getLoggedUser().getId() == -1) return "login.xhtml";
		
		service.addLobby(new Lobby(0, lobby.getName(), userService.getLoggedUser().getUsername(), lobby.getPassword(), 1));

		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("lobby", lobby);
		
		//Refresh the page with new lobby displayed
		return "main.xhtml";
	}
	
	public String joinLobby()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//Lobby lobby = context.getApplication().evaluateExpressionGet(context, "#{lobby}", Lobby.class);
		Lobby lobby = new Lobby();
		
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		lobby = service.getLobbyFromId(Integer.parseInt(id));
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("lobby", lobby);
		
		return "lobby.xhtml";
	}
	
	public String updateLobby()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		Lobby lobby = context.getApplication().evaluateExpressionGet(context, "#{lobby}", Lobby.class);
		
		if(userService.getLoggedUser().getId() == -1) return "login.xhtml";
		
		boolean updateStatus = service.updateLobby(lobby.getId(), lobby.getName(), lobby.getPassword());
		
		lobby = service.getLobbyFromId(lobby.getId());
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("lobby", lobby); 
		
		return "lobby.xhtml";
	}
	
	public LobbyBusinessInterface getService() {
		return service;
	}
}

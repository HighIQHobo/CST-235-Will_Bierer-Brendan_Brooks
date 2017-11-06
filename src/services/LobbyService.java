//Authors: Will Bierer, Brendan Brooks
// Class: CST-235
// Prof. Reha
// 
// File Description: Service for Lobby Model that contains an ArrayList of Lobbies
package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import data.LobbyDataService;
import interfaces.LobbyBusinessInterface;
import models.Lobby;

@Stateless
@Local(LobbyBusinessInterface.class)
public class LobbyService implements LobbyBusinessInterface 
{
	
	//public List<Lobby> lobbies = new ArrayList<Lobby>();
	private LobbyDataService service;
	private Lobby currentLobby = new Lobby();

	public LobbyService()
	{
		//service = new LobbyDataService();
		//lobbies = service.getLobbies();
	}
	//get the entire list
	public List<Lobby> getLobbies()
	{
		service = new LobbyDataService();
		List<Lobby> lobbies = service.getLobbies();
		return lobbies;
	}
	
	public Lobby getLobbyFromId(int id)
	{
		Lobby lobby = new Lobby();
		service = new LobbyDataService();
		
		lobby = service.getLobbyFromId(id);
		
		return lobby;
	}
	
	//add a new lobby to the list
	public void addLobby(Lobby lobby)
	{
		service = new LobbyDataService();
		service.addLobby(lobby);
	}
	public Lobby getCurrentLobby() {
		return currentLobby;
	}
	public void setCurrentLobby(Lobby currentLobby) {
		this.currentLobby = currentLobby;
	}
	
	@Override
	public boolean updateLobby(int id, String name, String password) {
		service = new LobbyDataService();
		boolean status = service.updateLobby(id, name, password);
		
		return status;
	}
	
	@Override
	public boolean deleteLobby(int id) {
		service = new LobbyDataService();
		boolean status = service.deleteLobby(id);
		return status;
	}
	
}

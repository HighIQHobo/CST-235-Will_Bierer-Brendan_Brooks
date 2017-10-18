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

import interfaces.LobbyBusinessInterface;
import models.Lobby;

@Stateless
@Local(LobbyBusinessInterface.class)
public class LobbyService implements LobbyBusinessInterface 
{
	
	public List<Lobby> lobbies = new ArrayList<Lobby>();

	public LobbyService()
	{
		for(int i = 0; i < 8; i++)
		{
			lobbies.add(new Lobby(i, "Lobby " + i, "HostUser" + i, null, 1));
		}
	}
	//get the entire list
	public List<Lobby> getLobbies()
	{
		return this.lobbies;
	}
	//add a new lobby to the list
	public void addLobby(Lobby lobby)
	{
		lobbies.add(lobby);
	}
	
}

package services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import models.LobbyModel;

@ManagedBean
@ViewScoped
public class LobbyService {
	
	public List<LobbyModel> lobbies = new ArrayList<LobbyModel>();

	public LobbyService()
	{
		for(int i = 0; i < 8; i++)
		{
			lobbies.add(new LobbyModel(i, "Lobby " + i, "HostUser" + i, null, 1));
		}
	}
	
	public List<LobbyModel> getLobbies()
	{
		return this.lobbies;
	}
	
	public void addLobby(LobbyModel lobby)
	{
		lobbies.add(lobby);
	}
	
}

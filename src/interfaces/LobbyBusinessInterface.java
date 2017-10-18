package interfaces;

import java.util.List;

import models.LobbyModel;

public interface LobbyBusinessInterface
{
	public List<LobbyModel> getLobbies();
	public void addLobby(LobbyModel lobby);
}

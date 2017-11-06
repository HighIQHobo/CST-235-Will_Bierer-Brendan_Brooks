//Authors: Will Bierer, Brendan Brooks
// Class: CST-235
// Prof. Reha
// 
// File Description: Interface for the LobbyService
package interfaces;

import java.util.List;

import models.Lobby;
import models.User;

public interface LobbyBusinessInterface
{
	public List<Lobby> getLobbies();
	public void addLobby(Lobby lobby);
	public Lobby getCurrentLobby(); //may need to remove
	public void setCurrentLobby(Lobby currentLobby);
	public Lobby getLobbyFromId(int id);
	public boolean updateLobby(int id, String name, String password);
	public boolean deleteLobby(int id);
}

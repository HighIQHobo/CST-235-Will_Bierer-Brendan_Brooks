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
}

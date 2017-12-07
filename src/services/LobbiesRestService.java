//Created By: William Bierer, Brendan Brooks.
//Description: REST Service API for the lobbies

package services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import interfaces.LobbyBusinessInterface;
import models.Lobby;

@RequestScoped
@Path("/lobby")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class LobbiesRestService {
	
	//inject the lobbyService used for getting data on the lobbies
	@Inject
	LobbyBusinessInterface service;
	
	//Create a URI that gets all the lobbies and displays them as JSON
	@GET
	@Path("/getlobby")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lobby> getAllLobbies()
	{
		return service.getLobbies();
	}
	
	//Create a URI that gets one of the lobbies based on the lobbyname that was entered in the URI and displays it as JSON
	@GET
	@Path("/getlobby/{lobbyname}")
	@Produces(MediaType.APPLICATION_JSON)
	public Lobby getLobbyByName(@PathParam("lobbyname") String lobbyname)
	{
		//Use a for each loop to get all the lobbies that correlate with the lobbyname from the URI
		for (Lobby l : service.getLobbies())
		{
			if(l.getName().equals(lobbyname))
			{
				return l;
			}
		}
		return null;
	}
}

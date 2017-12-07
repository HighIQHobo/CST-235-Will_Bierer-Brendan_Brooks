//Created By: William Bierer, Brendan Brooks.
//Description: REST Service API for the Users

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

import interfaces.UserBusinessInterface;
import models.User;

@RequestScoped
@Path("/user")
@Produces({"application/xml", "applcation/json"})
@Consumes({"application/xml", "applcation/json"})
public class UsersRestService {

	//inject the UserService used for getting data on the Users
	@Inject
	UserBusinessInterface service;
	
	//Create a URI that gets all the Users and displays them as JSON
	@GET
	@Path("/getuser")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers()
	{
		return service.getUserList();
	}
	
	//Create a URI that gets one of the Users based on the firstname that was entered in the URI and displays it as JSON
	@GET
	@Path("/getuser/{firstname}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByName(@PathParam("firstname") String firstname)
	{
		//Use a for each loop to get all the users that correlate with the firstname from the URI
		for (User u : service.getUserList())
		{
			if (u.getFirstName().equals(firstname))
			{
				return u;
			}	
		}
		return null;
	}
	
}

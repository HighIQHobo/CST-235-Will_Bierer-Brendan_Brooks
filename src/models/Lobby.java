//Authors: Will Bierer, Brendan Brooks
// Class: CST-235
// Prof. Reha
// 
// File Description: Model for a lobby
package models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ViewScoped
@ManagedBean
public class Lobby {
	public int id;
	@NotNull(message = "Required field")
	@Size(min=2, max=25)
	public String name;
	public String host;
	public String password;
	public int players;
	
	public Lobby() {
		this.id = 0;
		this.name = "";
		this.host = "";
		this.password = "";
		this.players = 1;
	}
	
	public Lobby(int id, String name, String host, String password, int players) {
		super();
		this.id = id;
		this.name = name;
		this.host = host;
		this.password = password;
		this.players = players;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPlayers() {
		return players;
	}
	public void setPlayers(int players) {
		this.players = players;
	}

}

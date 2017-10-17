package models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class LobbyModel {
	public int id;
	public String name;
	public String host;
	public String password;
	public int players;
	
	public LobbyModel(int id, String name, String host, String password, int players) {
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

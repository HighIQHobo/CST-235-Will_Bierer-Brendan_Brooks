package models;

import javax.faces.bean.*;

@ManagedBean
@ViewScoped
public class LobbyFormModel {

	private String name;
	private String password;

	public LobbyFormModel() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

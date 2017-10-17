package models;

import javax.faces.bean.*;

@ManagedBean
@SessionScoped
public class LobbyFormModel {

	public String name;
	public String password;

	public LobbyFormModel() {
		name = "LobbyName";
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

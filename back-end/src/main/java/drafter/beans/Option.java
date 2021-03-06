package drafter.beans;

import java.util.ArrayList;
import java.util.List;

import drafter.domain.User;

public class Option {
	public String id;
	public String name;
	public String surname;
	public String username;
	public String photo;
	public String organization;
	public String role;
	public Boolean hasAttended;
	public List<Option> users;
	

	public Option(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Option(String id, String name, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		List<Option> optionalUsers = new ArrayList<Option>();
		for(User u: users) {
			Option o = new Option();
			o.id = new Integer(u.getId()).toString();
			o.name = u.getName();
			o.surname = u.getSurname();
			o.photo = u.getPhoto();
			optionalUsers.add(o);
		}
		this.users = optionalUsers;
	}
	
	public Option(String id, String name, String organization) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
	}
	
	public Option(String id, String name, String organization, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.photo = photo;
	}
	
	public Option(String id, String name, String organization, String photo, String role, String username) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.photo = photo;
		this.role = role;
		this.username = username;
	}
	
	public Option() {
		super();
	}
	
	
	
	public String getRole() {
		return role;
	}
	public void setString(String role) {
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public List<Option> getUsers() {
		return users;
	}

	public void setUsers(List<Option> users) {
		this.users = users;
	}

	public Boolean getHasAttended() {
		return hasAttended;
	}

	public void setHasAttended(Boolean hasAttended) {
		this.hasAttended = hasAttended;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}

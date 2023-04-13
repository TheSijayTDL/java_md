package model.users;

import java.security.MessageDigest;

import model.Page;
import model.Post;
import model.PostType;
import service.MainService;

public abstract class User  extends GuestUser{
	private String username;
	private String encodedPassword;
	private String name;//for Business User it will be name of owner
	private String surname;
	
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String inputUsername) {
		if(inputUsername != null && inputUsername.matches("[a-z0-9.]{8,20}")) {
			username = inputUsername;
		}
		else
		{
			username = "default.user";
		}
	}
	public String getEncodedPassword() {
		return encodedPassword;
	}
	public void setEncodedPassword(String inputEncodedPassword) {
		if(inputEncodedPassword != null && inputEncodedPassword.matches("[A-Za-z0-9]{3,20}")) {
			//TODO find out simple password encoder 
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(inputEncodedPassword.getBytes());
				encodedPassword = new String(md.digest());
			}
			catch (Exception e) {
				encodedPassword = "defaultpassword";
			}
		}
		else
		{
			encodedPassword = "defaultpassword";
		}
		
	}
	//TODO verification in setName and setSurname
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public User() {
		super();
		setUsername("default.user");
		setEncodedPassword("defaultpassword");
		setName("Defaultname");
		setSurname("Defaultsurname");
	}
	
	public User(String name, String surname, String username, String password) {
		super();
		setName(name);
		setSurname(surname);
		setUsername(username);
		setEncodedPassword(password);
	}
	
	
	public String toString() {
		return "RU No." + getGeneratedId() + ": " + name + " " + surname + ", " + username;
	}
	
	
	
	public boolean login() {
		for(User temp: MainService.allRegisterdUsers) {
			if(temp.getUsername().equals(username) 
					&& temp.getEncodedPassword().equals(encodedPassword))
			{
				return true;
			}
		}
		return false;
		
	}
	
	public void followPage(Page page) throws Exception {
		if(page == null) {
			throw (new Exception("Page not found"));
		}
		
		page.addFollower(this);
		
	}
	
	//TODO unFollowPage
	
	public abstract Post createPost(Post post, PostType type);
	
	

}

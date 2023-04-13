package model;

import java.util.ArrayList;

import model.users.User;

public class Page {
	private String title;
	private String description;
	private ArrayList<User> followers = new ArrayList<>();
	private ArrayList<Post> postsInPage = new ArrayList<>();
	
	public Page() {
		setTitle("Unknown");
		setDescription("Unknown");
	}
	
	public Page(String title, String description) {
		setTitle(title);
		setDescription(description);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public ArrayList<User> getFollowers() {
		return followers;
	}
	
	public ArrayList<Post> getPostsInPage() {
		return postsInPage;
	}
	
	public void setTitle(String title) {
		if (title != null && title.length() > 4 && title.length() < 31) {
			this.title = title;
		} else {
			this.title = "Unknown";
		}
	}
	
	public void setDescription(String description) {
		if (description != null && description.length() > 10 && description.length() < 300) {
			this.description = description;
		} else {
			this.description = "Unknown";
		}
	}
	
	public void addFollower(User follower) {
		if (!followers.contains(follower)) {
			followers.add(follower);
		}
	}
	
	public void removeFollower(User follower) {
		if (followers.contains(follower)) {
			followers.remove(follower);
		}
	}
	
	public void addPostInPage(Post post) {
		if (post != null) {
			postsInPage.add(post);	
		}
	}
	
	public void removePostInPage(Post post) {
		if (post != null && postsInPage.contains(post)) {
			postsInPage.remove(post);
		}
	}
	
	public String toString() {
		return title + "( " + description + ") --> " + postsInPage + " --> Followers: " + followers.size();
	}
}

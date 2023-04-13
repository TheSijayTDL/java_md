package model.users;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.PostType;

public class BusinessUser extends User {
	
	private ArrayList<Page> allPages = new ArrayList<>();
	
	public BusinessUser(String name, String surname, String username, String password) {
		super(name, surname, username, password);
	}
	
	public ArrayList<Page> getAllPages() {
		return allPages;
	}
	
	public void addPage(Page page) {
		if (page != null && !allPages.contains(page)) {
			allPages.add(page);
		}
	}
	
	// TODO removePage()

	@Override
	public Post createPost(Post post, PostType type) {
		if (post != null) {
			return post;
		} else {
			return new Post();
		}
	}
	
	public void createPostInPage(Page page, Post post) {
		if (page != null && post != null && !page.getPostsInPage().contains(post)) {
			page.getPostsInPage().add(post);
		}
	}
	
}

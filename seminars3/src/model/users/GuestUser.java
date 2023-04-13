package model.users;

import java.util.ArrayList;

import model.Page;
import model.Post;
import service.MainService;

public class GuestUser {
	private long generatedId;
	private static long idCounter = 0;

	public long getGeneratedId() {
		return generatedId;
	}

	public void setGeneratedId() {
		this.generatedId = idCounter++;
	}

	public GuestUser() {
		setGeneratedId();
	}

	public String toString() {
		return "GU No." + generatedId;
	}

	// TODO add toLowerCase()
	public ArrayList<User> findUsersByNameOrSurnameOrUsername(String inputWord) {

		ArrayList<User> result = new ArrayList<>();
		if (inputWord != null) {
			for (User temp : MainService.allRegisterdUsers) {
				if (temp.getName().contains(inputWord) || temp.getSurname().contains(inputWord)
						|| temp.getUsername().contains(inputWord)) {
					result.add(temp);
				}
			}
		}
		return result;
	}

	public ArrayList<Page> findPagesByTitleOrDescription(String inputWord) {
		ArrayList<Page> result = new ArrayList<>();

		if (inputWord != null) {
			for (User temp : MainService.allRegisterdUsers) {
				if (temp instanceof BusinessUser) {
					BusinessUser bUserTemp = (BusinessUser) temp;
					for (Page tempPage : bUserTemp.getAllPages()) {
						if (tempPage.getTitle().toLowerCase().contains(inputWord.toLowerCase())
								|| tempPage.getDescription().toLowerCase().contains(inputWord.toLowerCase())) {
							result.add(tempPage);
						}
					}
				}
			}
		}

		return result;

	}

	public ArrayList<Post> findPublicPostsInPrivateUserOrInPage(String inputWord) {
		// create arrayList of Posts
		ArrayList<Post> result = new ArrayList<>();
		
		if(inputWord != null)
		{
			for (User temp : MainService.allRegisterdUsers) {
				if(temp instanceof PrivateUser)
				{
					PrivateUser pUserTemp = (PrivateUser)temp;
					for(Post tempPost: pUserTemp.getAllPublicPosts()) {
						if(tempPost.getMsg().toLowerCase().contains(inputWord.toLowerCase())) {
							result.add(tempPost);
						}
					}
				}
				else if(temp instanceof BusinessUser) {
					BusinessUser bUserTemp = (BusinessUser) temp;
					for(Page tempPage: bUserTemp.getAllPages()) {
						for(Post tempPost: tempPage.getPostsInPage()) {
							if(tempPost.getMsg().toLowerCase().contains(inputWord.toLowerCase())) {
								result.add(tempPost);
							}
						}
					}
				}
			}
		}
		
		// search using all users
		// 1. if user is Private
		// 1.1. retrieve all public posts of each private user
		// 2. if user is Business
		// 2.1. retrieve all Pages of each business user
		// 2.2. retrieve all posts of each page

		// retur Arraylist of Posts
		
		return result;
	}

}

package dao;

import java.util.List;

import model.Caption;
import model.Category;
import model.User;

public interface Dao {
	public int saveUser(User u);
	public User getUser(String username,String password);
	public List<Category> getAllCategories();
	public List<Caption> getCaptions(String category,String lang,int page);
	public int addCaption(Caption c);
	public int getTotalNumberOfCaptions(String category,String lang);
	public List<User> searchUsers(String name);
	public List<Caption> searchCaption(String query,int page);
	public int getTotalNumberOfSearchCaptions(String query);
	public int getNumberOfPostsOfUser(int uid);
	public int getNumberOfPostsLikedByUser(int uid);
	public List<Caption> getCaptionOfUser(int uid,int page);
}

package services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Service;

import dao.DaoImpl;
import model.Caption;
import model.Category;
import model.User;

@Service
public class UserServices {
	@Autowired
	private DaoImpl daoimpl;
	
	public int saveUser(User u) {
		int r = daoimpl.saveUser(u);
		return r;
	}
	
	public User getUser(String username,String password) {
		return this.daoimpl.getUser(username,password);
	}
	
	public List<Category> getCategories(){
		return this.daoimpl.getAllCategories();
	}
	public int saveCaption(Caption c) {
		int r = this.daoimpl.addCaption(c);
		return r;
	}
	public List<Caption> getCaptions(String category, String lang, int page){
		return this.daoimpl.getCaptions(category, lang, page);
	}
	public int getTotalNumberOfCaptions(String Category,String lang) {
		return this.daoimpl.getTotalNumberOfCaptions(Category, lang);
	}
	public List<User> searchUsers(String name){
		return this.daoimpl.searchUsers(name);
	}
	public List<Caption> searCaptions(String query,int page){
		return this.daoimpl.searchCaption(query,page);
	}
	public int getTotalNumberOfSearchCaptions(String query) {
		return this.daoimpl.getTotalNumberOfSearchCaptions(query);
	}
	
	public int getNumberOfPostsOfUser(int uid) {
		return this.daoimpl.getNumberOfPostsOfUser(uid);
	}

	public int getNumberOfPostsLikedByUser(int uid) {
		return this.daoimpl.getNumberOfPostsLikedByUser(uid);
	}
	
	public List<Caption> getCaptionOfUser(int uid, int page) {
		return this.daoimpl.getCaptionOfUser(uid, page);
	}
}

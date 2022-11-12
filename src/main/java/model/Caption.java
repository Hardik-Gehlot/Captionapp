package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="caption")
public class Caption {
	@Id
	@GeneratedValue
	private int pid;
	private String language,category,caption;
	private int likes,shares,uid;
	public Caption() {
		super();
		likes = 0;
		shares = 0;
		uid = 0;
	}
	@Override
	public String toString() {
		return "Caption [pid=" + pid + ", language=" + language + ", category=" + category + ", caption=" + caption
				+ ", likes=" + likes + ", shares=" + shares + ", uid=" + uid + "]";
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getShares() {
		return shares;
	}
	public void setShares(int shares) {
		this.shares = shares;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Caption(int pid, String language, String category, String caption, int likes, int shares, int uid) {
		super();
		this.pid = pid;
		this.language = language;
		this.category = category;
		this.caption = caption;
		this.likes = likes;
		this.shares = shares;
		this.uid = uid;
	}
	
	
}

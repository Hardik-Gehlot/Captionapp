package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	private int uid;
	private String username;
	private String email;
	private String password;
	private String profile;
	
	public User() {
		super();
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(int uid, String username, String email, String password, String profile) {
		super();
		this.uid = uid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", profile=" + profile + "]";
	}
	
	
	
}

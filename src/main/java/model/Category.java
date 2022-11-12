package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue
	private int catid;
	private String cname;
	private String cimage;
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCimage() {
		return cimage;
	}
	public void setCimage(String cimage) {
		this.cimage = cimage;
	}
	public Category(int catid, String cname, String cimage) {
		super();
		this.catid = catid;
		this.cname = cname;
		this.cimage = cimage;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [catid=" + catid + ", cname=" + cname + ", cimage=" + cimage + "]";
	}
}

package priv.MyBlog.po;

import java.io.Serializable;

public class Permission implements Serializable{

	private int id;
	private String name;
	private String percode;
	private char available;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPercode() {
		return percode;
	}
	public void setPercode(String percode) {
		this.percode = percode;
	}
	public char getAvailable() {
		return available;
	}
	public void setAvailable(char available) {
		this.available = available;
	}
	
}

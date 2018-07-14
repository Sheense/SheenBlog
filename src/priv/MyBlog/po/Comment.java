package priv.MyBlog.po;

import java.util.Date;

public class Comment {

	private int ID;
	private int bid;
	private String content;
	private String uname;
	private Date time;
	private int respond;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getRespond() {
		return respond;
	}
	public void setRespond(int respond) {
		this.respond = respond;
	}
	
}

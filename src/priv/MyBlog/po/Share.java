package priv.MyBlog.po;

import java.util.Date;

public class Share {

	private int id;
	private String title;
	private Date time;
	private String content;
	private String author;
	private int watchnum;
	private String introduction;
	private String skeys;
	private String simplepic;
	
	public int getWatchnum() {
		return watchnum;
	}
	public void setWatchnum(int watchnum) {
		this.watchnum = watchnum;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getSkeys() {
		return skeys;
	}
	public void setSkeys(String skeys) {
		this.skeys = skeys;
	}
	public String getSimplepic() {
		return simplepic;
	}
	public void setSimplepic(String simplepic) {
		this.simplepic = simplepic;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	
}

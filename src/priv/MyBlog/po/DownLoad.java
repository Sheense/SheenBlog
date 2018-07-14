package priv.MyBlog.po;

import java.io.Serializable;
import java.util.Date;

public class DownLoad implements Serializable{

	private int id;
	private String title;
	private Date time;
	private String content;
	private String introduction;
	private String simplepic;
	private int watchnum;
	private String dkeys;
	
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getSimplepic() {
		return simplepic;
	}
	public void setSimplepic(String simplepic) {
		this.simplepic = simplepic;
	}
	public String getDkeys() {
		return dkeys;
	}
	public void setDkeys(String dkeys) {
		this.dkeys = dkeys;
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
	public int getWatchnum() {
		return watchnum;
	}
	public void setWatchnum(int watchnum) {
		this.watchnum = watchnum;
	}

	
}

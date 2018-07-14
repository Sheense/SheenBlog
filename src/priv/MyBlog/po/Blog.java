package priv.MyBlog.po;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable{

	private int id;
	private String title;
	private Date time;
	private String fromwhere;
	private String bkey;
	private String author;
	private String content;
	private String type;
	private int praiseNum;
	private int scanNum;
	private String pic;
	private String introduction;
	
	
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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
	
	public String getBkey() {
		return bkey;
	}
	public void setBkey(String bkey) {
		this.bkey = bkey;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPraiseNum() {
		return praiseNum;
	}
	public void setPraiseNum(int praiseNum) {
		this.praiseNum = praiseNum;
	}
	public int getScanNum() {
		return scanNum;
	}
	public void setScanNum(int scanNum) {
		this.scanNum = scanNum;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public String getFromwhere() {
		return fromwhere;
	}
	public void setFromwhere(String fromwhere) {
		this.fromwhere = fromwhere;
	}
	@Override
	public String toString() {
		return "Blog [ID=" + id + ", title=" + title + ", time=" + time + ", fromwhere=" + fromwhere + ", bkey=" + bkey
				+ ", author=" + author + ", content=" + content + ", type=" + type + ", praiseNum=" + praiseNum
				+ ", scanNum=" + scanNum + ", pic=" + pic + ", introduction=" + introduction + "]";
	}
	
}

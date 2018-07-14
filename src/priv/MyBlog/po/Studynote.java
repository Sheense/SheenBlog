package priv.MyBlog.po;

import java.io.Serializable;
import java.util.Date;

public class Studynote implements Serializable{

	private int id;
	private String title;
	private String content;
	private String introduction;
	private String author;
	private Date time;
	private String nkeys;
	private String simplepic;
	private int scanNum;
	private String type;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getNkeys() {
		return nkeys;
	}
	public void setNkeys(String nkeys) {
		this.nkeys = nkeys;
	}
	public String getSimplepic() {
		return simplepic;
	}
	public void setSimplepic(String simplepic) {
		this.simplepic = simplepic;
	}
	
	public int getScanNum() {
		return scanNum;
	}
	public void setScanNum(int scanNum) {
		this.scanNum = scanNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

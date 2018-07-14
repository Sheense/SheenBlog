package priv.MyBlog.po;

import java.io.Serializable;

/**
 * 
 * @author sheen
 *
 */
public class BlogCustom extends Blog implements Serializable{

	private String time_string;

	public String getTime_string() {
		return time_string;
	}

	public void setTime_string(String time_string) {
		this.time_string = time_string;
	}

	public BlogCustom getBlogCustom() {
		return this;
	}
	
}

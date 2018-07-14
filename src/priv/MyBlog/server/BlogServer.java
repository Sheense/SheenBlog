package priv.MyBlog.server;

import java.util.List;

import priv.MyBlog.po.Blog;
import priv.MyBlog.po.BlogCustom;

public interface BlogServer {

	public List<BlogCustom> selectBlogList(BlogCustom blogCustom) throws Exception;
	public List<BlogCustom> selectAllType() throws Exception;
	public void insertBlog(Blog blog) throws Exception;
	public BlogCustom selectBlogAll(String id) throws Exception;
	public List<BlogCustom>  selectRinkList() throws Exception;
	public void deleteBlog(String id) throws Exception;
	public void updateBlog(BlogCustom blogCustom) throws Exception;
	public void addScanum(String id) throws Exception;
}

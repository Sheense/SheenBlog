package priv.MyBlog.mapper;

import java.util.List;

import priv.MyBlog.po.Blog;
import priv.MyBlog.po.BlogCustom;

public interface BlogMapper {

	public List<BlogCustom> selectBlogAtPart(BlogCustom blogCustom) throws Exception;
	public BlogCustom selectBlogAll(int id) throws Exception;
	public void writeBlog(Blog blog) throws Exception;
	public List<BlogCustom> selectAllType() throws Exception;
	public List<BlogCustom> selectRinkList() throws Exception;
	public void deleteBlog(int id) throws Exception;
	public void updateBlog(BlogCustom blogCustom) throws Exception;
	public void addScanNum(int id) throws Exception;
}
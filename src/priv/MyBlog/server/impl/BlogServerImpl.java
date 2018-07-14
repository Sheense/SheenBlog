package priv.MyBlog.server.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;



import org.springframework.beans.factory.annotation.Autowired;

import priv.MyBlog.Redis.RedisUtil;
import priv.MyBlog.mapper.BlogMapper;
import priv.MyBlog.po.Blog;
import priv.MyBlog.po.BlogCustom;
import priv.MyBlog.server.BlogServer;
import priv.MyBlog.util.LogUtil;

public class BlogServerImpl implements BlogServer{

	@Autowired
	private BlogMapper blogMapper;


	@Override
	public List<BlogCustom> selectBlogList(BlogCustom blogCustoms) throws Exception {
		// TODO Auto-generated method stub
		if(blogCustoms.getBkey()==null&&blogCustoms.getType()==null) {
			@SuppressWarnings("unchecked")
			List<BlogCustom> list = (List<BlogCustom>)RedisUtil.get("Blog_list");
			if(list!=null) {
				LogUtil.info(BlogServer.class, "Blog_list进入缓存");
				//System.out.println("Blog_list进入缓存");
				return list;
			}
		}
		//查询数据库
		List<BlogCustom> list = blogMapper.selectBlogAtPart(blogCustoms);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<list.size();i++) {
			list.get(i).setTime_string(sdf.format(list.get(i).getTime()));
		}
		
		//缓存初始化界面
		if(blogCustoms.getBkey()==null&&blogCustoms.getType()==null) {
			RedisUtil.set("Blog_list", list, 0, null);
		}
		return list;
	}

	@Override
	public List<BlogCustom> selectAllType() throws Exception {
		
		@SuppressWarnings("unchecked")
		List<BlogCustom> list = (List<BlogCustom>)RedisUtil.get("type");
		
		if(list==null) {
			list = blogMapper.selectAllType();
			RedisUtil.set("type",list, 0, null);
		}else {
			LogUtil.info(BlogServer.class, "type进入缓存");
			//System.out.println("type进入缓存");
		}
		return list;
	}

	@Override
	public void insertBlog(Blog blog) throws Exception {
		// TODO Auto-generated method stub
		if(blog.getFromwhere().equals("0")) {
			blog.setFromwhere("原创");
		}
		
		if(blog.getFromwhere().equals("1")){
			blog.setFromwhere("转载");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		Date date = sdf.parse(time);
		blog.setTime(date);
		//博文写入数据库
		blogMapper.writeBlog(blog);
		
		
		//缓存类型
		List<BlogCustom> list = blogMapper.selectAllType();
		RedisUtil.set("type",list, 0, null);
		
		//清空缓存初始化内容
		RedisUtil.set("Blog_list",list, 0, null);
	}

	@Override
	public BlogCustom selectBlogAll(String id) throws Exception {
		BlogCustom blogCustom = (BlogCustom)RedisUtil.get("Blog_"+id);
		if(blogCustom==null) {
			int id_ = Integer.parseInt(id);
			 blogCustom= blogMapper.selectBlogAll(id_);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(blogCustom!=null) {
				blogCustom.setTime_string(sdf.format(blogCustom.getTime()));
			}
			RedisUtil.set("Blog_"+id, blogCustom, 1, TimeUnit.DAYS);
		}else {
			LogUtil.info(BlogServer.class, "Blog_"+id+"进入缓存");
			//System.out.println("Blog_"+id+"进入缓存");
		}
		
		return blogCustom;
	}

	@Override
	public List<BlogCustom> selectRinkList() throws Exception {
		@SuppressWarnings("unchecked")
		List<BlogCustom> list = (List<BlogCustom>)RedisUtil.get("Blog_RinkList");
		if(list==null) {
			list= blogMapper.selectRinkList();
			if(list.size()>=12) {
				list=list.subList(0, 12);
			}else {
				List<BlogCustom> list1 = new ArrayList<BlogCustom>();		
				List<BlogCustom> l = list.subList(0, list.size());	
				for(int i=0;i<l.size();i++) {
					list1.add(l.get(i));
				}
				l = null;
				list = list1;
			}
			RedisUtil.set("Blog_RinkList", list, 7, TimeUnit.DAYS);
		}else {
			LogUtil.info(BlogServer.class, "Blog_RinkList进入缓存");
			//System.out.println("Blog_RinkList进入缓存");
		}
		
		return list;
	}

	@Override
	public void deleteBlog(String id) throws Exception {
		int id_ = Integer.parseInt(id);
		blogMapper.deleteBlog(id_);
		//清空缓存
		RedisUtil.set("Blog_"+id, null, 0, null);
	}

	@Override
	public void updateBlog(BlogCustom blogCustom) throws Exception {
		// TODO Auto-generated method stub
		blogMapper.updateBlog(blogCustom);
		//清空缓存
		RedisUtil.set("Blog_"+blogCustom.getId(), null, 0, null);
	}

	@Override
	public void addScanum(String id) throws Exception {
		// TODO Auto-generated method stub
		blogMapper.addScanNum(Integer.parseInt(id));
	}

}

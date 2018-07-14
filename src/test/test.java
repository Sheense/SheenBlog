package test;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import priv.MyBlog.mapper.BlogMapper;
import priv.MyBlog.po.Blog;
import priv.MyBlog.po.BlogCustom;
import priv.MyBlog.server.BlogServer;

public class test {

	public static void main(String arg[]) throws Exception {
		Md5Hash md = new Md5Hash("密码","盐",1);
		System.out.println(md.toString());
	}
}

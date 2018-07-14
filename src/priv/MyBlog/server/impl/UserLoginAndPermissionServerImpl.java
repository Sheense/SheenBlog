package priv.MyBlog.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import priv.MyBlog.mapper.UserMapper;
import priv.MyBlog.po.Permission;
import priv.MyBlog.po.User;
import priv.MyBlog.server.UserLoginAndPermissionServer;

public class UserLoginAndPermissionServerImpl implements UserLoginAndPermissionServer{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findUserByEmail(String email) throws Exception{
		return userMapper.findUserByEmail(email);
	}

	@Override
	public List<Permission> findPermissionById(int id) throws Exception {
		
		return userMapper.findPermissionById(id);
	}

	
}

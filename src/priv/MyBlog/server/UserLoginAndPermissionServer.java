package priv.MyBlog.server;

import java.util.List;

import priv.MyBlog.po.Permission;
import priv.MyBlog.po.User;

public interface UserLoginAndPermissionServer {

	public User findUserByEmail(String email) throws Exception;
	public List<Permission> findPermissionById(int id) throws Exception;
}

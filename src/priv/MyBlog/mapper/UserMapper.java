package priv.MyBlog.mapper;

import java.util.List;

import priv.MyBlog.po.Permission;
import priv.MyBlog.po.User;

public interface UserMapper {

	public User findUserByEmail(String email);
	public List<Permission> findPermissionById(int id);
}

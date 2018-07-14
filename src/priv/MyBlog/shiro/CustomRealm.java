package priv.MyBlog.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import priv.MyBlog.po.ActiveUser;
import priv.MyBlog.po.User;
import priv.MyBlog.server.UserLoginAndPermissionServer;

public class CustomRealm  extends AuthorizingRealm{

	public CustomRealm() {
		super();
	}
	@Autowired
	private UserLoginAndPermissionServer userLoginAndPermissionServer;
	
	// 设置realm的名称
	@Override
	public void setName(String name) {
			super.setName("customRealm");
	}
	//用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
			// TODO Auto-generated method stub
	    
		String userCode = (String) token.getPrincipal();
		User user=null;
		try {
			user=userLoginAndPermissionServer.findUserByEmail(userCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(user);
		if(user==null) return null;
		ActiveUser activeUser = new ActiveUser();
		activeUser.setId(user.getId());
		activeUser.setName(user.getName());
		activeUser.setPassword(user.getPassword());
		activeUser.setSalt(user.getSalt());
		activeUser.setUserCode(user.getEmail());
		try {
			activeUser.setPermissions(userLoginAndPermissionServer.findPermissionById(user.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//将activeUser设置simpleAuthenticationInfo
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
						activeUser, user.getPassword(),ByteSource.Util.bytes(user.getSalt()), this.getName());
		return simpleAuthenticationInfo;
	}
	//用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();
		List<String> permissions = new ArrayList<String>();
		for(int i=0;i<activeUser.getPermissions().size();i++) {
			permissions.add(activeUser.getPermissions().get(i).getPercode());
		}
		//查到权限数据，返回授权信息(要包括 上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
				//将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		simpleAuthorizationInfo.addStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}


}

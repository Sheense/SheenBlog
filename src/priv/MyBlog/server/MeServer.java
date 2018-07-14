package priv.MyBlog.server;

import priv.MyBlog.po.Me;

public interface MeServer {

	public Me selectMe() throws Exception;
	public void updateMe(Me me) throws Exception;
}

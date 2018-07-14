package priv.MyBlog.mapper;

import priv.MyBlog.po.Me;

public interface MeMapper {

	public Me selectMe() throws Exception;
	public void updateMe(Me me) throws Exception;
}

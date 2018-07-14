package priv.MyBlog.server.impl;

import org.springframework.beans.factory.annotation.Autowired;

import priv.MyBlog.Redis.RedisUtil;
import priv.MyBlog.mapper.MeMapper;
import priv.MyBlog.po.Me;
import priv.MyBlog.server.DownloadServer;
import priv.MyBlog.server.MeServer;
import priv.MyBlog.util.LogUtil;

public class MeServerImpl implements MeServer{

	@Autowired
	private MeMapper meMapper;
	
	@Override
	public Me selectMe() throws Exception {
		Me me = (Me)RedisUtil.get("Me");
		if(me==null) {
			me =  meMapper.selectMe();
			RedisUtil.set("Me", me, 0, null);
		}else {
			LogUtil.info(MeServer.class, "Me进入缓存");
			//System.out.println("Me进入缓存");
		}
		return me;
	}

	@Override
	public void updateMe(Me me) throws Exception {
		// TODO Auto-generated method stub
		meMapper.updateMe(me);
		RedisUtil.set("Me", null, 0, null);
	}

}

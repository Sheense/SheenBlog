package priv.MyBlog.server.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import priv.MyBlog.Redis.RedisUtil;
import priv.MyBlog.mapper.WorksShareMapper;
import priv.MyBlog.po.DownLoadCustom;
import priv.MyBlog.po.Share;
import priv.MyBlog.po.ShareCustom;
import priv.MyBlog.server.StudynoteServer;
import priv.MyBlog.server.WorksShareServer;
import priv.MyBlog.util.LogUtil;

public class WorksShareServerImpl implements WorksShareServer{

	@Autowired
	private WorksShareMapper worksShareMapper;

	@Override
	public List<ShareCustom> findShareList() throws Exception {
		List<ShareCustom> list = (List<ShareCustom>)RedisUtil.get("Share_list");
		if(list==null) {
			list  = worksShareMapper.findShareList();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for(int i=0;i<list.size();i++) {
				list.get(i).setTime_string(sdf.format(list.get(i).getTime()));
			}
			RedisUtil.set("Share_list", list, 0, null);
		}else {
			LogUtil.info(WorksShareServer.class,"Share_list进入缓存");
			//System.out.println("Share_list进入缓存");
		}

		return list;
	}

	@Override
	public List<ShareCustom> findShareListByKeys(String key) throws Exception {
		List<ShareCustom> list = findShareList();
		if(key.equals("")) return list; 
		List<ShareCustom> result  = new ArrayList<ShareCustom>();
		for(int i=0;i<list.size();i++) {
		    if(list.get(i).getSkeys().contains(key)||list.get(i).getTitle().contains(key)) {
		    	result.add(list.get(i));
		    }
		}
		return result;
	}

	@Override
	public ShareCustom findShareAllById(String id) throws Exception {
		ShareCustom shareCustom = (ShareCustom)RedisUtil.get("Share_"+id);
		if(shareCustom==null) {
			int id_ = Integer.parseInt(id);
			shareCustom = worksShareMapper.findShareAllById(id_);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        shareCustom.setTime_string(sdf.format(shareCustom.getTime()));
	        RedisUtil.set("Share_"+id, shareCustom, 1, TimeUnit.DAYS);
		}else {
			LogUtil.info(WorksShareServer.class,"Share_"+id+"进入缓存");
			//System.out.println("Share_"+id+"进入缓存");
		}
		return shareCustom;
	}

	@Override
	public void insertWorksShare(Share share) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		Date date = sdf.parse(time);
		share.setTime(date);
		worksShareMapper.upLoadShare(share);
		RedisUtil.set("Share_list", null, 0, null);
	}

	@Override
	public void deleteWorksShare(String id) throws Exception {
		worksShareMapper.deleteWorksShare(Integer.parseInt(id));
		RedisUtil.set("Share_list", null, 0, null);

	}

	@Override
	public void updateWorksShare(ShareCustom shareCustom) throws Exception {
		worksShareMapper.updateWorksShare(shareCustom);
		RedisUtil.set("Share_list", null, 0, null);

	}

	@Override
	public void addWatchNum(String id) throws Exception {
		// TODO Auto-generated method stub
		worksShareMapper.addWatchNum(Integer.parseInt(id));
	}
	
	

}

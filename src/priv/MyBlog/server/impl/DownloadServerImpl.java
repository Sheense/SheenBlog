package priv.MyBlog.server.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import priv.MyBlog.Redis.RedisUtil;
import priv.MyBlog.mapper.DownLoadMapper;
import priv.MyBlog.po.DownLoad;
import priv.MyBlog.po.DownLoadCustom;
import priv.MyBlog.server.DiaryServer;
import priv.MyBlog.server.DownloadServer;
import priv.MyBlog.util.LogUtil;

public class DownloadServerImpl implements DownloadServer{

	@Autowired
	private DownLoadMapper downLoadMapper;
	
	
	@Override
	public List<DownLoadCustom> findDownLoadList() throws Exception {
		List<DownLoadCustom> list = (List<DownLoadCustom>)RedisUtil.get("Download_list");
		if(list==null) {
			list=downLoadMapper.findDownLoadList();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for(int i=0;i<list.size();i++) {
				list.get(i).setTime_string(sdf.format(list.get(i).getTime()));
			}
			RedisUtil.set("Download_list", list, 0, null);
		}else {
			LogUtil.info(DownloadServer.class, "Download_list进入缓存");
			//System.out.println("Download_list进入缓存");
		}
		
		return list;
	}
	

	@Override
	public List<DownLoadCustom> findDownLoadListByKeys(String key) throws Exception {
		List<DownLoadCustom> list = findDownLoadList();
		if(key.equals("")) return list; 
		List<DownLoadCustom> result  = new ArrayList<DownLoadCustom>();
		for(int i=0;i<list.size();i++) {
		    if(list.get(i).getDkeys().contains(key)||list.get(i).getTitle().contains(key)) {
		    	result.add(list.get(i));
		    }
		}
		return result;
	}


	@Override
	public DownLoadCustom findDownLoadAllById(String id) throws Exception {
		DownLoadCustom downLoadCustom = (DownLoadCustom)RedisUtil.get("Download_"+id);
		if(downLoadCustom==null) {
			int id_ = Integer.parseInt(id);
			downLoadCustom = downLoadMapper.findDownLoadAllById(id_);
		}else {
			LogUtil.info(DownloadServer.class, "Download_"+id+"进入缓存");
			//System.out.println("Download_"+id+"进入缓存");
			return downLoadCustom;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        downLoadCustom.setTime_string(sdf.format(downLoadCustom.getTime()));
        RedisUtil.set("Download_"+id, downLoadCustom, 1, TimeUnit.DAYS);
		return downLoadCustom;
	}


	@Override
	public void insertResource(DownLoad download) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		Date date = sdf.parse(time);
		download.setTime(date);
		downLoadMapper.uploadResource(download);
        RedisUtil.set("Download_list", null, 0, null);

	}


	@Override
	public void deleteResource(String id) throws Exception {
		// TODO Auto-generated method stub
		int id_ = Integer.parseInt(id);
		downLoadMapper.deleteResource(id_);
        RedisUtil.set("Download_"+id, null, 0, null);

	}


	@Override
	public void updateResource(DownLoadCustom downLoadCustom) throws Exception {
		// TODO Auto-generated method stub
		downLoadMapper.updateResource(downLoadCustom);
        RedisUtil.set("Download_"+downLoadCustom.getId(), null, 0, null);

	}


	@Override
	public void addWatchNum(String id) throws Exception {
		// TODO Auto-generated method stub
		downLoadMapper.addWatchNum(Integer.parseInt(id));
	}
	
	

}

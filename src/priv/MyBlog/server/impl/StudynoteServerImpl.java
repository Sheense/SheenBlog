package priv.MyBlog.server.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import priv.MyBlog.Redis.RedisUtil;
import priv.MyBlog.mapper.StudynoteMapper;
import priv.MyBlog.po.Studynote;
import priv.MyBlog.po.StudynoteCustom;
import priv.MyBlog.server.MeServer;
import priv.MyBlog.server.StudynoteServer;
import priv.MyBlog.util.LogUtil;

public class StudynoteServerImpl implements StudynoteServer {

	@Autowired
	private StudynoteMapper  studynoteMapper;
	
	@Override
	public List<StudynoteCustom> selectStudynote() throws Exception {
		@SuppressWarnings("unchecked")
		List<StudynoteCustom> list = (List<StudynoteCustom>)RedisUtil.get("Studynote_list");
		if(list==null) {
			list = studynoteMapper.selectStudynote();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for(int i=0;i<list.size();i++) {
				list.get(i).setTime_string(sdf.format(list.get(i).getTime()));
			}
			RedisUtil.set("Studynote_list", list, 0, null);
		}else {
			LogUtil.info(StudynoteServer.class, "Studynote_list进入缓存");
			//System.out.println("Studynote_list进入缓存");
		}
		return list;
	}

	@Override
	public List<StudynoteCustom> selectStudynoteByKey(String key) throws Exception {
		// TODO Auto-generated method stub
		List<StudynoteCustom> list = studynoteMapper.selectStudynote();
		List<StudynoteCustom> result = new ArrayList<StudynoteCustom>();
		for(StudynoteCustom item:list) {
			if(item.getNkeys().contains(key)||item.getTitle().contains(key)) {
				result.add(item);
			}
		}
		return result;
	}

	@Override
	public StudynoteCustom selectStudynoteAll(String id) throws Exception{
		StudynoteCustom result = (StudynoteCustom)RedisUtil.get("Studynote_"+id);
		if(result==null) {
			result = studynoteMapper.selectStudynoteAll(Integer.parseInt(id));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			result.setTime_string(sdf.format(result.getTime()));
			RedisUtil.set("Studynote_"+id, result, 1, TimeUnit.DAYS);
		}else {
			LogUtil.info(StudynoteServer.class,"Studynote_"+id+"进入缓存");
			//System.out.println("Studynote_"+id+"进入缓存");
		}
		
		return result;
	}

	@Override
	public void deleteStudynote(String id) throws Exception{
		// TODO Auto-generated method stub
		studynoteMapper.deleteStudynoteAll(Integer.parseInt(id));
		RedisUtil.set("Studynote_list", null, 0, null);
	}

	@Override
	public void updateStudynote(StudynoteCustom studynoteCustom) throws Exception{
		// TODO Auto-generated method stub
		studynoteMapper.updateStudynote(studynoteCustom);
		RedisUtil.set("Studynote_list", null, 0, null);
	}

	@Override
	public void insertStudynote(Studynote studynote) throws Exception{
		// TODO Auto-generated method stub
		studynote.setTime(new Date());
        studynoteMapper.insertStudynote(studynote);
        RedisUtil.set("Studynote_list", null, 0, null);
	}

	@Override
	public void addScanNum(String id) throws Exception {
		// TODO Auto-generated method stub
		studynoteMapper.addScanNum(Integer.parseInt(id));
	}

}

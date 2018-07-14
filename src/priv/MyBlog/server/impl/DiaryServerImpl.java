package priv.MyBlog.server.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import priv.MyBlog.Redis.RedisUtil;
import priv.MyBlog.mapper.DiaryMapper;
import priv.MyBlog.po.Diary;
import priv.MyBlog.po.DiaryCustom;
import priv.MyBlog.server.BlogServer;
import priv.MyBlog.server.DiaryServer;
import priv.MyBlog.util.LogUtil;

public class DiaryServerImpl implements DiaryServer{

	@Autowired
	private DiaryMapper diaryMapper;
	
	@Override
	public List<DiaryCustom> selectDiaryBy(int pagesize, int pageID) throws Exception {//pagesize=7;pageid=1
		@SuppressWarnings("unchecked")
		List<DiaryCustom> listAll = (List<DiaryCustom>)RedisUtil.get("Diary_list");
		if(listAll==null) {
			listAll=diaryMapper.selectDiary();
			RedisUtil.set("Diary_list", listAll, 1, TimeUnit.DAYS);
		}else {
			LogUtil.info(DiaryServer.class, "Diary_list进入缓存");
			//System.out.println("Diary_list进入缓存");
		}
		int diaryNum = listAll.size(); 
		int pageStart;//开始的索引
		int pageEnd;//结束的索引
		int pageNum;
		if(diaryNum%pagesize==0) {
			pageNum = diaryNum/pagesize;
		}else {
			pageNum = diaryNum/pagesize + 1;
		}
		if(diaryNum==0) {//查询没有数据返回页数空链表
			return listAll;
		}
		
		pageStart = (pageID-1)*pagesize;
		if(pagesize*pageID>diaryNum) {
			pageEnd = diaryNum-1;
		}else {
			pageEnd = pagesize*pageID-1;
		}
		
		List<DiaryCustom> result = new ArrayList<DiaryCustom>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=pageStart;i<=pageEnd;i++) {
			listAll.get(i).setTime_string(sdf.format(listAll.get(i).getTime()));
			result.add(listAll.get(i));
		}
		return result;
	}

	@Override
	public void deleteDiary(String id) throws Exception {
		// TODO Auto-generated method stub
		diaryMapper.deleteDiary(Integer.parseInt(id));
		RedisUtil.set("Diary_list", null, 0, null);
	}

	@Override
	public int diaryNum() throws Exception {
		List<DiaryCustom> listAll=diaryMapper.selectDiary();
		int diaryNum = listAll.size(); 
		return diaryNum;
	}

	@Override
	public void insertDiary(Diary diary) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		Date date = sdf.parse(time);
		diary.setTime(date);
		diaryMapper.insertDiary(diary);
		RedisUtil.set("Diary_list", null, 0, null);
	}

	@Override
	public int getPageNum(int pagesize) throws Exception {
		// TODO Auto-generated method stub
		List<DiaryCustom> listAll=diaryMapper.selectDiary();
		int diaryNum = this.diaryNum();
		int pageNum;
		if(diaryNum%pagesize==0) {
			pageNum = diaryNum/pagesize;
		}else {
			pageNum = diaryNum/pagesize + 1;
		}
		if(diaryNum==0) {
			pageNum=1;
		}
		return pageNum;
	}

	@Override
	public List<DiaryCustom> selectDiary() throws Exception {
		// TODO Auto-generated method stub
		List<DiaryCustom> list = diaryMapper.selectDiary();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<list.size();i++) {
			list.get(i).setTime_string(sdf.format(list.get(i).getTime()));
		}
		return diaryMapper.selectDiary();
	}

}

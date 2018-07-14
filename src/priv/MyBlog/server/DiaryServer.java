package priv.MyBlog.server;

import java.util.List;

import priv.MyBlog.po.Diary;
import priv.MyBlog.po.DiaryCustom;

public interface DiaryServer {

	public List<DiaryCustom> selectDiaryBy(int pagesize,int pageID) throws Exception;
	public void deleteDiary(String id) throws Exception;
	public int diaryNum() throws Exception;
	public void insertDiary(Diary diary) throws Exception;
	public int getPageNum(int pagesize) throws Exception;
	public List<DiaryCustom> selectDiary() throws Exception;
}

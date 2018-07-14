package priv.MyBlog.mapper;

import java.util.List;

import priv.MyBlog.po.Diary;
import priv.MyBlog.po.DiaryCustom;

public interface DiaryMapper {

	public List<DiaryCustom> selectDiary() throws Exception;
	public void deleteDiary(int id) throws Exception;
	public void insertDiary(Diary diary);
}

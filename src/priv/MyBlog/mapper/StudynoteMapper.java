package priv.MyBlog.mapper;

import java.util.List;

import priv.MyBlog.po.Studynote;
import priv.MyBlog.po.StudynoteCustom;

public interface StudynoteMapper {

	public List<StudynoteCustom> selectStudynote() throws Exception;
	public StudynoteCustom selectStudynoteAll(int id) throws Exception;
	public void deleteStudynoteAll(int id) throws Exception;
	public void updateStudynote(StudynoteCustom studynoteCustom) throws Exception;
	public void insertStudynote(Studynote studynote) throws Exception;
	public void addScanNum(int id) throws Exception;
}

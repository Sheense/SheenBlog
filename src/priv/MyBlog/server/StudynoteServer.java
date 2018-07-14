package priv.MyBlog.server;

import java.util.List;

import priv.MyBlog.po.Studynote;
import priv.MyBlog.po.StudynoteCustom;

public interface StudynoteServer {

	public List<StudynoteCustom> selectStudynote() throws Exception;
	public List<StudynoteCustom> selectStudynoteByKey(String key) throws Exception;
	public StudynoteCustom selectStudynoteAll(String id) throws Exception;
	public void deleteStudynote(String id) throws Exception;
	public void updateStudynote(StudynoteCustom studynoteCustom) throws Exception;
	public void insertStudynote(Studynote studynote) throws Exception;
	public void addScanNum(String id) throws Exception;
}

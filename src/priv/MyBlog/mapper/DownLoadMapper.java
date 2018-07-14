package priv.MyBlog.mapper;

import java.util.List;

import priv.MyBlog.po.DownLoad;
import priv.MyBlog.po.DownLoadCustom;

public interface DownLoadMapper {

	public List<DownLoadCustom> findDownLoadList() throws Exception;
	public DownLoadCustom findDownLoadAllById(int id) throws Exception;
	public void uploadResource(DownLoad download) throws Exception;
	public void deleteResource(int id) throws Exception;
	public void updateResource(DownLoadCustom downLoadCustom) throws Exception;
	public void addWatchNum(int id) throws Exception;
}

package priv.MyBlog.server;

import java.util.List;

import priv.MyBlog.po.DownLoad;
import priv.MyBlog.po.DownLoadCustom;

public interface DownloadServer {

	public List<DownLoadCustom> findDownLoadList() throws Exception;
    public List<DownLoadCustom> findDownLoadListByKeys(String key) throws Exception;
    public DownLoadCustom findDownLoadAllById(String id) throws Exception;
    public void insertResource(DownLoad download) throws Exception;
    public void deleteResource(String id) throws Exception;
    public void updateResource(DownLoadCustom downLoadCustom) throws Exception;
    public void addWatchNum(String id) throws Exception;
}

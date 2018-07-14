package priv.MyBlog.server;

import java.util.List;

import priv.MyBlog.po.Share;
import priv.MyBlog.po.ShareCustom;



public interface WorksShareServer {

	public List<ShareCustom> findShareList() throws Exception;
    public List<ShareCustom> findShareListByKeys(String key) throws Exception;
    public ShareCustom findShareAllById(String id) throws Exception;
    public void insertWorksShare(Share share) throws Exception;
    public void deleteWorksShare(String id) throws Exception;
    public void updateWorksShare(ShareCustom shareCustom) throws Exception;
    public void addWatchNum(String id) throws Exception;
}

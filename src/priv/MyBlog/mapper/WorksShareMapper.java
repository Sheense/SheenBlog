package priv.MyBlog.mapper;

import java.util.List;

import priv.MyBlog.po.DownLoadCustom;
import priv.MyBlog.po.Share;
import priv.MyBlog.po.ShareCustom;



public interface WorksShareMapper {

	public List<ShareCustom> findShareList();
	public ShareCustom findShareAllById(int id);
	public void upLoadShare(Share share);
	public void deleteWorksShare(int id) throws Exception;
	public void updateWorksShare(ShareCustom shareCustom) throws Exception;
	public void addWatchNum(int id) throws Exception;
}

package com.mo.plasmid.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.mo.plasmid.domain.Dict;
import com.mo.plasmid.domain.PageBean;
import com.mo.plasmid.domain.Plasmid;
import com.mo.plasmid.service.PlasmidService;
import com.mo.plasmid.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class PlasmidAction extends BaseAction implements ModelDriven<Plasmid> {
	
	private static final long serialVersionUID = -230768583472318174L;

	public Plasmid plasmid = new Plasmid();
	public Plasmid getModel() {
		// TODO Auto-generated method stub
		return plasmid;
	}
	
	private PlasmidService plasmidService;
	public void setPlasmidService(PlasmidService plasmidService) {
		this.plasmidService = plasmidService;
	}
	
	//文件上传相关属性
	// 要上传的文件
	private File upload;
	// 文件的名称
	private String uploadFileName;
	public String getUploadFileName() throws UnsupportedEncodingException {
//		return new String(uploadFileName.getBytes(), "utf-8");
		return uploadFileName;
	}

	// 文件的MIME的类型
	private String uploadContentType;
	//存储文件的父路径，applicationContext.xml手动赋值
	private String savePath;
	//文件包含路径的全名
	private String fileFullPath;
	
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getFileFullPath() {
		return fileFullPath;
	}
	public void setFileFullPath(String fileFullPath) {
		this.fileFullPath = fileFullPath;
	}
	
	public InputStream getDownloadFile() throws FileNotFoundException
    {
		System.out.println("进入到getDownloadFile()");
		if (fileFullPath!=null) {
			File file = new File(fileFullPath);
			if (file.exists()) {  //防止出现空指针异常
				InputStream is = new FileInputStream(file);
				System.out.println(fileFullPath);
				System.out.println(is);
				System.out.println("文件的原名字："+uploadFileName);
				System.out.println("执行了InputStream的构建");
				return is;
			}
			System.out.println("附件不存在！");
		}
		return null;
    }
	
	public String downloadFile() throws IOException{
		plasmid=plasmidService.findById(plasmid.getP_id());
		fileFullPath=plasmid.getP_filePath();
		uploadFileName=plasmid.getP_uploadFileName();
		//对要传递的文件名进行转码     
		uploadFileName=URLEncoder.encode(uploadFileName, "UTF-8");
		System.out.println(plasmid);
		System.out.println("获取的文件路径名："+fileFullPath);
		//判断附件是否存在
		if (!new File(fileFullPath).exists()) {
			System.out.println("文件不存在！");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("附件不存在！");
			return null;
		}
		System.out.println("下载操作已经完成");
		return "download";
	}
	
	
	public String update() throws IOException{
		//判断是否上传了新附件
		if(uploadFileName != null){
			//判断附件手否存在
			String oldFilePath=plasmid.getP_filePath();
			if (oldFilePath!=null && !oldFilePath.trim().isEmpty()) {
				File file = new File(oldFilePath);
				file.delete();
			}
			//处理新上传的附件
			String uuidname = UploadUtils.getUUIDName(uploadFileName);
			// 创建file对象
			File file1 = new File(savePath+uuidname);
			FileUtils.copyFile(upload, file1);
			// 把上传的文件的路径，保存到客户表中
			plasmid.setP_filePath(savePath+uuidname);
			//将上传文件的原名保存到数据库
			plasmid.setP_uploadFileName(uploadFileName);
		}

		System.out.println("更新："+plasmid);
		plasmidService.update(plasmid);
		return "update";
	}
	public String initUpdate(){
		plasmid=plasmidService.findById(plasmid.getP_id());
		System.out.println("根据Id进行查询并返回一个Plasmid对象："+plasmid);
		return "initUpdate";
	}
	//根据p_id进行删除
	public String delete(){
		plasmid=plasmidService.findById(plasmid.getP_id());
		//判断附件手否存在
		String filePath=plasmid.getP_filePath();
		if (filePath!=null && !filePath.trim().isEmpty()) {
			File file = new File(filePath);
			file.delete();
		}
		System.out.println("即将删除："+plasmid);
		plasmidService.delete(plasmid);
		return "delete";
	}
	
	//分页查询
	public String findByPage(){
		System.out.println("进入到PlamidAction的findByPage方法");
		System.out.println(plasmid);
		DetachedCriteria criteria = DetachedCriteria.forClass(Plasmid.class);
		String p_plasmidNumber=plasmid.getP_plasmidNumber();
		if(p_plasmidNumber != null && !p_plasmidNumber.trim().isEmpty()){
			criteria.add(Restrictions.like("p_plasmidNumber", "%"+p_plasmidNumber+"%"));
		}
		String p_name=plasmid.getP_name();
		if(p_name != null && !p_name.trim().isEmpty()){
			criteria.add(Restrictions.like("p_name", "%"+p_name+"%"));
		}
		Dict constructor=plasmid.getConstructor();
		if(constructor != null && !constructor.getDict_id().trim().isEmpty()){
			criteria.add(Restrictions.like("constructor.dict_id", "%"+constructor.getDict_id()+"%"));
		}
		
		PageBean<Plasmid> pageBean=plasmidService.findByPage(criteria,getPageCode(),getPageSize());
		System.out.println(pageBean);
		System.out.println("查询完成，准备压入值栈");
		setVs("pageBean", pageBean);
		return "pageBean";
	}
	
	public String findAll(){
		List<Plasmid> findAll = plasmidService.fandAll();
		System.out.println(findAll);
		ActionContext.getContext().getValueStack().set("findAll", findAll);;
		return "findAll";
	}
	
	public String  save() throws IOException{
		//判断附件是否存在
		if(uploadFileName != null){
			plasmid.setP_uploadFileName(uploadFileName);
			// 打印
			System.out.println("文件类型："+uploadContentType);
			// 获取唯一文件名
			String uuidname = UploadUtils.getUUIDName(uploadFileName);
			// 创建file对象
			File file = new File(savePath+uuidname);
			FileUtils.copyFile(upload, file);
			// 把上传的文件的路径，保存到客户表中
			plasmid.setP_filePath(savePath+uuidname);
			//将上传文件的原名保存到数据库
			plasmid.setP_uploadFileName(uploadFileName);
		}
		plasmidService.save(plasmid);
		return "save";
	}

}

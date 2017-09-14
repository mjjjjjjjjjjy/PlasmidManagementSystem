package com.mo.plasmid.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.xerces.impl.xpath.regex.REUtil;
import org.jaxen.pattern.NoNodeTest;

import com.mo.plasmid.domain.User;
import com.mo.plasmid.service.UserService;
import com.mo.plasmid.utils.MD5Utils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends BaseAction implements ModelDriven<User> {
	
	private static final long serialVersionUID = -7901684097522086819L;
	
	User user = new User();
	public User getModel() {
		return user;
	}
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//退出登录
	public String exit(){
		String user_code = user.getUser_code();
		ServletActionContext.getRequest().getSession().removeAttribute("loginUser");
		return LOGIN;
	}
	
	//验证用户名和密码
	public String login() throws IOException{
		//获取用户名和密码
		String user_code = user.getUser_code();
		String user_password=user.getUser_password();
		//对密码进行加密
		String MD5password=MD5Utils.md5(user_password);
		System.out.println("加密后的密码"+MD5password);
		List<User> list = userService.findByUserCode(user_code);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		
		//list中有返回值而且密码相同
		if (list != null && list.size()>0 && list.get(0).getUser_password().equals(MD5password)) {
			System.out.println("验证成功");
			//验证成功后将用户名保存到session中
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", user_code);
			return LOGIN;
		}else{
			//验证失败后
			response.getWriter().print("no");
			System.out.println("用户名和密码不正确");
			return NONE;

		}
	}
	//保存账户密码
	public String regist(){
		System.out.println("准备要保存的用户名："+user);
		//先进行判断数据库中是否有相同的用户名
		String user_code = user.getUser_code();
		List<User> list = userService.findByUserCode(user_code);
		if (list != null && list.size()>0) {
			System.out.println("用户名已经存在");
		}else {
			//对密码进行加密
			String user_password = user.getUser_password();
			user.setUser_password(MD5Utils.md5(user_password));
			userService.save(user);
			System.out.println("保存用户名成功");
		}
		return "checkCode";
	}
	//用于ajax验证用户名
	public String checkCode() throws IOException{
		System.out.println("即将验证的账户密码"+user);
		String user_code = user.getUser_code();
		List<User> list = userService.findByUserCode(user_code);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if (list != null && list.size()>0) {
			System.out.println("用户名已经存在");
			response.getWriter().print("no");
		}else {
			System.out.println("用户名可以使用");
		}
		return NONE;
	}

}

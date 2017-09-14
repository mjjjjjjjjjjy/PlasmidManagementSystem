package com.mo.plasmid.interceptor;

import org.apache.struts2.ServletActionContext;

import com.mo.plasmid.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceptor extends MethodFilterInterceptor {

	
	private static final long serialVersionUID = -4531945212399365976L;

	//登陆控制
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Object object = ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		if (object==null) {
			return "login";
		}
		return invocation.invoke();
	}

}

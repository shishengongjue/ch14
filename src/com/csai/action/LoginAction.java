package com.csai.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.csai.db.DBConn;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String adminusername;
	public String adminuserpassword;
	public String action;
	public String errormsg;
	
	@Override
	public String execute(){
		if("login".equals(action)){
			try {
				Connection conn=DBConn.createConn();
				String sql="select * from adminuser where adminusername=? and adminuserpassword=?";
				PreparedStatement statement=conn.prepareStatement(sql);
				statement.setString(1, adminusername);
				statement.setString(2, adminuserpassword);
				ResultSet rSet=statement.executeQuery();
				if(rSet.next()){
					ActionContext.getContext().getSession().put("adminusername", adminusername);
					ActionContext.getContext().getSession().put("adminuserpassword", adminuserpassword);
					ActionContext.getContext().getSession().put("adminuserrole", rSet.getString("adminuserrole"));
					DBConn.closeConn(conn);
					return SUCCESS;
				}else {
					errormsg="用户名或密码输入有误!";
				}
				DBConn.closeConn(conn);
			} catch (Exception e) {
				errormsg="数据库连接有误";
			}
		}
		return INPUT;
	}
}

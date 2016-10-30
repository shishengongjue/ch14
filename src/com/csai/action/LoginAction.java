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
	public String getAdminusername() {
		return adminusername;
	}
	public void setAdminusername(String adminusername) {
		this.adminusername = adminusername;
	}
	public String getAdminuserpassword() {
		return adminuserpassword;
	}
	public void setAdminuserpassword(String adminuserpassword) {
		this.adminuserpassword = adminuserpassword;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public String adminuserpassword;
	public String action;
	public String errormsg;
	
	@Override
	public String execute() throws Exception{
		if("login".equals(action)){
			try {
				Connection conn=DBConn.createConn();
				String sql="Select * from adminuser where adminusername=? and adminuserpassword=?";
				PreparedStatement statement=conn.prepareStatement(sql);
				statement.setString(1, adminusername);
				statement.setString(2, adminuserpassword);
				ResultSet rs=statement.executeQuery();
				if(rs.next()){
					ActionContext.getContext().getSession().put("adminusername", adminusername);
					ActionContext.getContext().getSession().put("adminuserpassword", adminuserpassword);
					ActionContext.getContext().getSession().put("adminuserrole", rs.getString("adminuserrole"));
					DBConn.closeConn(conn);
					return SUCCESS;
				}
			} catch (Exception e) {
				errormsg=new String("数据库连接有误！");
			}
		}
		return INPUT;
	}
}

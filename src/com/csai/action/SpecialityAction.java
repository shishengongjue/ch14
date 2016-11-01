package com.csai.action;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import com.csai.POJO.Speciality;
import com.csai.db.DBConn;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SpecialityAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String specialityname;
	public String getSpecialityname() {
		return specialityname;
	}
	public void setSpecialityname(String specialityname) {
		this.specialityname = specialityname;
	}
	public int getSpecialityid() {
		return specialityid;
	}
	public void setSpecialityid(int specialityid) {
		this.specialityid = specialityid;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int specialityid;
	public String action;
	@Override
	public String execute() throws Exception{
		Connection conn=DBConn.createConn();
		if("add".equals(action)){
			if(specialityname!=null&&specialityname.length()!=0)
			{
				String sql="select * from Speciality where SpecialityName=?";
				PreparedStatement preSqlselect=conn.prepareStatement(sql);
				preSqlselect.setString(1, specialityname);
				ResultSet rSet=preSqlselect.executeQuery();
				if(!rSet.next()){
					sql="insert into Speciality (SpecialityName) values(?)";
					PreparedStatement preSqlinsert=conn.prepareStatement(sql);
					preSqlinsert.setString(1, specialityname);
					preSqlinsert.executeUpdate();
				}
			}
		}
		
		if("del".equals(action)){
			String sql="delete from Speciality where SpecialityId=?";
			PreparedStatement preSqldel=conn.prepareStatement(sql);
			preSqldel.setInt(1, specialityid);
			preSqldel.executeUpdate();
		}
		
		//-------查询出已有的专业
		String sql="select * from Speciality";
		Statement state=conn.createStatement();
		ResultSet resultSet = state.executeQuery(sql);
		ArrayList<Speciality> specialityArray=new ArrayList<Speciality>();
		while (resultSet.next()) {
			Speciality speciality=new Speciality();
			speciality.setSpecialityId(resultSet.getInt("SpecialityId"));
			speciality.setSpecialityName(resultSet.getString("SpecialityName"));
			specialityArray.add(speciality);
		}
		@SuppressWarnings("unchecked")
		Map<String, ArrayList<Speciality>> request=(Map<String, ArrayList<Speciality>>)
				ActionContext.getContext().get("request");
		request.put("specialityArray", specialityArray);
		DBConn.closeConn(conn);
		return SUCCESS;
	}
	
	
}

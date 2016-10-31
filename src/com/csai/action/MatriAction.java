package com.csai.action;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import com.csai.POJO.Speciality;
import com.csai.POJO.Student;
import com.csai.db.DBConn;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MatriAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String action;
	public int specialityid;
	public String matrino;
	public String studentname;
	public int currentpage=1;
	public long studentid;
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getSpecialityid() {
		return specialityid;
	}
	public void setSpecialityid(int specialityid) {
		this.specialityid = specialityid;
	}
	public String getMatrino() {
		return matrino;
	}
	public void setMatrino(String matrino) {
		this.matrino = matrino;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public long getStudentid() {
		return studentid;
	}
	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}
	@Override
	public String execute() throws Exception{
		if(studentname!=null&&studentname.length()!=0)
			studentname=studentname.trim();
		if(action!=null&&action.length()!=0)
			action=action.trim();
		if(matrino!=null&&matrino.length()!=0)
			matrino=matrino.trim();
		Connection conn=DBConn.createConn();
		if("add".equals(action)){
			if(studentname!=null&&studentname.length()!=0
					&&matrino!=null&&matrino.length()!=0
					&&specialityid!=0){
				String sql="select * from Student where MatriNo=? and StudentName=? and SpecialityId=?";
				PreparedStatement preSqlselect=conn.prepareStatement(sql);
				preSqlselect.setString(1, matrino);
				preSqlselect.setString(2, studentname);
				preSqlselect.setInt(3, specialityid);
				ResultSet rSet=preSqlselect.executeQuery();
				if(!rSet.next()){
					sql="insert into Student(MatriNo,StudentName,SpecialityId) values (?,?,?)";
					PreparedStatement preSqlinsert = conn.prepareStatement(sql);
					preSqlinsert.setString(1, matrino);
					preSqlinsert.setString(2, studentname);
					preSqlinsert.setInt(3, specialityid);
					preSqlinsert.executeUpdate();
				}
			}
		}
		if("del".equals(action)){
			String sql="delete from Student where StudentId=?";
			PreparedStatement preSqlupdate=conn.prepareStatement(sql);
			preSqlupdate.setLong(1, studentid);
			preSqlupdate.executeUpdate();
		}
		
		ResultSet rsselct =null;
		int pagesize=5;//每页记录条数
		int pagecount=0;//总页数
		int recount=0;//总记录条数
		if("select".equals(action)){
			String sql=null;
			if(specialityid==0){
				sql="select StudentName,StudentId,MatriNo,SpecialityId from Student";
				String sqlcount="select count(*) as recount from Student ";
				Statement statement = conn.createStatement();
				ResultSet rscount=statement.executeQuery(sqlcount);
				rscount.next();
				recount=rscount.getInt("recount");//得到总记录条数
				
				if(recount%pagesize==0)
					pagecount=recount/pagesize;
				else 
					pagecount=recount/pagesize+1;
				if(pagecount>1&&currentpage>1){
					String sqladd=" order by StudentId desc limit "+(currentpage-1)*pagesize+","+pagesize;
					sql+=sqladd;
				}
				Statement state=conn.createStatement();
				rsselct=state.executeQuery(sql);
			}else {
				String sqlwhere=" where SpecialityId=? and StudentName like ?";
				sql="select StudentName,StudentId,MatriNo,SpecialityId from Student"+sqlwhere;
				String sqlcount="select count(*) as recount from Student"+sqlwhere;
				PreparedStatement preSqlcount=conn.prepareStatement(sqlcount);
				preSqlcount.setInt(1, specialityid);
				preSqlcount.setString(2,"%"+ studentname+"%");
				ResultSet rscount=preSqlcount.executeQuery();
				rscount.next();
				recount=rscount.getInt("recount");
				if(recount%pagesize==0)
					pagecount=recount/pagesize;
				else
					pagecount=recount/pagesize+1;
				
				PreparedStatement preSqlselect=null;
				if(pagecount>1&&currentpage>1){
					String sqladd=" order by StudentId desc limit"+(currentpage-1)*pagesize+","+pagesize;
					sql+=sqladd;
					preSqlselect=conn.prepareStatement(sql);
					preSqlselect.setInt(1, specialityid);
					preSqlselect.setString(2, "%"+studentname+"%");
				}else {
					sql=sql+"order by StudentId desc";
					preSqlselect=conn.prepareStatement(sql);
					preSqlselect.setInt(1, specialityid);
					preSqlselect.setString(2, "%"+studentname+"%");
				}
				rsselct=preSqlselect.executeQuery();
			}
		}
		ArrayList<Student> stuArray=new ArrayList<Student>();
		while(rsselct!=null&&rsselct.next()){
			Student stu=new Student();
			stu.setStudentName(rsselct.getString("StudentName"));
			stu.setSpecialityId(rsselct.getInt("SpecialityId"));
			stu.setMatriNo(rsselct.getString("MatriNo"));
			stu.setStudentId(rsselct.getLong("StudentId"));
			stuArray.add(stu);
		}
		
		@SuppressWarnings("unchecked")
		Map<String, Serializable> request=(Map<String, Serializable>)ActionContext.getContext().get("request");
		request.remove("stuArray");
		request.put("stuArray", stuArray);
		
		String sql="select * from Speciality";
		Statement state=conn.createStatement();
		ResultSet rSet=state.executeQuery(sql);
		ArrayList<Speciality> specialityArray=new ArrayList<Speciality>();
		while(rSet.next()){
			Speciality speciality=new Speciality();
			speciality.setSpecialityId(rSet.getInt("SpecialityId"));
			speciality.setSpecialityName(rSet.getString("SpecialityName"));
			specialityArray.add(speciality);
		}
		
		request.remove("specialityArray");
		request.put("specialityArray", specialityArray);
		//将数据放入request
		request.remove("pagesize");
		request.remove("pagecount");
		request.remove("currentpage");
		request.remove("recount");
		request.put("pagesize", pagesize);
		request.put("pagecount", pagecount);
		request.put("currentpage", currentpage);
		request.put("recount", recount);
		DBConn.closeConn(conn);
		return SUCCESS;
	}
}

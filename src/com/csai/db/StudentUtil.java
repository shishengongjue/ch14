package com.csai.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.csai.POJO.Speciality;

public class StudentUtil {
	//返回是否已分专业表述的字符串
	public static String havaSplitSpec(int specialityid){
		String returnString;
		try {
			Connection conn=DBConn.createConn();
			if(specialityid==0)
				returnString="尚无专业";
			else {
				String sql="select * from Speciality where SpecialityId="+specialityid;
				Statement statement=conn.createStatement();
				ResultSet rSet=statement.executeQuery(sql);
				if(rSet.next())
					returnString=rSet.getString("SpecialityName");
				else 
					returnString="尚无专业";
			}
			DBConn.closeConn(conn);
			return returnString;
		} catch (Exception e) {
			return null;
		}
	}
	//返回是否已分班表述的字符串
	public static String haveSplitClass(int classid){
		String string;
		try {
			Connection conn=DBConn.createConn();
			if(classid==0)
				string="尚未分班";
			else {
				String sql="select * from ClassTa where ClassId="+classid;
				Statement statement=conn.createStatement();
				ResultSet rSet=statement.executeQuery(sql);
				if(rSet.next())
					string=rSet.getString("ClassName");
				else 
					string="尚未分班";
			}
			DBConn.closeConn(conn);
			return string;
		} catch (Exception e) {
			return null;
		}
	}
	//返回是否已分配宿舍表述的字符串
		public static String haveSplitBedChamber(int bedchamberid){
			String string;
			try {
				Connection conn=DBConn.createConn();
				if(bedchamberid==0)
					string="尚未分配宿舍";
				else {
					String sql="select * from Bedchamber where BedchamberId="+bedchamberid;
					Statement statement=conn.createStatement();
					ResultSet rSet=statement.executeQuery(sql);
					if(rSet.next())
						string=rSet.getString("BedchamberName");
					else 
						string="尚未分配宿舍";
				}
				DBConn.closeConn(conn);
				return string;
			} catch (Exception e) {
				return null;
			}
		}
		//获取专业信息
		public static ArrayList<Speciality> specialities() throws Exception{
			Connection connection =DBConn.createConn();
			ArrayList<Speciality> spe = new ArrayList<Speciality>();
			String sql="select * from Speciality";
			Statement stae = connection.createStatement();
			ResultSet resultSet = stae.executeQuery(sql);
			while(resultSet.next()){
				Speciality spec = new Speciality();
				spec.setSpecialityId(resultSet.getInt("SpecialityId"));
				spec.setSpecialityName(resultSet.getString("SpecialityName"));
				spe.add(spec);
			}
			return spe;
		}
}

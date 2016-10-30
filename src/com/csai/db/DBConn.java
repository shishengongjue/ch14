package com.csai.db;
import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.jasper.tagplugins.jstl.core.Out;
public class DBConn {
	public static Connection createConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String string=null;
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/StudyTest?useUnicode=true&amp;characterEncoding=UTF-8","root","asdf1234");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeConn(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

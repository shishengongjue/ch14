package com.csai.POJO;

import java.sql.Date;

public class Student {
	public long StudentId;
	public String StudentName;
	public int SpecialityId;
	public int ClassId;
	public int BedchamberId;
	public String MatriNo;
	public float PayAmount;
	public int PayOk;
	public Date RegistDate;
	public long getStudentId() {
		return StudentId;
	}
	public void setStudentId(Long studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public int getSpecialityId() {
		return SpecialityId;
	}
	public void setSpecialityId(int specialityId) {
		SpecialityId = specialityId;
	}
	public int getClassId() {
		return ClassId;
	}
	public void setClassId(int classId) {
		ClassId = classId;
	}
	public int getBedchamberId() {
		return BedchamberId;
	}
	public void setBedchamberId(int bedchamberId) {
		BedchamberId = bedchamberId;
	}
	public String getMatriNo() {
		return MatriNo;
	}
	public void setMatriNo(String matriNo) {
		MatriNo = matriNo;
	}
	public float getPayAmount() {
		return PayAmount;
	}
	public void setPayAmount(float payAmount) {
		PayAmount = payAmount;
	}
	public int getPayOk() {
		return PayOk;
	}
	public void setPayOk(int payOk) {
		PayOk = payOk;
	}
	public Date getRegistDate() {
		return RegistDate;
	}
	public void setRegistDate(Date registDate) {
		RegistDate = registDate;
	}
}

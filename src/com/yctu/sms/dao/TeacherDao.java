package com.yctu.sms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;
import com.yctu.sms.model.Classes;
import com.yctu.sms.model.Teacher;
import com.yctu.sms.model.User;
import com.yctu.sms.util.JDBCutil;
import com.yctu.sms.util.MD5Util;

import jdk.nashorn.internal.ir.ReturnNode;

public class TeacherDao {
	int flag = 0;
	ResultSet rs = null;
	Connection conn = JDBCutil.getConnection();
	
	public Teacher login(String account,String passwd){ //登陆
		String passwdsalt = MD5Util.generate(passwd);
		
		try {
			Statement stamt = conn.createStatement();
			String sql = "select * from user where custom_id=\'"+account+"\' and password=\'"+passwdsalt+"\'";
			rs = stamt.executeQuery(sql);
			if(rs.next()){
				Teacher teacher = new Teacher();
				teacher.setCollege(rs.getString("college"));
				teacher.setUser_group(rs.getString("user_group"));
				return teacher;
			}
			JDBCutil.close(null,stamt,null,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ArrayList<User> GetUserInfoByTeacherCID(String custom_id){
		ArrayList<User> arrayList = new ArrayList<User>();
		try {
			Statement stamt = conn.createStatement();
			String sql = "select * from student s,user t,class c where s.classes = c.class_id and c.teacher = t.user_id and t.custom_id = '"+custom_id+"' and s.custom_id > 14000000";
			rs = stamt.executeQuery(sql);
			while(rs.next()){
				User user = new User();
				user.setAddress(rs.getString("address"));
				user.setCadre(rs.getString("cadre"));
				user.setCET(rs.getString("CET"));
				user.setCustom_id(rs.getInt("custom_id"));
				user.setDorm(rs.getString("dorm"));
				user.setEconomy(rs.getString("economy"));
				user.setID_card(rs.getString("ID_card"));
				user.setKaoyan(rs.getString("kaoyan"));
				user.setMail(rs.getString("mail"));
				user.setName(rs.getString("name"));
				user.setNation(rs.getString("nation"));
				user.setNCRE(rs.getString("NCRE"));
				user.setParent_tel(rs.getString("parent_tel"));
				user.setPolity(rs.getString("polity"));
				user.setPunishment(rs.getString("punishment"));
				user.setQq(rs.getString("qq"));
				user.setRuankao(rs.getString("ruankao"));
				user.setScholarship(rs.getString("scholarship"));
				user.setSex(rs.getString("sex"));
				user.setTel(rs.getString("tel"));
				user.setYear(rs.getInt("year"));
				arrayList.add(user);
			}
			JDBCutil.close(null,stamt,null,null);
			return arrayList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Teacher GetTeacherByCustom_ID(String custom_id){ //登陆
		
		try {
			Statement stamt = conn.createStatement();
			String sql = "select * from user where custom_id=\'"+custom_id+"\'";
			rs = stamt.executeQuery(sql);
			if(rs.next()){
				Teacher teacher = new Teacher();
				teacher.setCustom_id(rs.getInt("custom_id"));
				teacher.setName(rs.getString("name"));
				teacher.setPhone_number(rs.getString("phone_number"));
				teacher.setEmail(rs.getString("email"));
				teacher.setSpeciality(rs.getString("speciality"));
				return teacher;
			}
			JDBCutil.close(null,stamt,null,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Classes> GetClassByCollegeID(String collegeid) {
		ArrayList<Classes> arrayList = new ArrayList<Classes>();
		try {
			Statement stamt = conn.createStatement();
			String sql = "select * from class where college_id=\'"+collegeid+"\' and year >= 2013";
			rs = stamt.executeQuery(sql);
			while(rs.next()){
				Classes classes = new Classes();
				classes.setClass_id(rs.getInt("class_id")+"");
				classes.setName(rs.getString("name"));
				arrayList.add(classes);
			}
			JDBCutil.close(null,stamt,null,null);
			return arrayList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

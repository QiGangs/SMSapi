package com.yctu.sms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.yctu.sms.model.Teacher;
import com.yctu.sms.model.User;
import com.yctu.sms.servers.GetStuInfoServer;
import com.yctu.sms.util.JDBCutil;
import com.yctu.sms.util.MD5Util;


public class Userdao {
	int flag = 0;
	ResultSet rs = null;
	Connection conn = JDBCutil.getConnection();
	
	public Teacher login(String account,String passwd){ //登陆
		String passwdsalt = MD5Util.generate(passwd);
		
		try {
			Statement stamt = conn.createStatement();
			String sql = "select * from student where custom_id=\'"+account+"\' and password=\'"+passwdsalt+"\'";
			rs = stamt.executeQuery(sql);
			if(rs.next()){
				Teacher teacher = new Teacher();
				teacher.setCollege(rs.getInt("college")+"");
				return teacher;
				
			}
			JDBCutil.close(null,stamt,null,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String GetNameById(String id){   //根据useid查找姓名
		try {
			Statement stamt = conn.createStatement();
			String sql = "select * from user where user_id=\'"+id+"\'";
			rs = stamt.executeQuery(sql);
			if(rs.next()){
				return rs.getString("name");
			}
			JDBCutil.close(null,stamt,null,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "未知";
	}
	
	public User GetUserInfo(String custom_id){
		User user = new User();
		try {
			Statement stamt = conn.createStatement();
			String sql = "select st.*,cl.`name` as class_name,co.`name` as college_name ,de.`name` as department_name,us.`name` as teacher_name "
					+ "from student as st,college as co,class as cl,department as de,user as us "
					+ "where st.custom_id= "+custom_id
					+ " AND st.college = co.college_id and st.classes = cl.class_id and st.department = de.department_id and cl.teacher = us.user_id";
			rs = stamt.executeQuery(sql);
			if(rs.next()){
				user.setAddress(rs.getString("address"));
				user.setCadre(rs.getString("cadre"));
				user.setCET(rs.getString("CET"));
				user.setClasses(rs.getString("class_name"));
				user.setCollege(rs.getString("college_name"));
				user.setCustom_id(rs.getInt("custom_id"));
				user.setDepartment(rs.getString("department_name"));
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
				user.setTeacher(rs.getString("teacher_name"));
			}
			JDBCutil.close(null,stamt,null,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	public ArrayList<User> GetStuInfo(String college,String classes){
		ArrayList<User> arrayList = new ArrayList<User>();
		try {
			Statement stamt = conn.createStatement();
			String sql = "select * from student where college = "+college+" and classes = "+classes;
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
}

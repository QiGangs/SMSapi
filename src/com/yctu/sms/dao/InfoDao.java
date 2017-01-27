package com.yctu.sms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.yctu.sms.model.Assess;
import com.yctu.sms.model.Leave;
import com.yctu.sms.model.Notice;
import com.yctu.sms.util.JDBCutil;
import com.yctu.sms.util.MD5Util;

public class InfoDao {
	ResultSet rs = null;
	Connection conn = JDBCutil.getConnection();
	
	public ArrayList<Notice> GetPublicInfo(){     //获取校级公告
		ArrayList<Notice> array = new ArrayList<Notice>();
		Statement stamt;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		try {
			stamt = conn.createStatement();
			String sql = "select * from post where college=0";
			rs = stamt.executeQuery(sql);
			
			while(rs.next()){
				Notice notice = new Notice();
				notice.setId(rs.getInt("post_id"));
				notice.setAuthorid(rs.getInt("creator"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setTimenum(rs.getInt("create_time"));
				long lt = rs.getLong("create_time"); 
				String d = format.format(new Date(Long.valueOf(lt+"000")));
				notice.setTime(d);
				array.add(notice);
			}
			JDBCutil.close(null,stamt,null,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;
	}
	
	public ArrayList<Notice> GetPrivateInfo(String college,int type){  //院级公示
		ArrayList<Notice> array = new ArrayList<Notice>();
		Statement stamt;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		try {
			stamt = conn.createStatement();
			String sql = "select * from post where college="+college+" and type="+type;
			rs = stamt.executeQuery(sql);
			
			while(rs.next()){
				Notice notice = new Notice();
				notice.setId(rs.getInt("post_id"));
				notice.setAuthorid(rs.getInt("creator"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setTimenum(rs.getInt("create_time"));
				String d = format.format(new Date(Long.valueOf(rs.getLong("create_time")+"000")));
				notice.setTime(d);
				array.add(notice);
			}
			JDBCutil.close(null,stamt,null,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;
	}
	
	public void GetMoreInfoById(){  //获取详细信息
		
	}
	
	
	public ArrayList<Leave> GetLeaveInfoByCustom_id(String custom_id){    //获取请假信息
		ArrayList<Leave> array = new ArrayList<Leave>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Statement stamt; 
		try {
			stamt = conn.createStatement();
			String sql = "select l.reason,l.start_time,l.end_time,l.back_time,l.approve_user from `leave` as l where custom_id="+custom_id;
			rs = stamt.executeQuery(sql);
			while(rs.next()){
				Leave leave = new Leave();
				leave.setReason(rs.getString("reason"));
				String d = format.format(new Date(Long.valueOf(rs.getLong("start_time")+"000")));
				leave.setStart_time(d);
				d = format.format(new Date(Long.valueOf(rs.getLong("end_time")+"000")));
				leave.setBack_time(d);
				if(Long.valueOf(rs.getLong("back_time")) <= 0){
					d = "not xj";      //显示未注销
				}else{
					d = format.format(new Date(Long.valueOf(rs.getLong("back_time")+"000")));
				}
				leave.setEnd_time(d);	
				leave.setApprover(rs.getString("approve_user"));
				array.add(leave);
			}
			JDBCutil.close(null,stamt,null,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return array;
	}
	
	
	public ArrayList<Assess> GetAssessInfoByCustom_id(String custom_id,String start,String end){  //获取众测分信息
		ArrayList<Assess> array = new ArrayList<Assess>();
		Statement stamt;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		try {
			stamt = conn.createStatement();
			String sql = "SELECT * FROM assess where custom_id=14263422 and real_time >"+start+" and real_time < "+end;
			rs = stamt.executeQuery(sql);
			while(rs.next()){
				Assess assess = new Assess();
				assess.setDepartment(rs.getString("department"));
				assess.setScore(rs.getString("score"));
				assess.setWeek(rs.getInt("week"));
				assess.setReason(rs.getString("reason"));
				String d = format.format(new Date(Long.valueOf(rs.getInt("real_time")+"000")));
				assess.setTime(d);
				array.add(assess);
			}
			JDBCutil.close(null,stamt,null,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;
	}
}

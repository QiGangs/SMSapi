package com.yctu.sms.servers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yctu.sms.dao.InfoDao;
import com.yctu.sms.model.Assess;

/**
 * Servlet implementation class GetAssessInfoServer
 */
@WebServlet("/GetAssessInfoServer")
public class GetAssessInfoServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAssessInfoServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //手机客户端更具入学年份和当前年计算出应该有哪几学期，更具选择的学期查询对应的综测分
    //参数应该有学号和开始时间，结束时间！！！！！！！！！！！！！
    //例如:
    //http://115.159.92.239:8080/SMSinterface/GetAssessInfoServer?custom_id=14263422&start=2015-1-1&end=2016-7-1
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String custom_id = request.getParameter("custom_id");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		if(custom_id==null || start == null || end == null){
			response.sendRedirect("NotFount404.html");
			return;
		}
		
		InfoDao infodao = new InfoDao();
		ArrayList<Assess> array = new ArrayList<Assess>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			start = String.valueOf(sdf.parse(start).getTime()/1000);
			end = String.valueOf(sdf.parse(end).getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		array = infodao.GetAssessInfoByCustom_id(custom_id, start, end);
		
		Gson gson=new Gson();
		String infojson=gson.toJson(array);
		
		response.getWriter().println(infojson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

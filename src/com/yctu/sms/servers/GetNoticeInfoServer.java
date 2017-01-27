package com.yctu.sms.servers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yctu.sms.dao.InfoDao;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class GetNoticeInfoServer
 */
@WebServlet("/GetNoticeInfoServer")
public class GetNoticeInfoServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNoticeInfoServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //需要post参数college（学院）和type（代号）   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String college = request.getParameter("college");
		String type = request.getParameter("type");
		if(college==null){
			response.sendRedirect("NotFount404.html");
			return;
		}
		InfoDao infodao = new InfoDao();
		if(college.equals("0")){   //校级公告
			Gson gson=new Gson();
			String infojson=gson.toJson(infodao.GetPublicInfo());
			response.getWriter().println(infojson);
		}else{
			if(type.equals("1")){   //院
				JSONArray jsonarray = JSONArray.fromObject(infodao.GetPrivateInfo(college,1));
				response.getWriter().println(jsonarray);
			}else if(type.equals("2")){
				JSONArray jsonarray = JSONArray.fromObject(infodao.GetPrivateInfo(college,2));
				response.getWriter().println(jsonarray);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

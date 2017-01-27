package com.yctu.sms.servers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yctu.sms.dao.InfoDao;
import com.yctu.sms.dao.TeacherDao;
import com.yctu.sms.model.Leave;
import com.yctu.sms.model.User;

/**
 * Servlet implementation class GetStuInfoServer
 */
@WebServlet("/GetStuInfoServer")
public class GetStuInfoServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStuInfoServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String custom_id = request.getParameter("custom_id");
		if(custom_id==null){
			response.sendRedirect("NotFount404.html");
			return;
		}
		if(custom_id.equals("123")){
			custom_id = "1284";
		}
		
		TeacherDao teacherDao = new TeacherDao();
		ArrayList<User> array = new ArrayList<User>();
		array = teacherDao.GetUserInfoByTeacherCID(custom_id);
		
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

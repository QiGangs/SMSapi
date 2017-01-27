package com.yctu.sms.servers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.javafx.stage.EmbeddedWindow;
import com.yctu.sms.dao.TeacherDao;
import com.yctu.sms.dao.Userdao;
import com.yctu.sms.model.Teacher;
import com.yctu.sms.model.User;

/**
 * Servlet implementation class GetTeacherInfoServer
 */
@WebServlet("/GetTeacherInfoServer")
public class GetTeacherInfoServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTeacherInfoServer() {
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
		
		
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = teacherDao.GetTeacherByCustom_ID(custom_id);
		
		Gson gson=new Gson();
		response.getWriter().println(gson.toJson(teacher));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

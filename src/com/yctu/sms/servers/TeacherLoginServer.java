package com.yctu.sms.servers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yctu.sms.dao.TeacherDao;
import com.yctu.sms.dao.Userdao;
import com.yctu.sms.model.Teacher;

/**
 * Servlet implementation class TeacherLoginServer
 */
@WebServlet("/TeacherLoginServer")
public class TeacherLoginServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherLoginServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		if(account == null || passwd == null){
			response.sendRedirect("NotFount404.html");
			return;
		}
		
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = teacherDao.login(account, passwd);
		if(teacher != null){
			String flag = teacher.getUser_group();
			if(flag.equals("3") || flag.equals("4") || flag.equals("5") || flag.equals("6")){
			Gson gson = new Gson();
			response.getWriter().println(gson.toJson(teacher));
			}else{
				response.getWriter().println("errorx");
			}
		}else{
			response.getWriter().println("error");
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

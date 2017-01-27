package com.yctu.sms.servers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yctu.sms.dao.InfoDao;
import com.yctu.sms.dao.TeacherDao;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class GetClassesByCollegeIdServer
 */
@WebServlet("/GetClassesByCollegeIdServer")
public class GetClassesByCollegeIdServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetClassesByCollegeIdServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String college = request.getParameter("college");
		if(college==null){
			response.sendRedirect("NotFount404.html");
			return;
		}
		
		TeacherDao teacherDao = new TeacherDao();
		Gson gson = new Gson();
		response.getWriter().println(gson.toJson(teacherDao.GetClassByCollegeID(college)));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

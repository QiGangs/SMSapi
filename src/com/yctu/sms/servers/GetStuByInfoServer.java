package com.yctu.sms.servers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.ULongLongSeqHelper;

import com.google.gson.Gson;
import com.sun.swing.internal.plaf.metal.resources.metal_zh_TW;
import com.yctu.sms.dao.TeacherDao;
import com.yctu.sms.dao.Userdao;
import com.yctu.sms.model.User;

/**
 * Servlet implementation class GetStuByInfoServer
 */
@WebServlet("/GetStuByInfoServer")
public class GetStuByInfoServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStuByInfoServer() {
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
		String classes = request.getParameter("classes");
		
		if(college == null || classes == null){
			response.sendRedirect("NotFount404.html");
			return;
		}
		
		Userdao userdao = new Userdao();
		
		Gson gson=new Gson();
		response.getWriter().println(gson.toJson(userdao.GetStuInfo(college, classes)));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

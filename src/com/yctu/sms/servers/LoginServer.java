package com.yctu.sms.servers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yctu.sms.dao.Userdao;
import com.yctu.sms.model.Teacher;

/**
 * Servlet implementation class LoginServer
 */
@WebServlet("/LoginServer")
public class LoginServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //参数为 account(账号)和passwd(密码)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		if(account == null || passwd == null){
			response.sendRedirect("NotFount404.html");
			return;
		}
		Userdao userdao = new Userdao();
		Teacher teacher = userdao.login(account, passwd);
		if(teacher != null){
			teacher.setUser_group("-1");
			Gson gson = new Gson();
			response.getWriter().println(gson.toJson(teacher));
		}else{
			response.getWriter().println("errorstu");
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

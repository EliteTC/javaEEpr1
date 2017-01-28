package com.besedkin;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MyServlet extends HttpServlet {


	private final static String LOGIN = "LOGIN";
	private final static String PASSWORD = "PASSWORD";

/*
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("uname");
		String password = request.getParameter("psw");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		try {

			out.println("<html>");

			out.println("<head>");

			out.println("<title>Greeting page</title>");

			out.println("</head>");

			out.println("<body>");

			if(name.equals(LOGIN) && password.equals(PASSWORD)) {
				out.println("<h1>Hello "+name+"!!!</h1>");
			}
			else {
				out.println("User not recognized!!!");
			}

			out.println("</body>");

			out.println("</html>");



		} finally {

			out.close();

		}

	}
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("uname");
		String password = request.getParameter("psw");
		response.setContentType("text/html;charset=UTF-8");
		if(name.equals(LOGIN) && password.equals(PASSWORD)) {
			request.setAttribute("message", "Hello "+name+"!!");
		}
		else {
			request.setAttribute("message", "User not recognized!!");
		}
		
		RequestDispatcher view = request.getRequestDispatcher("response.jsp");
		view.forward(request, response);
		//processRequest(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request,response);
		//processRequest(request, response);

	}

}
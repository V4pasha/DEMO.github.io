package org.pasha.DemoApp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		int i=StudentDao.delete(username);
		PrintWriter out=resp.getWriter();
		out.println("<body style='background-image:url(\"img/photo4.jpg\"); background-size:cover;>"
				+"<h1 style='color:white;'>RECORD DELETED SUCESSFULLY</h1>"
				+"<form action='ViewServlet' method='post'>"
				+"<input type='submit' type='BACK'></form>"
				+"</body></html>");
		out.flush();
		out.close();
		
	}

}

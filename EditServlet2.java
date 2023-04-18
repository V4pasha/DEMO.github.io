package org.pasha.DemoApp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String name=req.getParameter("name");
		String username=req.getParameter("uname");
		String email=req.getParameter("email");
		String gender=req.getParameter("sex");
		String city=req.getParameter("city");
		String country=req.getParameter("country");
		String password=req.getParameter("pw");
		
		Student s=new Student();
		s.setName(name);
		s.setUsername(username);
		s.setEmail(email);
		s.setGender(gender);
		s.setCity(city);
		s.setCountry(country);
		s.setPassword(password);
		
		int status=StudentDao.update(s);
		if(status>0) {
			RequestDispatcher rd=req.getRequestDispatcher("ViewServlet");
			rd.forward(req, resp);
		}
		else {
			out.println("SORRY UNABLE TO UPDATE THE RECORD");
		}
		out.close();
	}

}

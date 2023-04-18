package org.pasha.DemoApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String name=req.getParameter("name");
		String username=req.getParameter("uname");
		String email=req.getParameter("email");
		String gender=req.getParameter("sex");
		String City=req.getParameter("city");
		String Country=req.getParameter("country");
		String password=req.getParameter("pw");
		
		Student s=new Student();
		s.setName(name);
		s.setUsername(username);
		s.setEmail(email);
		s.setGender(gender);
		s.setCity(City);
		s.setCountry(Country);
		s.setPassword(password);
		
		int status=StudentDao.save(s);
		if(status>0) {
			out.println("<h1>YOU HAVE LOGGED IN SUCCESSFULLY!!</h1>");
			req.getRequestDispatcher("LogIn.html").include(req, resp);
		}else {
			out.println("sorry! unable to save record");
		}
		out.close();
	}
	}

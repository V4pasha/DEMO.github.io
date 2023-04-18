package org.pasha.DemoApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<body style='background-image:url(\"img/photo6.jpg\"); background-size: cover;'>");
		out.println("<a href='SignUp.html'>ADD NEW STUDENT</a>");
		out.println("<h1>PASHA'S APP LIST</h1>");
		List<Student> list=StudentDao.getAllStudents();
		out.println("<table border='1' width='100%';");
		out.println("<tr><th>NAME</th><th>USERNAME</th><th>EMAIL</th><th>GENDER</th><th>CITY</th><th>COUNTRY</th><th>PASSWORD</th></tr>");
		for(Student s:list) {
			out.println("<tr><td>"+s.getName()+"</td><td>"+s.getUsername()+"</td><td>"+s.getEmail()+"</td><td>"+s.getGender()+"</td><td>"+s.getCity()
			+"</td><td>"+s.getCountry()+"</td><td>"+s.getPassword()+"</td><td><a href='EditServlet?username="+s.getUsername()+"'>EDIT</td></a><td><a href='DeleteServlet?username="+s.getUsername()+"'>DELETE</a></td></tr>");
		}
		out.print("</table>");
		out.println("</body>");
		out.close();
	}

}

package org.pasha.DemoApp;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<body sstyle='background-image:url(\"img/photo5.jpg\"); background-size: cover;'>"
				+"<h1>UPDATE EMPLOYEE</h1>");
		String username=req.getParameter("username");
		Student s=StudentDao.getStudentByusername(username);
		out.println("<form action='EditServlet2' method='post'>");
		out.println("<table>");
		out.println("<tr><td>NAME:-</td><td><input type='text' name='name' value='"+s.getName()+"'></td></tr>");
		out.println("<tr><td>USER-NAME:-</td><td><input type='text' name='uname' value='"+s.getUsername()+"'></td></tr>");
		out.println("<tr><td>G-MAIL:-</td><td><input type='text' name='Gmail' value='"+s.getEmail()+"'></td></tr>");
		out.println("<tr><td>GENDER:-</td><td><input type='text' name='sex' value='"+s.getGender()+"'></td></tr>");
		out.println("<tr><td>CITY:-</td><td><input type='text' name='city' value='"+s.getCity()+"'/></td></tr>");
		out.print("<tr><td>COUNTRY:-</td><td>");
		out.print("<select name='country' style='width=150px'><option>INDIA</option><option>CHINA</option>");
		out.print("<option>USA</option>");
		out.print("<option>GERMAN</option>");
		out.print("<option>OTHERS</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td>PASSWORD:-</td><td><input type='password' name='pw' value='"+s.getPassword()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='UPDATE' ></td></tr>");
		out.print("</table>");
		out.print("</form></body>");
		out.close();
	}

}

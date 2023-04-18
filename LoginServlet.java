package org.pasha.DemoApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.cert.CertPathValidatorException;

import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.validation.Validator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String username=req.getParameter("uname");
		String password=req.getParameter("pw");
		if(Validate.checkUser(username,password)) {
			RequestDispatcher rd=req.getRequestDispatcher("ViewServlet");
			rd.forward(req, resp);
		}
		else {
			out.println("USERNAME AND PASSWORD DOESN'T MATCH");
			RequestDispatcher rd=req.getRequestDispatcher("LogIn.html");
			rd.include(req, resp);
		}
	}

	}

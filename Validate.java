package org.pasha.DemoApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validate {
	static Connection con=null;
	static PreparedStatement pst=null;
	static boolean checkUser(String username,String pwd) {
		boolean st=false;
		con=StudentDao.getConnection();
		try {
			pst=con.prepareStatement("select *from demoapp1.userdetails where username=? and password=?");
			pst.setString(1, username);
			pst.setString(2, pwd);
			ResultSet rs=pst.executeQuery();
			st=rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
		
	}

}

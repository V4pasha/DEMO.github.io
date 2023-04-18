package org.pasha.DemoApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=shuveb");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static int save(Student s) {
		int status=0;
		Connection con=	StudentDao.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into demoapp1.userdetails values(?,?,?,?,?,?,?)");
			ps.setString(1, s.getName());
			ps.setString(2, s.getUsername());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getGender());
			ps.setString(5, s.getCity());
			ps.setString(6, s.getCountry());
			ps.setString(7, s.getPassword());
			status=ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	public static int update(Student s) {
		int status=0;
		Connection con=	StudentDao.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("update demoapp1.userdetails set nmae=?,username=?,email=?,gender=?,city=?,country=?,password=? where username=?");
			ps.setString(1, s.getName());
			ps.setString(2, s.getUsername());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getGender());
			ps.setString(5, s.getCity());
			ps.setString(6, s.getCountry());
			ps.setString(7, s.getPassword());
			ps.setString(8, s.getUsername());
			status=ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;	
	}
	public static int delete(String username) {
		int status=0;
		Connection con=StudentDao.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("delete from demoapp1.userdetails where username=?");
			ps.setString(1, username);
			status=ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	public static Student getStudentByusername(String username) {
		Student s=new Student();
		Connection con=StudentDao.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from demoapp1.userdetails where username=?");
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				s.setName(rs.getString(1));
				s.setUsername(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setGender(rs.getString(4));
				s.setCity(rs.getString(5));
				s.setCountry(rs.getString(6));
				s.setPassword(rs.getString(7));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public static List<Student> getAllStudents(){
		List<Student> list=new ArrayList<Student>();
		Connection con=StudentDao.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from demoapp1.userdetails");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Student s=new Student();
				s.setName(rs.getString(1));
				s.setUsername(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setGender(rs.getString(4));
				s.setCity(rs.getString(5));
				s.setCountry(rs.getString(6));
				s.setPassword(rs.getString(7));
				list.add(s);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}

package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/serLogin")
public class loginpage extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	String username = request.getParameter("username");
	String email = request.getParameter("email");
	String pass = request.getParameter("pass");
	
	 String pk = "regitration succesfull";

	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cs = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			PreparedStatement stmt = cs.prepareStatement("select * from register where username = ?, AND email = ? , AND pass = ?");
			stmt.setString(1, username);
			stmt.setString(2, email);
			stmt.setString(3, pass);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("okkkkk");
				PrintWriter out = response.getWriter();
				out.print("<h1>" + pk + "</h1>");
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}



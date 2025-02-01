package com.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/regServlet")
public class Registration extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		String pk = "registration successfull";
		PrintWriter out = response.getWriter();
		out.print("<h1>" + pk + "</h1>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cs = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			String query = "insert into register (username, email , pass) values (? , ? , ?) ";
			PreparedStatement ps = cs.prepareStatement(query);
			
			ps.setString(1, username);
			ps.setString(2 , email);
			ps.setString(3, pass);
			System.out.println("database connected succefully");
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
}

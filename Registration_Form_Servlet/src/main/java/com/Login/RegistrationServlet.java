package com.Login;

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

@WebServlet("/registrationservlet")
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String password = req.getParameter("password");

		String pk = "registration successfuly submitted";

		PrintWriter out = rep.getWriter();
		out.print("<h1>" + pk + "</h1>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cs = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			PreparedStatement stmt = cs
					.prepareStatement("INSERT INTO login(name, email, address, password) VALUES(?, ?, ?, ?)");
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, address);
			stmt.setString(4, password);
			System.out.println("database connected succefully");
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
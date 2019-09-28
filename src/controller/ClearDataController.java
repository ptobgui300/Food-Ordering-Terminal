package controller;

import java.io.IOException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;



import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;







@WebServlet("/kitchen/ClearData")

public class ClearDataController extends HttpServlet {

	private static final long serialVersionUID = 1L;





	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		Connection c = null;

		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu96";

			String username = "cs3220stu96";

			String password = ".ki7x#5L";



			c = DriverManager.getConnection(url, username, password);

			Statement stmt = c.createStatement();

			String id = (request.getParameter("id"));

			int rs = stmt.executeUpdate("DELETE FROM orders2");



			

			

		} catch (SQLException e) {

			throw new ServletException(e);

		} finally {

			try {

				if (c != null)

					c.close();

			} catch (SQLException e) {

				throw new ServletException(e);

			}

		}

		request.getRequestDispatcher("/WEB-INF/Clear.jsp").forward(request, response);



	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		doGet(request, response);

	}

}

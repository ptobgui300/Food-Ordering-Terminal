package controller;



import java.io.IOException;

import java.util.ArrayList;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;



import javax.servlet.ServletConfig;

import javax.servlet.ServletContext;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



@WebServlet("/kitchen/Admin")

public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;



	float cost;





	public void init(ServletConfig config) throws ServletException {



		super.init(config);



		ArrayList<String> entries = new ArrayList<String>();



		entries.add("Menus");

		entries.add("orders2");

		entries.add("tables");



		ServletContext context = this.getServletContext();

		context.setAttribute("dbEntries", entries);



	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {



		int i = 1;



		Connection c = null;

		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu96";

			String username = "cs3220stu96";

			String password = ".ki7x#5L";



			c = DriverManager.getConnection(url, username, password);

			Statement stmt = c.createStatement();



			ResultSet rs = stmt.executeQuery("SELECT SUM(cost) from orders2");



			while (rs.next()) {



			cost = rs.getFloat(i);

			}



		}



		catch (SQLException e) {

			throw new ServletException(e);

		} finally {

			try {

				if (c != null)

					c.close();

			} catch (SQLException e) {

				throw new ServletException(e);

			}

		}



		

		ServletContext context = this.getServletContext();

		context.setAttribute("cost", cost);



		

		request.getRequestDispatcher("/WEB-INF/Admin.jsp").forward(request, response);



	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		doGet(request, response);

	}



}
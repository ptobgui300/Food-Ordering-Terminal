package controller;

import java.io.IOException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;





import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



//Code that changes all items listed as completed in the Database to true making them not visible to the kitchen staff

//Items will be preserved in the orders2 database

//is run by Table.Jsp

//runs Update.jsp

//Do not start from this controller



@WebServlet("/kitchen/Clear")

public class DeleteOrderController extends HttpServlet {

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

			stmt.executeUpdate("UPDATE orders2 SET completed = 'true' WHERE orders LIKE '%(Completed)%'" );

			

			

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

		request.getRequestDispatcher("/WEB-INF/Update.jsp").forward(request, response);



	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		doGet(request, response);

	}

}
package controller;



import java.io.IOException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;



import javax.servlet.ServletConfig;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import models.Order;

import models.Table;



//Displays Current orders at each table

//Items clicked will be labeled as Completed

//Clear Button removes All completed items from queue

//Refresh Button will Refresh the display

//Uses Table.jsp as its main html

//Run this Controller for the Kitchen display



@WebServlet("/kitchen/Tables")

public class TableController extends HttpServlet {



	private static final long serialVersionUID = 1L;



	public void init(ServletConfig config) throws ServletException {

		super.init(config);



		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			throw new ServletException(e);

		}

	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		List<Table> tables = new ArrayList<Table>();

		List<Order> orders = new ArrayList<Order>();

		Connection c = null;

		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu96";

			String username = "cs3220stu96";

			String password = ".ki7x#5L";

			c = DriverManager.getConnection(url, username, password);

			Statement stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * from orders2");



			while (rs.next()) {



				Order order = new Order(rs.getInt("orderID"),rs.getInt("tableID"), rs.getString("orders"), 

						rs.getString("completed"), rs.getFloat("cost"));

				if (order.isCompleted() == false){

					orders.add(order);

				}

				

			}

			

			

			rs = stmt.executeQuery("SELECT * from tables");

			while (rs.next()) {

				Table table = new Table(rs.getInt("tableID"), rs.getString("tableNum"));

				tables.add(table);

			}

			

			

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



		request.setAttribute("tables", tables);

		request.setAttribute("orders", orders);

		request.getRequestDispatcher("/WEB-INF/Table.jsp").forward(request, response);

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		doGet(request, response);

	}



}
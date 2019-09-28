package controller;



import java.io.IOException;

import java.util.ArrayList;



import javax.servlet.ServletConfig;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import models.TableUser;



/**

 * Servlet implementation class CreateTable

 */



@WebServlet(urlPatterns = {"/kitchen/setup"}, loadOnStartup=1)

public class CreateTable extends HttpServlet {

		private static final long serialVersionUID = 1L;



		public void init(ServletConfig config) throws ServletException {

			super.init(config);

			

			// Create the Array of Users

			ArrayList<TableUser> users = new ArrayList<TableUser>();

			users.add(new TableUser("table1", "abcd"));

			users.add(new TableUser("table2", "abcd"));

			users.add(new TableUser("table3", "abcd"));

			users.add(new TableUser("table4", "abcd"));

			

			getServletContext().setAttribute("users", users);



		}

		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}



	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub

		doGet(request, response);

	}



}
package controller;



import java.io.IOException;

import java.io.PrintWriter;

import java.util.ArrayList;



import javax.servlet.ServletConfig;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import models.TableUser;







/**

 * Servlet implementation class Login

 */

@WebServlet("/kitchen/Login")

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

    

	public void init(ServletConfig config) throws ServletException {

		super.init(config);		

	}

	

    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    		

    		// Set the content type to HTML

    		response.setContentType("text/html");

    		

    		// Get a Print Writer

    		PrintWriter out = response.getWriter();

    		

    		// Generate the template HTML

    		out.println("<!DOCTYPE html>");		

    		out.println("<html lang=\"en\">");

    		out.println("<head>");

    		out.println("    <meta charset=\"UTF-8\">");

    		out.println("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");

    		out.println("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");

    		out.println("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");

    		out.println("        <title>Notes Login</title>");

    		out.println("</head>");

    		out.println("<body>");

    		out.println("<div class=\"container\">");

    		

    		out.println("<h1 class=\"display-1\">Pick Your Table</h1>");

    		

    		/*out.println("<form action=\"Login\" method=\"post\">");

    		

    		if (request.getAttribute("loginError") != null) {

    			out.println("<p class=\"text-light bg-danger\">Invalid username and/or password.</p>");

    		}

    		

    		out.println("    <div class=\"form-group\">");

    		out.println("        <label for=\"email\">Table</label>");

    		out.println("        <input class=\"form-control\" type=\"login\" name=\"loginId\" id=\"loginId\" placeholder=\"Enter Table Id\">");

    		out.println("    </div>");

    		out.println("    <div class=\"form-group\">");

    		out.println("        <label for=\"password\">Password</label>");

    		out.println("        <input class=\"form-control\" type=\"password\" name=\"password\" id=\"password\" placeholder=\"Enter your password\">");

    		out.println("    </div>");

    		out.println("    <div class=\"form-group\">");

    		out.println("        <button type=\"submit\" class=\"btn btn-primary\">Login</button>");

    		out.println("    </div>");

    		out.println("</form>");

    		*/



    		out.println("<p><h2><a href=\"OMM?tableId=1\">Table 1</a></h2></p>");

    		out.println("<p><h2><a href=\"OMM?tableId=2\">Table 2</a></h2></p>");

    		out.println("<p><h2><a href=\"OMM?tableId=3\">Table 3</a></h2></p>");

    		out.println("<p><h2><a href=\"OMM?tableId=4\">Table 4</a></h2></p>");

    		//out.println("<p><a href=\"Admin\" target = \"_blank\">Admin</a></p>");

    		out.println("<p><a href=\"Tables\" target = \"_blank\">Kitchen Display</a></p>");

    		out.println("</div>");

    		out.println("</body>");

    		out.println("</html>");

	}



    	protected TableUser getUser(String loginId, String password) {

    		ArrayList<TableUser> users = (ArrayList<TableUser>) getServletContext().getAttribute("users");

    		for (int i = 0 ; i < users.size() ; i ++) {

    			if (users.get(i).getLoginId().equals(loginId)) {

    				if(users.get(i).getPassword().equals(password)) {

    					return users.get(i);

    				}

    			}

    		}

    		return null;

    	}

    	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

		String email = request.getParameter("loginId");

		String password = request.getParameter("password");

		

		// find user

		TableUser user = getUser(email, password);

		

		if (user == null) {

			request.setAttribute("loginError", true);

			doGet(request, response);			

		}

		else {

			request.getSession().setAttribute("user", user);

			response.sendRedirect("OMM");

		}

	}



}




package com.m2i.formation.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.m2i.formation.j2ee.assurance.User;
import com.m2i.formation.j2ee.assurance.UserManager;

/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet(urlPatterns={"/user/add"})
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User newUser = new User();
		newUser.setId(Integer.parseInt(request.getParameter("id")));
		newUser.setFirstName(request.getParameter("firstName"));
		newUser.setLastName(request.getParameter("lastName"));
		newUser.setAddress(request.getParameter("address"));

		UserManager.getInstance().add(newUser);
		
		doView(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		PrintWriter out = response.getWriter();
		out.println("<html><body><bold>The user is created with succes</bold>");
		out.println("<br><br><a href=list>Users List </a>");
		out.println("</body></html>");

	}

}

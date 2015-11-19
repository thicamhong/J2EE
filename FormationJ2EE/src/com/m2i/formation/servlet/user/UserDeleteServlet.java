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
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/user/delete")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		
		if(id != null && !id.isEmpty())
		{
			User user = UserManager.getInstance().getById(Integer.parseInt(id));
			UserManager.getInstance().del(user);

			out.println("<html><body><bold>Deletion succeeded</bold>");
			out.println("<br><br><a href=list>Users List </a>");
			out.println("</body></html>");
		}
		else
		{
			out.println("<html><body><bold>The user doesn't exist</bold>");
			out.println("<br><br><a href=list>Users List </a>");
			out.println("</body></html>");
		}
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
		out.println("<html><body><bold>Update succeeded</bold>");
		out.println("<br><br><a href=list>Users List </a>");
		out.println("</body></html>");

	}
}

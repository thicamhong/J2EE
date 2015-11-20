package com.m2i.formation.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.m2i.formation.j2ee.assurance.User;
import com.m2i.formation.j2ee.assurance.UserManager;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/user/list")
public class UserListServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException 
	{
		/*
		UserManager userManager = new UserManager();
		List<User> usersList = userManager.getInstance().getAll();
		response.getWriter().println(toString(usersList));
		*/
		
		/**** OU ***/
		
		try
		{
			// On le met en commentaire car le traitement est deporte dans le JSP
			//doView(request, response, UserManager.getInstance().getAll());
			
			// la liste des users est un attribut de la request
			//request.setAttribute("userList", UserManager.getInstance().getAll());
			
			// la liste des users est dans la session
			// la session est dans la request
			request.getSession().setAttribute("userList", UserManager.getInstance().getAll());
			
			//request.getSession().invalidate();
			
			request.getRequestDispatcher("/UserList.jsp").forward(request, response);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

	
	public String toString(List<User> userList)
	{
		String msg = "";
		
		for(User u:userList)
		{
			msg += "Information client :";
			msg += "\t Prénom : " + u.getFirstName(); 
			msg += "\t Nom : " + u.getLastName(); 
			msg += "\t Address : " + u.getAddress();
			msg += "\n";
		}
		return msg;
	}
	
	
	protected void doView(HttpServletRequest request, HttpServletResponse response, List<User>users) throws ServletException, IOException
	{
	
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h1>Liste des users</h1>");
			
		for(User u:users)
		{
		
			out.println("<p>");
			//out.println("Client <a href='detail?id="  + u.getId() + "'>" + u.getId()+ "</a>");
			out.println("Client "  + u.getId() + " : ");
			out.println("<br>First Name : " + u.getFirstName() + "<br>"); 
			out.println("Last Name : " + u.getLastName() + "<br>"); 
			out.println("Address : " +  u.getAddress() + "<br>"); 
			out.println("<a href='/user/detail?id="  + u.getId() + "'>Details on the user</a><br>");
			out.println("<a href='/user/delete?id="  + u.getId() + "'>Delete the user</a><br>");
			out.println("</p>");
			
			
		
		}
		
		out.println("</body></html>");
		
	}

}

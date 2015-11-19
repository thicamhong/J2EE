package com.m2i.formation.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.m2i.formation.j2ee.assurance.User;
import com.m2i.formation.j2ee.assurance.UserManager;

/**
 * Servlet implementation class UserDetail
 */
@WebServlet("/user/detail")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		int id = Integer.parseInt(request.getParameter("id"));
		
		doView(request, response, UserManager.getInstance().getById(id));
		*/
		
		/***** OU *****/
		
		/*
		String id = request.getParameter("id");
		
		if(id != null && !id.isEmpty())
		{
			User u = UserManager.getInstance().getById(Integer.parseInt(id));
			doView(request, response, u);
		}
		else
		{
			doView(request, response);
		}
		*/
		
		/***** OU *****/
		// Recupere l'attribut de la session : formatDisplay
		String format = (String)request.getSession().getAttribute("formatDisplay");
		// Recupere le parametre de la requete : id de l'utisateur selectionne
		String id = request.getParameter("id");
		
		// Recupere les donnees du user selectionne en fonction de son id
		User user = UserManager.getInstance().getById(Integer.parseInt(id));
		
		PrintWriter out = response.getWriter();
		
		// Si le format d'affichage demande est JSON ou XML
		if(format !=null && (format.equals("JSON") || format.equals("XML")) )
		{
			// On indique que le format d'affichage de la reponse
			response.setContentType(format);
			
			if(format.equals("JSON") )
			{
				out.println(user.toJSON());
			}
			else
			{
				out.println(user.toXML());
			}			
		}
		
		// Sino je redispatche vers la JSP
		else
		{		
			request.getSession().setAttribute("idUser", id);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/UserDetail.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doView(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
	
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h1>User</h1>");
		
		out.println("<form action='update' method='POST'>");
		out.println("<h4> Client <input type='text' name='id' value='"  + user.getId() + "'/> </h4>");
		out.println("First Name : <input type='text' name='firstName' value='" + user.getFirstName() + "'/> <br>"); 
		out.println("Last Name : <input type='text' name='lastName' value='" + user.getLastName() + "'/> <br>"); 
		out.println("Address : <input type='text' name='address' value='" +  user.getAddress() + "'/> <br>"); 
		out.println("<button>");
		out.println("UPDATE");
		out.println("</button>");
		out.println("</form>");
			
		
		out.println("</body></html>");
	}

	protected void doView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h1>New User</h1>");
		
		
		out.println("<form action='add' method='POST'>");
		out.println("<h4> Client <input type='text' name='id'/> </h4>");
		out.println("First Name : <input type='text' name='firstName'/> <br>"); 
		out.println("Last Name : <input type='text' name='lastName'/> <br>"); 
		out.println("Address : <input type='text' name='address'/> <br>"); 
				
		out.println("<button>");
		out.println("CREATE");
		out.println("</button>");
		out.println("</form>");
		
		out.println("</body></html>");
	}
}

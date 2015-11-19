package com.m2i.formation.servlet.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.m2i.formation.j2ee.assurance.UserManager;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/index")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final int LOGGED_TRUE = 0;
		final int LOGGED_FALSE = 1;
		
		int isLogged = LOGGED_FALSE;
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String format = request.getParameter("format");
		
		if(login!=null && password!=null )
		{
			isLogged = UserValidate.getInstance().login(login, password);
		}
		
		switch (isLogged)
		{
			// Si le user est loggué, on le redirige vers la liste des details
			case LOGGED_TRUE :	try
								{
									request.getSession().setAttribute("userList", UserManager.getInstance().getAll());
									request.getSession().setAttribute("userIsLogged", true);
									request.getSession().setAttribute("userLogin", login);
									request.getSession().setAttribute("formatDisplay", format.toUpperCase());
									
								} catch (SQLException e)
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								request.getRequestDispatcher("/UserList.jsp").forward(request, response);
								break;
			
			// S'il n'est pas loggué, on le redirige vers la page de login
			case LOGGED_FALSE :
			default :			request.getSession().setAttribute("userIsLogged", false);
								request.getRequestDispatcher("/login.jsp").forward(request, response);
								break;
					
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

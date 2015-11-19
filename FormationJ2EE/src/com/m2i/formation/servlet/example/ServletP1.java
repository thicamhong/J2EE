package com.m2i.formation.servlet.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletP1
 */
@WebServlet("/ServletP1")
public class ServletP1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletP1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		// Tout ce que je t'envoie est du HTML
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("<Page 1>");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>");
		out.println("HELLO WORLD");
		out.println("</h1>");
		
		out.println("quel est votre nom?");
		out.println("<form action='ServletP2' method='POST'>");
		out.println("<input type='text' name='firstName'/>");
		out.println("<input type='text' name='lastName'/>");
		out.println("<button>");
		out.println("GOOOOOO");
		out.println("</button>");
		out.println("</form>");
	
		out.println("<a href ='http://localhost:8080/FormationJ2EE/ServletP2'>");
		out.println("Page 2");
		out.println("</a>");
		
		out.println("</body>");
		out.println("</html>");
		*/
		
		String title = "Titreeee";
		
		// Parametre est une paire (clé, valeur)
		request.setAttribute("title", title);
		
		request.getRequestDispatcher("/formulaire.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

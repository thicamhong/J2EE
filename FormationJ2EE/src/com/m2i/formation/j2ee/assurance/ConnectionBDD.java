package com.m2i.formation.j2ee.assurance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionBDD
{

	//Nom du driver JDBC qu'on va utiliser pour la base MySql
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	// URL utilisé pour se connecter a la base
	// On dit qu'on se connecte a une base MySql qui se trouve sur localhost et que la BDD est JEE
	private static final String JDBC_URL = "jdbc:mysql://localhost/jee";
	
	// Login et mot de passe pour se connecter a la base
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "root";
	
	//private static final ConnectionBDD instance = new ConnectionBDD();
	
	private static  Connection conn = null;
	private static Statement stmt = null;
	PreparedStatement stmtP = null;

	

	public static final Connection getInstance()
	{
		if(conn == null)
		{
			try
			{
				// 1. Connexion
				System.out.println("Connecting ...");
				
				// Force le serveur a utiliser ce driver
				Class.forName(JDBC_DRIVER);
				// Connexion stockee dans l'objet Connection
				conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
				
								
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			} catch (ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}

	
	public ConnectionBDD()
	{
		// TODO Auto-generated constructor stub
	}
/*	
	public Statement getStatement()
	{
		// 2. Creation du statement
		System.out.println("Create statement ....");
		try
		{
			stmt = conn.createStatement();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stmt;
	}
	
	public Statement getPrepareStatement()
	{
		// 2. Creation du statement
		System.out.println("Create statement ....");
		try
		{
			stmtP = conn.prepareStatement();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stmtP;
	}
*/	
	public void closeStatement()
	{
		System.out.println("Close statement ...");
		try
		{
			// Le statement peut planté ==> try catch
			if(stmt!=null)
			{
				stmt.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void closeConnection()
	{
		System.out.println("Exiting ...");

		try
		{
			// La deconnexion peut plantée ==> try catch
			if(conn!=null)
			{
				conn.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}

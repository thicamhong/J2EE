package com.m2i.formation.servlet.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.m2i.formation.j2ee.assurance.ConnectionBDD;
import com.m2i.formation.j2ee.assurance.User;
import com.m2i.formation.j2ee.assurance.UserManager;

public class UserValidate
{

	private static final UserValidate instance = new UserValidate();
	

	public static final UserValidate getInstance()
	{
		return UserValidate.instance;
	}
	
	
	int login(String login, String password)
	{
		
		String myRequestSql = "SELECT * FROM login where user=? and password=?;";
		final int LOGGED_TRUE = 0;
		final int LOGGED_FALSE = 1;
		
		int isLogged = LOGGED_FALSE;
		
		System.out.println("SQL : login : " + login);
		System.out.println("SQL : password : " + password);
		System.out.println("SQL : login.equals(admin) : " + login.equals("admin"));
		System.out.println("SQL : password.equals(root) : " + password.equals("root"));
/*		
		if(login.equals("admin") && password.equals("root"))
		{
			isLogged = LOGGED_TRUE;
		}
		else
		{
			isLogged = LOGGED_FALSE;
		}
*/		
		try
		{
			PreparedStatement stmt =  ConnectionBDD.getInstance().prepareStatement(myRequestSql);
			
			stmt.setString(1, login);
			stmt.setString(2, password);
			ResultSet res = stmt.executeQuery();
			
			if(res != null)
			{ 
				isLogged = LOGGED_TRUE;
			}
			else
			{
				isLogged = LOGGED_FALSE;
			}
			
			res.close();
			stmt.close();
		}
		catch(SQLException e)
		{
			System.out.println("Erreur de ResultSet");
			e.printStackTrace();
		}		
		return isLogged;
	
	}
	
}

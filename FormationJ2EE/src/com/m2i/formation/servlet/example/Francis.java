package com.m2i.formation.servlet.example;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebService;

import com.m2i.formation.j2ee.assurance.User;
import com.m2i.formation.j2ee.assurance.UserManager;

@WebService
public class Francis
{
	public String bondo()
	{
		return "Hello Francis BONDO\n";
	}
	
	public List<User> getAllUsers() throws SQLException
	{
		return UserManager.getInstance().getAll();
	}
}

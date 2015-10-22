package com.m2i.formation.j2ee.assurance;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.mysql.jdbc.PreparedStatement;

public class UserManager
{
	private Map<Integer,User> usersList = new HashMap<Integer,User>();
	
	private static final UserManager instance = new UserManager();
	

	public static final UserManager getInstance()
	{
		return UserManager.instance;
	}
	
	private UserManager()
	{
/*	
		// Create some users just for the display
		User user1;
		user1 = new User();
		user1.setId(10);
		user1.setFirstName("Bleach");
		user1.setLastName("Bankai");
		user1.setAddress("Tokyo");
		this.usersList.put(user1.getId(), user1);
		
		User user2;
		user2 = new User();
		user2.setId(11);
		user2.setFirstName("One");
		user2.setLastName("Piece");
		user2.setAddress("La mer de tous les dangers");
		this.usersList.put(user2.getId(), user2);

		User user3;
		user3 = new User();
		user3.setId(12);
		user3.setFirstName("unTouchable");
		user3.setLastName("Masstar");
		user3.setAddress("Corean");
		this.usersList.put(user3.getId(), user3);
*/
}
	
	
	public void add(User user)
	{
		/***************  Solution sans acces a la BDD **************************/
		//usersList.put(user.getId(), user);
		
		/***************  Solution avec acces a la BDD **************************/
		String myRequestSql = "INSERT INTO user VALUES( ?, ?, ?, ?);";
		myRequestSql += " iduser=?,";
		myRequestSql += " firstname=?,";
		myRequestSql += " lastname=?,";
		myRequestSql += " address=?";
		myRequestSql += " WHERE iduser=?;";
		myRequestSql += " );";
		
		try
		{
			PreparedStatement stmt = ConnectionBDD.getInstance().prepareStatement(myRequestSql);
			stmt.setInt(1, user.getId());
			stmt.setString(2, user.getFirstName());
			stmt.setString(3, user.getLastName());
			stmt.setString(4, user.getAddress());
			stmt.setInt(5, user.getId());
			int res = stmt.executeUpdate();
			System.out.println("Resultat du update : " + res);
						
			stmt.close();
		}
		catch(SQLException e)
		{
				e.printStackTrace();
		}
		
	}

	
	public void del(User user)
	{
		usersList.remove(user.getId());
	}
	
	
	public void update(User user)
	{
		/***************  Solution sans acces a la BDD **************************/
		//usersList.replace(user.getId(), user);
		
		/***************  Solution avec acces a la BDD **************************/
		/*
		String myRequestSql = "UPDATE user SET ";
		myRequestSql += "iduser=" + user.getId() + ", "; 
		myRequestSql += "firstname="+ user.getFirstName()+ ", ";  
		myRequestSql += "lastname="+ user.getLastName()+ ", "; 
		myRequestSql += "address="+ user.getAddress()+ " "; 
		myRequestSql += "WHERE iduser="+  user.getId() +";";
		*/
		String myRequestSql = "UPDATE user SET ";
		myRequestSql += " iduser=?,";
		myRequestSql += " firstname=?,";
		myRequestSql += " lastname=?,";
		myRequestSql += " address=?";
		myRequestSql += " WHERE iduser=?;";
		
		try
		{
			PreparedStatement stmt = ConnectionBDD.getInstance().prepareStatement(myRequestSql);
			stmt.setInt(1, user.getId());
			stmt.setString(2, user.getFirstName());
			stmt.setString(3, user.getLastName());
			stmt.setString(4, user.getAddress());
			stmt.setInt(5, user.getId());
			int res = stmt.executeUpdate();
			System.out.println("Resultat du update : " + res);
						
			stmt.close();
		}
		catch(SQLException e)
		{
				e.printStackTrace();
		}
		
	}

	
	public User getById(int id)
	{
		/***************  Solution sans acces a la BDD **************************/
		//return usersList.get(id);
		
		/***************  Solution avec acces a la BDD **************************/
		String myRequestSql = "SELECT * FROM user WHERE iduser=" + id + ";";
		User user = new User();
		ResultSet res = null;
		
		try
		{
			String reqSql = "SELECT * FROM user WHERE iduser=?;";
			PreparedStatement stmt =  ConnectionBDD.getInstance().prepareStatement(reqSql);
			stmt.setInt(1, id);
			res = stmt.executeQuery();
			while(res.next())
			{
				user.setId(res.getInt("iduser"));
				user.setFirstName(res.getString("firstname"));
				user.setLastName(res.getString("lastname"));
				user.setAddress(res.getString("address"));
			}
			
			res.close();
			stmt.close();
		}
		catch(SQLException e)
		{
			System.out.println("Erreur de ResultSet");
			e.printStackTrace();
		}
		
		return user;

	}
	
	
	public List<User> getAll() throws SQLException
	{
		
		/***************  Solution sans acces a la BDD **************************/
		//final List<User> result = new ArrayList<User>(usersList.values());
		
		
		/***************  Solution avec acces a la BDD **************************/
		List<User> result = new ArrayList<User>();
		String myRequestSql = "SELECT * FROM user;";
		Statement stmt = null;
		
		try
		{
			stmt = ConnectionBDD.getInstance().createStatement();
			ResultSet res = stmt.executeQuery(myRequestSql);
			while(res.next())
			{
				User user = new User();
				user.setId(res.getInt("iduser"));
				user.setFirstName(res.getString("firstname"));
				user.setLastName(res.getString("lastname"));
				user.setAddress(res.getString("address"));
				result.add(user);
			}
			
			res.close();
			stmt.close();
		}
		catch(SQLException e)
		{
			System.out.println("Erreur de ResultSet");
			e.printStackTrace();
		}
		
		
		return result;
	}

}

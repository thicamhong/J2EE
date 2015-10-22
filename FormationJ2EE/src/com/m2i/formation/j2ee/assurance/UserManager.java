package com.m2i.formation.j2ee.assurance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
		// Create some users just for the display
		User user1;
		user1 = new User();
		user1.setId(10);
		user1.setFirstName("Hayo");
		user1.setLastName("Myazaki");
		user1.setAddress("Tokyo");
		this.usersList.put(user1.getId(), user1);
		
		User user2;
		user2 = new User();
		user2.setId(11);
		user2.setFirstName("Joe");
		user2.setLastName("Hisashi");
		user2.setAddress("Hokkaido");
		this.usersList.put(user2.getId(), user2);

		User user3;
		user3 = new User();
		user3.setId(12);
		user3.setFirstName("Yoda");
		user3.setLastName("Maitre");
		user3.setAddress("Dakoba");
		this.usersList.put(user3.getId(), user3);
}
	
	
	public void add(User user)
	{
		usersList.put(user.getId(), user);
	}

	
	public void del(User user)
	{
		usersList.remove(user.getId());
	}
	
	
	public void update(User user)
	{
		usersList.replace(user.getId(), user);
	}

	
	public User getById(int id)
	{
		return usersList.get(id);
	}
	
	
	public List<User> getAll()
	{
		final List<User> result = new ArrayList<User>(usersList.values());
		
		return result;
	}

}

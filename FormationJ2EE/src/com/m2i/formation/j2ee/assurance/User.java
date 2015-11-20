package com.m2i.formation.j2ee.assurance;

public class User
{
	private int id; 
	private String firstName; 
	private String lastName; 
	private String address; 
	
	public User()
	{
		// TODO Auto-generated constructor stub
	}

	public int getId()
	{
		return id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getAddress()
	{
		return address;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String toJSON()
	{	
		StringBuffer sb = new StringBuffer();
	
		sb.append("{");
		sb.append("id:").append(id).append(",\n");
		sb.append("\"firstName\":\"").append(firstName).append("\",\n");
		sb.append("\"lastName:\"").append(lastName).append("\",\n");
		sb.append("\"address:\"").append(address).append("\"\n");
		sb.append("}");
		
		return sb.toString();		
	}
	
	public String toXML()
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("<user>\n");
		
		sb.append("\t<id>\n");
		sb.append("\t\t" + id + "\n");
		sb.append("\t</id>\n");
		
		sb.append("\t<firstName>\n");
		sb.append("\t\t" + firstName + "\n");
		sb.append("\t</firstName>\n");
		
		sb.append("\t<lastName>\n");
		sb.append("\t\t" + lastName + "\n");
		sb.append("\t</lastName>\n");
		
		sb.append("\t<address>\n");
		sb.append("\t\t" + address + "\n");
		sb.append("\t</address>\n");
		
		sb.append("</user>");
		
		return sb.toString();
		
	}

}

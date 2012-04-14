package com.SchooledCloud.org;

public class XMLDataCollected {
	String loggedin;
	String email;
	String password;
	
	public void setEmail(String c)
	{
		email = c;
	}
	
	public void setPassword(String d)
	{
		password = d;
	}
	
	public void setLoggedIn(String e)
	{
		loggedin = e;
	}
	
	public String dataToString()
	{
		return "d"+loggedin+"d";
	}
}

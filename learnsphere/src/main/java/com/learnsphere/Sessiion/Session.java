package com.learnsphere.Sessiion;

import com.learnsphere.Entities.Users;

public class Session {
	
	static public Users cuser;
	
	public Session (long id)
	{
	
		cuser = new Users();
		cuser.setId(id);
		
	}

	public static Session setSession (long id)
	{
	return new Session(id);
	
	}
	
	
	public static boolean check()
	{
		if(cuser==null||cuser.id==0l)
		return false;
		return true;
		
	}

	public static Long getId() {
		// TODO Auto-generated method stub
		return cuser.id;
	}
}

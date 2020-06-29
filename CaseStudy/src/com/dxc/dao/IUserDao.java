package com.dxc.dao;

import java.util.List;

import com.dxc.poojs.Bookinfo;

public interface IUserDao {
	
	public boolean checkUser(String user_name,String password);
	public List<Bookinfo> getBooklist();
	public void ListOfbooks();
	public void getBalance();
	public void getBooksLibrary();
	public void closeSystem();
	



}

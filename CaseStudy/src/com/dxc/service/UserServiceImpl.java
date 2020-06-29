package com.dxc.service;

import java.util.List;

import com.dxc.dao.IUserDao;
import com.dxc.dao.UserDaoImpl;
import com.dxc.poojs.Bookinfo;

public class UserServiceImpl implements IUserService {
	IUserDao dao=new UserDaoImpl();
	public boolean checkUser(String user,String pass) {
		return dao.checkUser(user, pass);
	}
	public List<Bookinfo> getBooklist(){
		return dao.getBooklist();
	}
	public void ListOfbooks() {
		dao.ListOfbooks();
	}
	public void getBalance() {
		dao.getBalance();
	}
	public void getBooksLibrary() {
		dao.getBooksLibrary();
		
	}
	public void closeSystem()
	{

dao.closeSystem();

	}


}

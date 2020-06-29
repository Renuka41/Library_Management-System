package com.dxc.dao;

import java.util.List;

import com.dxc.poojs.Admininfo;

public interface IAdminDao {
	public void login(String a,String p);
	public void updatebook();
public void booklist();
public void getbalance();
public void closeaccount();
public List<Admininfo> getAdmininfo();


}

package com.dxc.service;

import java.util.List;

import com.dxc.dao.AdminDaoImpl;
import com.dxc.dao.IAdminDao;
import com.dxc.poojs.Admininfo;
import com.dxc.poojs.Bookinfo;

public class AdminServiceImpl implements IAdminService{
	IAdminDao dao=new AdminDaoImpl();
public void login(String a,String p)
{
	dao.login(a,p);
}
public void updatebook()

{
	dao.updatebook();
}
public void booklist() {
	dao.booklist();	
}
public void getbalance() {
	dao.getbalance();
}
public void closeaccount() {
	dao.closeaccount();
}
public List<Admininfo> getAdmininfo(){
	return dao.getAdmininfo();
}
}

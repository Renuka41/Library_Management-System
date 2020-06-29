package com.dxc.service;

import java.util.List;

import com.dxc.poojs.Admininfo;
import com.dxc.poojs.Bookinfo;

public interface IAdminService {
	public void login(String a,String p);
	public void updatebook();
	public void booklist();
	public void getbalance();
	public void closeaccount();
	public List<Admininfo> getAdmininfo();

}

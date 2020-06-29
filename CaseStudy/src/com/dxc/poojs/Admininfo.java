package com.dxc.poojs;

public class Admininfo {
	private String adminname;
	private String adminpassword;
	private int bookid;
	public Admininfo(String adminname, String adminpassword, int bookid) {
		super();
		this.adminname = adminname;
		this.adminpassword = adminpassword;
		this.bookid = bookid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public void display() {
		System.out.println(adminname+"  "+adminpassword+"  "+bookid);
	}

}

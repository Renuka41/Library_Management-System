package com.dxc.poojs;

public class Userinfo {
	private int bookid;
	private int userid;
	private  String username;
	private String userpassword;
	private int userbal;
	public Userinfo(int bookid, int userid, String username, String userpassword, int userbal) {
		super();
		this.bookid = bookid;
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.userbal = userbal;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public int getUserbal() {
		return userbal;
	}
	public void setUserbal(int userbal) {
		this.userbal = userbal;
	}
public void display() {
	System.out.println(bookid+" "+userid+"  "+username+"  "+userpassword+"  "+userbal);
}
}

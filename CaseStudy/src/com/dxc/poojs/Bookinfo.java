package com.dxc.poojs;

public class Bookinfo {
	private int bookid;
	private String bookname;
	private String bookauthor;
	private int quantity;
	public Bookinfo(int bookid, String bookname, String bookauthor, int quantity) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookauthor = bookauthor;
		this.quantity = quantity;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void display() {
		System.out.println(bookid+"  "+bookname+"  "+bookauthor+"  "+quantity);
	}

}

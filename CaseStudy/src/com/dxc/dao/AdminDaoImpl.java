package com.dxc.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.dxc.poojs.Admininfo;
import com.dxc.poojs.Bookinfo;

public class AdminDaoImpl implements IAdminDao {
	private static Connection con;
	Scanner sc=new Scanner(System.in);
	private List<Bookinfo> list=new ArrayList<>();

	static {
		try {

			Class.forName("org.postgresql.Driver");
			System.out.println("driver loaded");
			 con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/WorkDB","postgres","1234");
			System.out.println("connected to database..");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void login(String a,String p)
	{
				try {
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("select * from admininfo");
					while(rs.next())
					{
						if(a.equals(rs.getString(1))&&p.equals(rs.getString(2)))
							System.out.println("admin login sucessfully..");
						else
						{
							System.out.println("login fail");
							System.exit(0);
						}
						break;
					}
				} catch (Exception e) {
			e.printStackTrace();
				}
			

		}
	public void updatebook()
	{
		try {

		System.out.println("1.adding a book ");
		System.out.println("2.remove a book ");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			PreparedStatement pstmt1 =con.prepareStatement("insert into bookinfo values(?,?,?,?)");

			System.out.println("enter bookid,bookname bookauthor and quantity");
			 int bookid=sc.nextInt();
			pstmt1.setInt(1, bookid);
			 String bookname=sc.next();
			pstmt1.setString(2, bookname);

			 String author=sc.next();
			pstmt1.setString(3, author);

			 int quantity=sc.nextInt();
			pstmt1.setInt(4, quantity);
			pstmt1.execute();	
			System.out.println("book added into bookdetails");
			Statement stmt1 =con.createStatement();
			ResultSet rset1=stmt1.executeQuery("select * from bookinfo ");
			while(rset1.next())
			{
			Bookinfo	bi=new Bookinfo(rset1.getInt(1),rset1.getString(2),rset1.getString(3),rset1.getInt(4));
				list.add(bi);
			}
			for(Bookinfo bi:list)
			{
				System.out.println(bi.getBookid()+"  "+bi.getBookname()+"  "+bi.getBookauthor()+"  "+bi.getQuantity());
			}
			System.out.println();
			break;
		case 2:
			Statement stmt =con.createStatement();
			ResultSet rset=stmt.executeQuery("select * from bookinfo ");
			while(rset.next())
			{
			Bookinfo	bi=new Bookinfo(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getInt(4));
				list.add(bi);
			}
			for(Bookinfo bi:list)
			{
				System.out.println(bi.getBookid()+"  "+bi.getBookname()+"  "+bi.getBookauthor()+"  "+bi.getQuantity());
			}
			System.out.println();
			System.out.println("enter the bookid :");
			bookid=sc.nextInt();
			PreparedStatement pstmt =con.prepareStatement("delete from bookinfo where bookid=?");
			pstmt.setInt(1, bookid);
			pstmt.execute();
			PreparedStatement pstm =con.prepareStatement("select * from bookinfo");
			ResultSet e=pstm.executeQuery();
			while(e.next())
			{

				System.out.println(e.getInt(1)+" "+e.getString(2)+"  "+e.getString(3)+"  "+e.getInt(4));
			
			}
			
			
			break;
			
		}}
	catch (SQLException e) {
			e.printStackTrace();
		}}


	public void booklist() 
	{
		try 
		{
			System.out.println("Enter username");
		String username=sc.next();
		PreparedStatement pstmt=con.prepareStatement("select bookid from userinfo where username=?");
    pstmt.setString(1, username);
 	ResultSet rset=pstmt.executeQuery();
 	 int count=0;
 	 while(rset.next())
 	 {
 		 System.out.println(rset.getInt(1));
 		 count=count+1;
 	 }
 	 while(count>=1)
 	 {
 		 System.out.println("enter the bookid..");
 		int book_id=sc.nextInt();

 		 PreparedStatement pstm=con.prepareStatement("select * from bookinfo where bookid=?");
 		pstm.setInt(1, book_id);
 		 ResultSet rs=pstm.executeQuery();
 		 while(rs.next()) 
 		 {
 			Bookinfo bid=new Bookinfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
 			list.add(bid);
 		 }
 		 for(Bookinfo bid:list)
 		 {
 			 System.out.println(bid.getBookid()+"  "+bid.getBookname()+" "+bid.getBookauthor()+" "+bid.getQuantity());
 		 }
 		 System.out.println();
 		 count--;

	}}
		catch (SQLException e) 
		{
		e.printStackTrace();
	}
	}
	public void getbalance()
	{

		try {System.out.println("enter username");
			PreparedStatement pstmt=con.prepareStatement("select userbal from userinfo where username=?");
			 String username=sc.next();
			pstmt.setString(1, username);
	        ResultSet rs=pstmt.executeQuery();
	         while(rs.next())
				{
	        	 System.out.println(rs.getInt(1));
	       break;

	        	 	}
	         System.out.println();
			} 
			catch (Exception e) 
			{
			e.printStackTrace();
			}
		}
	public void closeaccount() {
		try {
			PreparedStatement ps=con.prepareStatement("select * from userinfo");
			ResultSet r=ps.executeQuery();
			while(r.next())
			{
				System.out.println(r.getInt(1)+" "+r.getInt(2)+"  "+r.getString(3)+"  "+r.getString(4)+"  "+r.getInt(5));
			}
			System.out.println("enter userid");
			 int userid=sc.nextInt();
			PreparedStatement p=con.prepareStatement("delete from  userinfo where userid=? ");
			p.setInt(1,userid);
			p.execute();
			PreparedStatement pstmt =con.prepareStatement("select * from userinfo");
			ResultSet e=pstmt.executeQuery();
			while(e.next())
			{

				System.out.println(e.getInt(1)+" "+e.getInt(2)+"  "+e.getString(3)+"  "+e.getString(4)+"  "+e.getInt(5));
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Admininfo> getAdmininfo()
	{
		
		List<Admininfo> list=new ArrayList<>();
		try {
			Statement stmt=con.createStatement();
			ResultSet rset=stmt.executeQuery("select * from admininfo");
		
			while(rset.next())
			{
				Admininfo ad=new Admininfo(rset.getString(1),rset.getString(2),rset.getInt(3));
				list.add(ad);
			
		    } 
		}catch (Exception e) 
		{
			e.printStackTrace();
		}return list;
	}
	

}
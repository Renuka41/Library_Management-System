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

import com.dxc.poojs.Bookinfo;

public class UserDaoImpl implements IUserDao{
	private static Connection con;
	Scanner sc=new Scanner(System.in);
	List <Bookinfo> list=new ArrayList<>();
	static {
		try {
			Class.forName("org.postgresql.Driver");
			 con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/WorkDB","postgres","1234");

		     } 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public boolean checkUser(String user,String pass)
	{boolean b=false;
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select username,userpassword from userinfo");
			while(rs.next())
			{
				if(user.equals(rs.getString(1))&&pass.equals(rs.getString(2)))
				System.out.println("user  login success");
				else {
					System.out.println("login failer");
					System.exit(0);
				     }
				break;
			}	}
	catch (Exception e) 
	{
	e.printStackTrace();
		}
		return b;
	}
	public List<Bookinfo> getBooklist()
		{
			
			List<Bookinfo> list=new ArrayList<>();
			try {
				Statement stmt=con.createStatement();
				ResultSet rset=stmt.executeQuery("select * from bookinfo");
			
				while(rset.next())
				{
					Bookinfo bl=new Bookinfo(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getInt(4));
					list.add(bl);
				
			    } 
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}return list;
		}

	public void ListOfbooks()
	{
		try {
			System.out.println("enter author");
			 String author=sc.next();
			PreparedStatement pstmt=con.prepareStatement("select * from bookinfo where bookauthor =?");
			pstmt.setString(1,author);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next())
			{
				System.out.println(rst.getInt(1)+"  "+rst.getString(2)+"   "+rst.getString(3)+"   "+rst.getInt(4));
			}

			System.out.println();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void getBalance()
	{int bal=0;
		try { 


			PreparedStatement pstmt =con.prepareStatement("select userbal from userinfo where username=?");
			System.out.println("enter username");
			 String username=sc.next();
			pstmt.setString(1, username);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next())
			{
			System.out.println(rst.getInt(1));
			break;
			}
			System.out.println();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void getBooksLibrary()
	{
		try {
			Statement stmt=con.createStatement();
			ResultSet rst=stmt.executeQuery("select * from bookinfo");
			while(rst.next())
			{
				System.out.println(rst.getInt(1)+"  "+rst.getString(2)+"   "+rst.getString(3)+"   "+rst.getInt(4));
			}
			System.out.println();
			System.out.println("enter bookid to issue :");
			 int bookid=sc.nextInt();
			 System.out.println("how many books needed :");
		int	c1=sc.nextInt();
			PreparedStatement pstmt=con.prepareStatement("update bookinfo set quantity=quantity-? where bookid =?");
			pstmt.setInt(1, c1);
			pstmt.setInt(2,bookid);			
			pstmt.execute();
			System.out.println("how many days ");
		int	days=sc.nextInt();
			System.out.println("enter userid");
			int userid1=sc.nextInt();
			PreparedStatement pstmt2=con.prepareStatement("update userinfo set userbal=userbal-(?*5) where userid=?");
			pstmt2.setInt(1, days);
			pstmt2.setInt(2, userid1);
			pstmt2.execute();


			} catch (SQLException e) {
			e.printStackTrace();
		}


	}
	public void closeSystem()
	{

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

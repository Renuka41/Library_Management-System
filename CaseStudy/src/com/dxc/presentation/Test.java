package com.dxc.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.dxc.poojs.Admininfo;
import com.dxc.poojs.Bookinfo;
import com.dxc.service.AdminServiceImpl;
import com.dxc.service.IAdminService;
import com.dxc.service.IUserService;
import com.dxc.service.UserServiceImpl;



public class Test {

	public static void main(String[] args)
	{		IAdminService as=new AdminServiceImpl();
			IUserService is=new UserServiceImpl();

		Scanner sc=new Scanner(System.in);
		int choice;
		String a;
		String p;

		System.out.println("1. login admin");
		System.out.println("2.  login user");
		System.out.println("enter choice");
		System.out.println("-------------------");
		 choice=sc.nextInt();
 switch(choice)
	 {		 
 case 1:
			 System.out.println("enter admin_name and password");
				 a=sc.next();
				  p=sc.next();
				 as.login(a, p);
				 while(true)
				 {
 
 System.out.println("1.add/remove  book from lib ");
 System.out.println("2.get list of books issued by particular user");
 System.out.println("3.get balance amount of particulr user");
 System.out.println("4.close user account from lib");
 System.out.println("5.display admin table");
 System.out.println("-----------------------------------");
  choice=sc.nextInt();
 switch(choice) 
 {	
 		case 1:
		as.updatebook();
		 break;
	case 2:as.booklist();
		break;
	case 3:as.getbalance();
		break;
	case 4:as.closeaccount();
		break;
	case 5: System.out.println("Dislpay admin table");
	 	List<Admininfo> list=as.getAdmininfo();
	 	for(Admininfo ad:list)
		ad.display();
		 break;
}
break;
				 }
 case 2:System.out.println("enter username and password");
 String user=sc.next();
String pass=sc.next();
is.checkUser(user,pass);
while(true) {    
	 System.out.println("1.list of books");
	 System.out.println("2.issuse books from lib");
	 System.out.println("3.get list of books by particular user");
	 System.out.println("4.check available balance in lib");	
	 System.out.println("enter choice");
	 System.out.println("--------------------");
	int ch =sc.nextInt();
switch(ch) 
{

		 
case 1:
	 System.out.println("booklist");
	 List<Bookinfo>list=is.getBooklist();
	 for(Bookinfo bl:list)
	 bl.display();
	 break;
case 2:is.getBooksLibrary();
	break;

case 3:
is.ListOfbooks();
break;
case 4:is.getBalance( );
	 break;
}
	 break;
}
	 case 3:
			is.closeSystem();
			System.exit(0);
			break;
			
}}
}
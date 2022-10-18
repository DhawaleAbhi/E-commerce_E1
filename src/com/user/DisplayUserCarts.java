package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.main.Db_Connection;
import com.main.DisplayAllProducts;
import com.main.DisplayAllUsers;
import com.main.Order;

public class DisplayUserCarts {

	public void getcartList() throws SQLException, ClassNotFoundException
{
		
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter Your UserName:");
		String userName=scanner.next();

		System.out.println("        ======================================Your Carts======================================");

		//orders list
		List<Carts> carts=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		try {
		
			Db_Connection db_Connection=new Db_Connection();
		   	con=db_Connection.getConnection();
			ps=con.prepareStatement("select cid,productid,uname,productname,pprice,pcategories from carts where uname=?");
			ps.setString(1, userName);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				carts.add(new Carts(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getString(4),rs.getInt(5),rs.getString(6)));
			}
			System.out.println(carts);
		}
		catch (Exception e) {
		System.out.println(e.getMessage());	
		}

	System.out.println("\n        ==========================================================================================");
			 System.out.println("===============================CARTS====================================");
				System.out.print("1>Buy Product");
				System.out.print("     2>Remove Product");
				System.out.println("      3>Exit");
				System.out.println(" ==================================================");
				System.out.println("Please Enter your Choise:");
				int ch=scanner.nextInt();
				switch(ch)
				{
				case 1:
				
					System.out.print("Enter Product Id:");
					String pid=scanner.next();
					System.out.print("Enter Quantity:");
					int quantity=scanner.nextInt();
					System.out.print("Enter Your UserName:");
					String uName=scanner.next();
					
							  
							  int tquantity=0;
							  int price=0;
							  String pname=null;
							  
						    
						  
						     
							//check product quantity available or not
							Db_Connection db_Connection=new Db_Connection();
							con=db_Connection.getConnection();
						    ps=con.prepareStatement("select quantity,price,description from product where pid=?");
							ps.setString(1,pid);
							
						    ResultSet rs1=ps.executeQuery();
						    while(rs1.next())
						    {
						      tquantity=rs1.getInt(1);
						      price=rs1.getInt(2);
						      pname=rs1.getString(3);
						      System.out.println(rs1.getString(3));
						    }
						    if(tquantity >= quantity)
						    {    
						    	 //upate the quantity in product table
						    	 int q1=tquantity-quantity;
						    	 String q2=Integer.toString(q1);//quantity
								ps=con.prepareStatement("update product set quantity=? where pid=? ");
								ps.setString(1,q2);
								ps.setString(2, pid);
							    ps.executeUpdate();
							    
							    //insert the order in order table
							    String q3=Integer.toString(quantity);//quantity
							    String price1=Integer.toString(price);//price
							    int tprice1=price*quantity;
							    String tprice2=Integer.toString(tprice1);//total price
				                			  
							    ps=con.prepareStatement("insert into ecommerce.order(username,pid,quantity,price,totalprice)values(?,?,?,?,?)");
								
							    
							    ps.setString(1,uName);
								ps.setString(2, pid);
								ps.setString(3, q3);
								ps.setString(4, price1);
								ps.setString(5, tprice2);
								//ps.setString(6, des);
								ps.executeUpdate();
						
							System.out.println("\n************Order Details************");	
							  System.out.println("pid:"+pid);
							  System.out.println("product name:"+pname);
							  System.out.println("No of products:"+q3);
							  System.out.println("price of each:"+price1);
							  System.out.println("Total Price:"+tprice2);	
						      System.out.println(pname +" ordered succesfull!!!!");
						    }
						    else
						    {
						    	System.out.println("product not Available!!!!");
						    }	
					
						
					
					
					
					
					
					
					

					
					System.out.println("----------------------------------------------------------------------------------");
					  break;
	         case 2:
			
					Db_Connection db_Connection1=new Db_Connection();
					Connection conn=db_Connection1.getConnection();
					//Connection con=null;
					PreparedStatement st=null;
			        Scanner sc=new Scanner(System.in);
			        System.out.println("ENTER  PID->>");
					String productid=sc.next();
					st=conn.prepareStatement("delete from carts where productid=?;");
										
							st.setString(1,productid);
							st.executeUpdate();
							System.out.println("PRODUCT DATA DELETED-1");		

					System.out.println("----------------------------------------------------------------------------------");
					break;
				case 3:
					System.out.println("........Thank You........");
					return;
				default:
					System.out.println("please enter valid choice");
					break;
				}
}	
}

package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class DisplayAllProducts {
    

	public void getProductList() throws SQLException
	{     Scanner sc=new Scanner(System.in);
		System.out.println("        ======================================All Categories======================================");
	
		//crickets  list
		List<Products> cricket=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Db_Connection db_Connection=new Db_Connection();
		   	con=db_Connection.getConnection();
			ps=con.prepareStatement("select * from product where  categories=?");
			ps.setString(1, "cricket");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				cricket.add(new Products(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));
			}
			System.out.println("\n\t\t\t\t             ****CRICKET****");
			System.out.print("\t\t\t\t             ---------------");
			Iterator<Products>  it=cricket.iterator();
			while(it.hasNext())
			{
				System.out.print("      "+it.next() );	
			}
			
		}
		catch (Exception e) {
		System.out.println(e.getMessage());	
		}
		
		
		//sports Balls lists
		List<Products> ball=new ArrayList<>();
		
		try {
			Db_Connection db_Connection=new Db_Connection();
			con=db_Connection.getConnection();
			ps=con.prepareStatement("select * from product where  categories=? ");
			ps.setString(1, "ball");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ball.add(new Products(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));
			}
			System.out.println("\n\t\t\t\t             ****BALLS****");
			System.out.print("\t\t\t\t             ---------------");
			System.out.println("    "+ball );
		}
		catch (Exception e) {
		System.out.println(e.getMessage());	
		}

		//Sport cloths list
		List<Products>  cloth=new ArrayList<>();
		try {
			Db_Connection db_Connection=new Db_Connection();
			con=db_Connection.getConnection();
			ps=con.prepareStatement("select * from product where  categories=?");
			ps.setString(1, "cloth");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				cloth.add(new Products(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));
			}
			System.out.println("\n\t\t\t\t             ****CLOTHS****");
			System.out.print("\t\t\t\t             ------------------");
			System.out.println("                  "+cloth );
		  }
		 catch (Exception e) {
			System.out.println(e.getMessage());	
			}
		
			//GYMS Equipment list
			List<Products> gym=new ArrayList<>();
			try {
				Db_Connection db_Connection=new Db_Connection();
				con=db_Connection.getConnection();
				ps=con.prepareStatement("select * from product where  categories=?");
				ps.setString(1, "gym");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					gym.add(new Products(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));
				}
				System.out.println("\n\t\t\t\t             ****GYMS****");
				System.out.print("\t\t\t\t             ------------------");
				System.out.println("           "+gym );
				}
		
		     catch (Exception e) {
		      System.out.println(e.getMessage());	
		       }
			
			//SPORT CAPS list
			List<Products> cap=new ArrayList<>();
			try {
				Db_Connection db_Connection=new Db_Connection();
				con=db_Connection.getConnection();
				ps=con.prepareStatement("select * from product where  categories=?");
				ps.setString(1, "cap");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					cap.add(new Products(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));
				}
				System.out.println("\n\t\t\t\t             ****CAPS****");
				System.out.print("\t\t\t\t             ------------------");
				System.out.println("                   "+cap );
				}
		
		    catch (Exception e) {
		        System.out.println(e.getMessage());	
		        }	
			
			//SPORT SHOES list
			List<Products> shoe=new ArrayList<>();
			try {
				Db_Connection db_Connection=new Db_Connection();
				con=db_Connection.getConnection();
				ps=con.prepareStatement("select * from product where  categories=?");
				ps.setString(1, "shoe");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					shoe.add(new Products(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));
				}
				System.out.println("\n\t\t\t\t             ****SHOES****");
				System.out.print("\t\t\t\t             ------------------");
				System.out.println("                  "+shoe);
				}
		
		    catch (Exception e) {
		      System.out.println(e.getMessage());	
		      }
				
			//SPORT Sun-Glasses list
			List<Products> glass=new ArrayList<>();
			try {
				Db_Connection db_Connection=new Db_Connection();
				con=db_Connection.getConnection();
				ps=con.prepareStatement("select * from product where  categories=?");
				ps.setString(1, "glass");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					glass.add(new Products(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));
				}
				System.out.println("\n\t\t\t\t             ****SUN-GLASSES****");
				System.out.print("\t\t\t\t             ------------------");
				System.out.println("                   "+glass);
				}
			
		
		catch (Exception e) {
		System.out.println(e.getMessage());	
		}
			//SPORT NETS list
			List<Products> net=new ArrayList<>();
			try {
				Db_Connection db_Connection=new Db_Connection();
				con=db_Connection.getConnection();
				ps=con.prepareStatement("select * from product where  categories=?");
				ps.setString(1, "net");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					net.add(new Products(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));
				}
				System.out.println("\n\t\t\t\t             ****NETS****");
				System.out.print("\t\t\t\t             ------------------");
				System.out.println("                  "+net);
				}
		
		catch (Exception e) {
		System.out.println(e.getMessage());	
		}
		System.out.println("\n        ==========================================================================================");

			
	}
	
}

package com.jsp.jdbc_prepared_statement.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jsp.jdbc_prepared_statement.connection.LaptopConnection;
import com.jsp.jdbc_prepared_statement.entity.Laptop;

public class Laptop_controller {
	
	public static void main(String[]args) {
		@SuppressWarnings("resource")
		Scanner sc =new Scanner(System.in);
		Connection connection=null;
		
		while(true) {
			System.out.println("1.Insert\n2.Delete\n3.Update\n4.Display");
			System.out.println("enter your option");
			int option=sc.nextInt();
			switch(option){
				
				case 1:{
					connection=LaptopConnection.getLaptopConnection();
					
					System.out.println("enter laptop id ");
					int id=sc.nextInt();
					
					System.out.println("enter laptop name");
					String name=sc.next();
					
					System.out.println("enter laptop color");
					String color=sc.next();
					
					System.out.println("enter laptop price");
					Double price=sc.nextDouble();
					
					System.out.println("enter laptop ram");
					String ram=sc.next();
					
					
					Laptop laptop= new Laptop(id,name,color,price,ram);
					
					String insertQuery="insert into laptop values(?,?,?,?,?)";
					
					
					try {
						PreparedStatement ps=connection.prepareStatement(insertQuery);
						
						ps.setInt(1,laptop.getId());
						ps.setString(2,laptop.getName());
						ps.setString(3,laptop.getColor());
						ps.setDouble(4,laptop.getPrice());
						ps.setString(5,laptop.getRam());
						
						ps.execute();
						
						System.out.println("Data----entered");
						
					}catch(SQLException e) {
						e.printStackTrace();
						
					}
			
					
				}
				  break;
				case 2:{
                    connection=LaptopConnection.getLaptopConnection();
					System.out.println("enter laptop id to delete ");
				
					int id=sc.nextInt();
				
					
					String deleteQuery="delete from laptop where id=? ";
					
					try {
						PreparedStatement preparedStatement=connection.prepareStatement(deleteQuery);
						preparedStatement.setInt(1,id);
						
						int a=preparedStatement.executeUpdate();
						
						if(a==1) {
							System.out.println("deleted");
							
						}else {
							System.out.println("id not found.....");
							
						}
					}catch(SQLException e) {
						e.printStackTrace();
					}
	
				}
				   break;
				   
				case 3:{
					System.out.println("what you want to update..");
					  System.out.println("1.Name\n2.color\n3.price\n4.ram\n");
					  int choice = sc.nextInt();
					  switch(choice) {
					  case 1:{
						  System.out.println("enter laptop id to update Name");
							int id=sc.nextInt();
							
							System.out.println("enter new laptop Name");
							String name=sc.next();
							
							String updateNameQuery = "update laptop set name=? where id =?";
							
							try {
								connection = LaptopConnection.getLaptopConnection();
								PreparedStatement ps = connection.prepareStatement(updateNameQuery);
								ps.setInt(2,id);
								ps.setString(1, name);
								int a=ps.executeUpdate();
								
								if(a==1) {
									System.out.println("data updated");
								}else {
									System.out.println("data not updated");
								}}catch(SQLException e) {
									e.printStackTrace();
								}
								break;
					  }	
							
					  }
				}
				case 4:{
					String selectQuery = "SELECT * from laptop";
					connection=LaptopConnection.getLaptopConnection();
					
					try {
						PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
						  ResultSet resultSet = preparedStatement.executeQuery();
						  
						  while(resultSet.next()) {
							  int id=resultSet.getInt("Id");
							  String name=resultSet.getString("name");
							  String color=resultSet.getString("color");
							  double price=resultSet.getDouble("price");
							  String ram=resultSet.getString("ram");
							  
							  Laptop laptop = new Laptop(id, name, color, price, ram);
							  System.out.println(laptop);
						      }

					}catch(SQLException e) {
						e.printStackTrace();
					}
					break;
		 

				}
			}
		}
	}
}
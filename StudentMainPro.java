package com.sms.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class StudentMainPro {
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Scanner s1=new Scanner(System.in);
	 while(true) {
		 intro();
		 System.out.println("========================================");
		 System.out.println("Choose the Operation:");
		 int o=s1.nextInt();
		 switch (o) {
		 case 1:
			 System.out.println("**********************");
			 System.out.println("*  *INSERT RECORD*    * *");
			 System.out.println("**********************");
			 insert();
			 System.out.println("----------------------");
			 break;
		 case 2:
			 System.out.println("**********************");
			 System.out.println("*  *EDIT RECORD*    * *");
			 System.out.println("**********************");
			 edit();
			 System.out.println("----------------------");
			 break;
		 case 3:
			 System.out.println("**********************");
			 System.out.println("*  *VIEW RECORD*    * *");
			 System.out.println("**********************");
			 view();
			 System.out.println("----------------------");
			 break;
		 case 4:
			 System.out.println("**********************");
			 System.out.println("*  *DELETE RECORD*    * *");
			 System.out.println("**********************");
			 delete();
			 System.out.println("----------------------");
			 break;
		 case 5:
			 System.out.println("Program stoped");
			 System.exit(0);
			 break;
			 default:
				 System.out.println("Enter the valid Number");
				 break;
		
		 }
	 }
	 
 }
 public static void delete() throws ClassNotFoundException, SQLException{
	 String url="jdbc:mysql://localhost:3306/sms_db";
	 Connection con=DriverManager.getConnection(url,"root","W7301@jqir#");
	 view();
	 String q="DELETE FROM student_info WHERE (id=?);";
	 PreparedStatement ps=con.prepareStatement(q);
	 Scanner s=new Scanner(System.in);
	 System.out.println("Select ID to Delete:");
	 int id=s.nextInt();
	 ps.setInt(1, id);
	 ps.executeUpdate();
	 System.out.println("Record deleted sucessfully");
     
 }
 
 public static void edit()throws ClassNotFoundException, SQLException {
	 String url3="jdbc:mysql://localhost:3306/sms_db";
	 Connection con3=DriverManager.getConnection(url3,"root","W7301@jqir#");
	 view();
	 String query="UPDATE student_info SET Name=?,std=?,fname=?,mobile=? WHERE(id=?);";
	 PreparedStatement ps=con3.prepareStatement(query);
	 Scanner s=new Scanner(System.in);
	 System.out.println("Select the id to Edit:");
	 int i=s.nextInt();
	 System.out.println("Enter Name:");
	 s.nextLine();
	 String n=s.nextLine();
	 System.out.println("Enter STD:");
	 String c=s.nextLine();
	 System.out.println("Enter Fname:");
	 String fn=s.nextLine();
	 System.out.println("Enter mobile:");
	 String mob=s.nextLine();
     ps.setString(1, n);
     ps.setString(3, fn);
     ps.setString(2, c);
     ps.setString(4, mob);
     ps.setInt(5, i);
     ps.executeUpdate();
     System.out.println("Data updated sucessfully.......");
     
     
 }
 
 public static void view() throws SQLException {
	 String url1="jdbc:mysql://localhost:3306/sms_db";
	 Connection con1=DriverManager.getConnection(url1,"root","W7301@jqir#");
	 Statement st=con1.createStatement();
	 ResultSet rs=st.executeQuery("select * from student_info");
	 System.out.println("ID | Name | std | father | Mobile");
	 System.out.println("---------------------------------");
	 while(rs.next()) {
		 System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)
		 +" | "+rs.getString(4)+" | "+rs.getString(5));
	 }
 }
 
 public static void insert() throws SQLException {
	 Scanner s=new Scanner(System.in);
	 String url="jdbc:mysql://localhost:3306/sms_db";
	 Connection con=DriverManager.getConnection(url, "root", "W7301@jqir#");
     
	 System.out.println("Enter ur Name:");
     String n=s.nextLine();
     System.out.println("Enter ur Class:");
     String c=s.nextLine();
     System.out.println("Enter ur father Name:");
     String f=s.nextLine();
     System.out.println("Enter ur Mobile No:");
     String m=s.nextLine();
     
     String query="insert into student_info (name,std,fname,mobile) "
     		+ "value (?,?,?,?)";
     PreparedStatement ps=con.prepareStatement(query);
     ps.setString(1, n);
     ps.setString(2, c);
     ps.setString(3, f);
     ps.setString(4, m);
     ps.executeUpdate();
     System.out.println("Data inserted sucessfully.......");

 }

 public static void intro() {
	 System.out.println("************************************************");
	 System.out.println("*                STUDENTS MODULE                *");
	 System.out.println("*************************************************");
	 System.out.println("\n 1. Insert");
	 System.out.println("2. Edit");
	 System.out.println("3. view");
	 System.out.println("4. Delete");
	 System.out.println("5. Stop");
 }
 }

 



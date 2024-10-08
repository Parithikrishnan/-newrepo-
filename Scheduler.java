import java.util.Scanner;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Main{

public static void main(String[] args){
String url = "jdbc:mysql://localhost:3306/testing";
String username = "mysql";
String password = "helloworld";

Connection connection = DriverManager.getConnection(url,username,password);
System.out.println("Database is connected");
String sql = "SELECT * FROM your_table_name";
PreparedStatement preparedStatement = connection.prepareStatement(sql);
ResultSet resultSet = preparedStatement.executeQuery();


Scheduler scheduler = new Scheduler();
scheduler.saving();
}
}

public class Scheduler{

public static void saving(){

String[] response_getter = new String[10];
Scanner getter = new Scanner(System.in);
String title,time;
System.out.println("Enter the title: ");
title = getter.nextLine();
System.out.println("Ebter the date; ");
time = getter.nextLine();
System.out.println(title);
}

}

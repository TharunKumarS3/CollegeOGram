package com.CollgeOG.connection;
import java.sql.*;
public class DBconn {
	private static Connection conn=null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		if(conn==null)
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/jdbc", "root", "mysql12345");
			System.out.println("connected");
		}
		return conn;
	}

}

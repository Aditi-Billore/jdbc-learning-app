package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con;
	
	public static Connection createConnection() {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/student_manage";
			String user = "root";
			String password = "root";
			
			//create connection
			con = DriverManager.getConnection(url, user, password);
			
		}
		catch( Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}

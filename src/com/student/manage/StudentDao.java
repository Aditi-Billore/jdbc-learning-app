package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	public static boolean insertStudentToDB( Student st ) {
		
		boolean result = false;
		try {
			//jdbc connection
			Connection con = ConnectionProvider.createConnection();
			
			String q = "insert into students(sname, sphone, scity) values(?,?,?)";
			
			//Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the value of parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute
			pstmt.executeUpdate();
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean deleteStudent(int studentId) {

		boolean result = false;
		try {
			//jdbc connection
			Connection con = ConnectionProvider.createConnection();
			
			String q = "delete from students where sid = ?";
			
			//Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the value of parameters
			pstmt.setInt(1, studentId);
			
			//execute
			pstmt.executeUpdate();
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void showAllStudents() {
		try {
			//jdbc connection
			Connection con = ConnectionProvider.createConnection();
			
			String q = "select * from students";
			
			//statement
			Statement stmt = con.createStatement();
			ResultSet rs =  stmt.executeQuery(q);
			
			while(rs.next()) {
				int sid = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String city = rs.getString(4);
				
				System.out.println("studentId = "+ sid );
				System.out.println("studentName = "+ name );
				System.out.println("studentPhone = "+ phone );
				System.out.println("studentCity = "+ city );
				System.out.println("================================");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean updateStudent(int studentId) {

		boolean result = false;
		try {
			//jdbc connection
			Connection con = ConnectionProvider.createConnection();
			
			String q = "update students set sname = 'Anuradha' where sid = ?";
			
			//Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the value of parameters
			pstmt.setInt(1, studentId);
			
			//execute
			pstmt.executeUpdate();
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

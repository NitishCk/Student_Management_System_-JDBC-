package project.studentmanagementjdbc;

import java.sql.*;
import java.util.*;

public class StudentManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/Student_Management_System";
	private static final String USER = "root";
	private static final String PWD = "CKnitish007@";
	
	private static Connection establishConnection() throws SQLException  {
		return DriverManager.getConnection(URL, USER, PWD);
	}
	
	

	
	
	// Method to Add New Student
	public void addNewStudent(int rollNumber, String name, int age, String grade, String email) {
		
		String insertQuery = "INSERT INTO Students(s_rollnumber, s_name, s_age, s_grade, s_email) VALUES(?, ?, ?, ?, ?)";
		
		try{
			Connection conn = establishConnection();
			
			PreparedStatement pst = conn.prepareStatement(insertQuery);
			
			pst.setInt(1, rollNumber);
			pst.setString(2, name);
			pst.setInt(3, age);
			pst.setString(4, grade);
			pst.setString(5, email);
			
			int row = pst.executeUpdate();
			
			if(row > 0) {
				System.out.println(row + " row/ rows inserted successfully...");
			}
			else {
				System.out.println("Failed to Insert...");
			}
			
			pst.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// Method to List All Students
	public void displayAllStudents() {
		
		String selectQuery = "SELECT * FROM Students";
		
		try {
			Connection conn = establishConnection();
			
			PreparedStatement pst = conn.prepareStatement(selectQuery);
			
			ResultSet rs = pst.executeQuery();
			
			boolean hasData = false;
			
			while(rs.next()) {
				hasData = true;
				System.out.println("Roll No : " + rs.getInt(1) + " | " + "Name : " + rs.getString(2) + " | " + "Age : " + rs.getInt(3)
									+" | " + "Grade : " + rs.getString(4) + " | " + "Email : " + rs.getString(5));
			}

			if(hasData == false) {
				System.out.println("No Students Data to Display..!!!");
			}
			
			rs.close();
			pst.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// Method to Delete Student (By Roll Number)
	public void deleteStudent(int rollNumber) {
		
		String deleteQuery = "DELETE FROM Students WHERE s_rollnumber = ?";
		
		try {
			
			Connection conn = establishConnection();
			
			PreparedStatement pst = conn.prepareStatement(deleteQuery);
			
			pst.setInt(1, rollNumber);
			
			int row = pst.executeUpdate();
			
			if(row > 0) {
				System.out.println(row + " row deleted successfully...");
			}
			else {
				System.out.println("Student Not Found...!!!");
			}
			
			pst.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// Method to Search Student (By Roll Number)
	public boolean searchByRollNumber(int rollNumber) {
		
		String selectQuery = "SELECT * FROM Students WHERE s_rollnumber = ?";
		
		try {
			
			Connection conn = establishConnection();
			
			PreparedStatement pst = conn.prepareStatement(selectQuery);
			
			pst.setInt(1, rollNumber);
			
			ResultSet rs = pst.executeQuery();
			
				
			if(rs.next()) {
				System.out.println("Roll No : " + rs.getInt(1) + " | " + "Name : " + rs.getString(2) + " | " + "Age : " + rs.getInt(3)
					+" | " + "Grade : " + rs.getString(4) + " | " + "Email : " + rs.getString(5));
				return true;
			}
			else {
				System.out.println("Student Not Found...!!!");
				return false;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	// Method to List Students (By Grade)
	public void displayByGrade(String grade) {
		
		String selectQuery = "SELECT * FROM Students WHERE s_grade = ?";
		
		try {
			
			Connection conn = establishConnection();
			
			PreparedStatement pst = conn.prepareStatement(selectQuery);
			
			pst.setString(1, grade);
			
			ResultSet rs = pst.executeQuery();
			
			boolean hasData = false;
			
			while(rs.next()) {
				
				hasData = true;
				
				System.out.println("Roll No : " + rs.getInt(1) + " | " + "Name : " + rs.getString(2) + " | " + "Age : " + rs.getInt(3)
				+" | " + "Grade : " + rs.getString(4) + " | " + "Email : " + rs.getString(5));
			}
			
			if(hasData == false) {
				System.out.println("No Students Data to Display..!!!");
			}
			
			rs.close();
			pst.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// Method to Update Name
	public void updateName(int rollNumber, String name) {
		
		String updateQuery = "UPDATE Students SET s_name = ? WHERE s_rollnumber = ?";
		
		try {
			
			Connection conn = establishConnection();
			
			PreparedStatement pst = conn.prepareStatement(updateQuery);
			
			pst.setString(1, name);
			pst.setInt(2, rollNumber);
			
			int row = pst.executeUpdate();
			
			if(row > 0) {
				System.out.println(row + " row updated successfully...");
			}
			else {
				System.out.println("Student Not Found...!!!");
			}
			
			pst.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// Method to Update Age
	public void updateAge(int rollNumber, int age) {
		
		String updateQuery = "UPDATE Students SET s_age = ? WHERE s_rollnumber = ?";
		
		try {
			
			Connection conn = establishConnection();
			
			PreparedStatement pst = conn.prepareStatement(updateQuery);
			
			pst.setInt(1, age);
			pst.setInt(2, rollNumber);
			
			int row = pst.executeUpdate();
			
			if(row > 0) {
				System.out.println(row + " row updated successfully...");
			}
			else {
				System.out.println("Student Not Found...!!!");
			}
			
			pst.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Method to Update Grade
	public void updateGrade(int rollNumber, String grade) {
		
		String updateQuery = "UPDATE Students SET s_grade = ? WHERE s_rollnumber = ?";
		
		try {
			
			Connection conn = establishConnection();
			
			PreparedStatement pst = conn.prepareStatement(updateQuery);
			
			pst.setString(1, grade);
			pst.setInt(2, rollNumber);
			
			int row = pst.executeUpdate();
			
			if(row > 0) {
				System.out.println(row + " row updated successfully...");
			}
			else {
				System.out.println("Student Not Found...!!!");
			}
			
			pst.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Method to Update Email
	public void updateEmail(int rollNumber, String email) {

		String updateQuery = "UPDATE Students SET s_email = ? WHERE s_rollnumber = ?";
		
		try {
			
			Connection conn = establishConnection();
			
			PreparedStatement pst = conn.prepareStatement(updateQuery);
			
			pst.setString(1, email);
			pst.setInt(2, rollNumber);
			
			int row = pst.executeUpdate();
			
			if(row > 0) {
				System.out.println(row + " row updated successfully...");
			}
			else {
				System.out.println("Student Not Found...!!!");
			}
			
			pst.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}

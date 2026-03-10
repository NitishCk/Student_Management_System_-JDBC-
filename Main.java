package project.studentmanagementjdbc;

import java.sql.*;
import java.util.*;



public class Main {
	

	public static void main(String[] args) {
		
		
		StudentManager sm = new StudentManager();
		
		Scanner sc = new Scanner(System.in);
		
		boolean exit = false;
		
		while(!exit) {
			System.out.println("\n----------Student Management System----------");
			System.out.println("1. Add New Student");
			System.out.println("2. List All Students");
			System.out.println("3. Update Student Details");
			System.out.println("4. Delete a Student");
			System.out.println("5. Search a Student by Roll Number");
			System.out.println("6. List Students by Grade");
			System.out.println("7. Exit");
			System.out.print("\nEnter Your Choice - ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
				case 1:
					System.out.print("Enter the Student Roll Number - ");
					int rollno = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter the Student Name - ");
					String name = sc.nextLine();
					System.out.print("Enter the Student Age - ");
					int age = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter the Student Grade - ");
					String grade = sc.nextLine();
					System.out.print("Enter the Student Email - ");
					String email = sc.nextLine();
					
					sm.addNewStudent(rollno, name, age, grade, email);
					break;
					
				case 2:
					sm.displayAllStudents();
					break;
					
				case 3:
					
					System.out.print("Enter the Student Roll Number to Update - ");
					rollno = sc.nextInt();
					sc.nextLine();
					
					boolean isPresent = sm.searchByRollNumber(rollno);
					
					if(isPresent == false) {
						break;
					}
					
					System.out.println("Select The Field to Update Student Details :- ");
					System.out.println("1. Update Name");
					System.out.println("2. Update Age");
					System.out.println("3. Update Grade");
					System.out.println("4. Update Email");
					System.out.println("5. No Updates");
					System.out.print("\nEnter Your Choice - ");
					
					int option = sc.nextInt();
					sc.nextLine();
					
					switch (option){
						
						case 1:
							System.out.print("Please Enter the Updated Name - ");
							name = sc.nextLine();
							
							sm.updateName(rollno, name);
							break;
							
						case 2:
							System.out.print("Please Enter the Updated Age - ");
							age = sc.nextInt();
							sc.nextLine();
							
							sm.updateAge(rollno, age);
							break;
						
						case 3:
							System.out.print("Please Enter the Updated Grade - ");
							grade = sc.nextLine();
							
							sm.updateGrade(rollno, grade);
							break;
							
						case 4:
							System.out.print("Please Enter the Updated Email - ");
							email = sc.nextLine();
							
							sm.updateEmail(rollno, email);
							break;
							
						case 5:
							System.out.println("No Updates are Done...!!!");
							break;
							
						default:
							System.out.print("Please Select Valid Options to Update...!!!");
							break;
					}
					

					break;
					
				case 4:
					System.out.print("Enter the Student Roll Number to Delete - ");
					rollno = sc.nextInt();
					sc.nextLine();
					boolean exists = sm.searchByRollNumber(rollno);
					
					if(exists == false) {
						break;
					}
					
					System.out.println("Are you sure you want to Delete the Student Data ???");
					System.out.println("1. Yes");
					System.out.println("2. No");
					System.out.print("Enter Your Choice - ");
					int decision = sc.nextInt();
					sc.nextLine();
					
					switch(decision) {
						
						case 1:
							sm.deleteStudent(rollno);
							break;
						
						case 2:
							System.out.println("No Data has Been Deleted...!!!");
							break;
					}
					
					break;
					
				case 5:
					System.out.print("Enter the Student Roll Number - ");
					rollno = sc.nextInt();
					sc.nextLine();
					
					sm.searchByRollNumber(rollno);
					break;
				
				case 6:
					sc.nextLine();
					System.out.print("Enter the Grade - ");
					grade = sc.nextLine();
					
					sm.displayByGrade(grade);
					break;
					
				case 7:
					exit = true;
					System.out.println("------Thank You------");
					break;
					
				default:
					System.out.println("Enter a Valid Selection...!!!");
					break;
			}
		}
		
	}

}

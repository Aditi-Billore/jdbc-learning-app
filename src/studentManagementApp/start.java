package studentManagementApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class start {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome! Start of the application");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("PRESS 1 to ADD Student");
			System.out.println("PRESS 2 to DISPLAY Student");
			System.out.println("PRESS 3 to DELETE Student");
			System.out.println("PRESS 4 to UPDATE Student");
			System.out.println("PRESS 5 to Exit App");
			int c = Integer.parseInt(br.readLine());
			if(c==1) {
				//add students
				System.out.println("Enter Student Name : ");
				String name = br.readLine();
				
				System.out.println("Enter Student Phone : ");
				String phone = br.readLine();
				
				System.out.println("Enter Student City : ");
				String city = br.readLine();
				
				//create student object to store student
				Student st = new Student(name, phone, city);
				
				boolean answer = StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student added succesfully!");
				}
				else {
					System.out.println("Something went wrong");
				}
				System.out.println(st);
			}
			else if(c==2) {
				//display students
				StudentDao.showAllStudents();
			}
			else if(c==3) {
				//delete students
				System.out.println("Enter Student id to be deleted : ");
				int studentId = Integer.parseInt(br.readLine());
				boolean result = StudentDao.deleteStudent(studentId);
				if(result) {
					System.out.println("Student deleted succesfully!");
				}
				else {
					System.out.println("Something went wrong");
				}
			}
			else if(c==4) {
				//delete students
				System.out.println("Enter Student id to be updated : ");
				int studentId = Integer.parseInt(br.readLine());
				boolean result = StudentDao.updateStudent(studentId);
				if(result) {
					System.out.println("Student updated succesfully!");
				}
				else {
					System.out.println("Something went wrong");
				}
			}
			else if(c==5) {
				//exit
				break;
			}
			else {
				
			}
			 
		}
		System.out.println("Thank you for using this application");
	}

}

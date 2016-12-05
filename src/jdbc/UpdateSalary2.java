package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateSalary2 {

	public static void main(String[] args) throws Exception {
		
		try( Connection con =
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr") )
		{
		   Scanner s = new Scanner(System.in);
		   System.out.print("Enter employee id :");
		   int empid  = s.nextInt(); 
		   
   		   Statement st = con.createStatement();
   		   int count = st.executeUpdate
   				     ("update employees set salary = salary * 1.1 where employee_id = " + empid);
   		   if (count == 1)
   			   System.out.println("Updated Salary Successfully!");
   		   else
   			   System.out.println("Could not find employee!");
   		   
		}
		catch(Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}

	}

}

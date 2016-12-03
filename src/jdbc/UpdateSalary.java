package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateSalary {

	public static void main(String[] args) throws Exception {
		
		try( Connection con =
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr") )
		{
   		   Statement st = con.createStatement();
   		   int count = st.executeUpdate
   				     ("update employees set salary = salary * 1.1 where employee_id = 1111");
   		   if (count == 1)
   			   System.out.println("Updated Salary Successfully!");
   		   else
   			   System.out.println("Could not find employee!");
   		   
		}

	}

}

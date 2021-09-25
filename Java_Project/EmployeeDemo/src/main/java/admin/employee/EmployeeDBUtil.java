package admin.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class EmployeeDBUtil {

	public static List<Employee> validate(String userName, String password){
		
		ArrayList<Employee> emp = new ArrayList<>();
		
		//create database connection
		String url ="jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String password1 ="sume1234";
				
		//validate database
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			//create connection
			Connection con = DriverManager.getConnection(url, user, password1); 
			//create statement
			Statement state = con.createStatement();
			//sql quarry
			String sql = "select * from employee where username='"+userName+"'and password='"+password+"'";
			//run quarry
			ResultSet results  = state.executeQuery(sql);
			
			if (results.next()){
				int id = results.getInt(1);
				String name = results.getString(2);
				String designation = results.getString(3);
				String email = results.getString(4);
				String phone = results.getString(5);
				String usernameU = results.getString(6);
				String passwordU = results.getString(7);
				
				Employee e = new Employee(id,name,designation,email,phone,usernameU,passwordU);
				emp.add(e);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return emp;
		
	}
}

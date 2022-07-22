package UC5_selelct_data_within_datarange;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeConfig {
	
	  public static Connection getConfig() {
	        String dbURL = "jdbc:mysql://localhost:3306/payroll_service";
	        String uname = "root";
	        String pass = "Dhangar@1416";
	        Connection connection=null;

	        try {
	            connection = DriverManager.getConnection(dbURL, uname, pass);
	            if (connection != null) {
	                System.out.println("Connected!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }
	}



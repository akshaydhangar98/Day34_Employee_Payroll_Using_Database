package UC2_retrieving_data_with_datarange;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeePayroll {
	 public static void main(String[] args) {
	        String FETCH = "SELECT * FROM employee_payroll";
	        ArrayList<Employee> empList = new ArrayList<>();
	        EmployeeConfig eConfig = new EmployeeConfig();
	        eConfig.getConfig();
	        PreparedStatement preparedStatement;
	        try {
	            preparedStatement = eConfig.getConfig().prepareStatement(FETCH);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                Employee employee = new Employee();

	                employee.setEmpId(resultSet.getInt("Id"));
	                employee.setEmpName(resultSet.getString("Name"));
	                employee.setPhoneNumber(resultSet.getString("PhoneNumber"));
	                employee.setAddress(resultSet.getString("Address"));
	                employee.setDepartment(resultSet.getString("Department"));
	                employee.setEmpStart(resultSet.getString("Start"));
	                employee.setBasicPay(resultSet.getDouble("BasicPay"));
	                employee.setDeductions(resultSet.getDouble("Deductions"));
	                employee.setTaxablePay(resultSet.getDouble("TaxablePay"));
	                employee.setIncomeTax(resultSet.getDouble("IncomeTax"));
	                employee.setNetPay(resultSet.getDouble("NetPay"));

	                empList.add(employee);
	            }
	            for (Employee i : empList) {
	                System.out.println(i.toString());
	            }
	        }
	        catch (SQLException e) {
	            throw new EmployeeException("invalid column label");
	        }
	    }
	}


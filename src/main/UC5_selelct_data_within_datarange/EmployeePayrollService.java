package UC5_selelct_data_within_datarange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService {
	
	public ArrayList<Employee> empList;
    PreparedStatement preparedStatement;
    Connection connection =EmployeeConfig.getConfig();

    public List<Employee> queryExecute(String query) {
        empList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();

                employee.setEmpId(resultSet.getInt("Id"));
                employee.setEmpName(resultSet.getString("Name"));
                employee.setPhoneNumber(resultSet.getString("PhoneNumber"));
                employee.setAddress(resultSet.getString("Address"));
                employee.setDepartment(resultSet.getString("Department"));
                employee.setGender(resultSet.getString("Gender"));
                employee.setBasicPay(resultSet.getDouble("BasicPay"));
                employee.setDeductions(resultSet.getDouble("Deductions"));
                employee.setTaxablePay(resultSet.getDouble("TaxablePay"));
                employee.setIncomeTax(resultSet.getDouble("IncomeTax"));
                employee.setNetPay(resultSet.getDouble("NetPay"));
                employee.setEmpStart(resultSet.getString("Start"));

                empList.add(employee);
            }
        } catch ( SQLException e) {
            throw new EmployeeException("invalid column label");
        }
        return empList;
    }

    public void display() {
        for (Employee i : empList) {
            System.out.println(i.toString());
        }
    }

    public double updateBasicPay(String empName, double basicPay) {
        String UPDATE = "UPDATE employee_payroll SET BasicPay = ? WHERE Name = ?";
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setDouble(1, basicPay);
            preparedStatement.setString(2, empName);
            preparedStatement.executeUpdate();
            System.out.println("update successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM employee_payroll";
        queryExecute(sql);
        for (Employee employee : empList) {
            if (employee.getEmpName().equals(empName)) {
                return employee.getBasicPay();
            }
        }
        return 0.0;
    }

    public void selectEmployee(LocalDate start, LocalDate end){
        ArrayList<Employee> empSelected = new ArrayList<>();
        String select = "SELECT * FROM employee_payroll WHERE Start BETWEEN ? AND ?";
        String sDate = String.valueOf(start);
        String eDate = String.valueOf(end);
        try {
            preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1,sDate);
            preparedStatement.setString(2, eDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();

                employee.setEmpId(resultSet.getInt("Id"));
                employee.setEmpName(resultSet.getString("Name"));
                employee.setPhoneNumber(resultSet.getString("PhoneNumber"));
                employee.setAddress(resultSet.getString("Address"));
                employee.setDepartment(resultSet.getString("Department"));
                employee.setGender(resultSet.getString("Gender"));
                employee.setBasicPay(resultSet.getDouble("BasicPay"));
                employee.setDeductions(resultSet.getDouble("Deductions"));
                employee.setTaxablePay(resultSet.getDouble("TaxablePay"));
                employee.setIncomeTax(resultSet.getDouble("IncomeTax"));
                employee.setNetPay(resultSet.getDouble("NetPay"));
                employee.setEmpStart(resultSet.getString("Start"));

                empSelected.add(employee);
            }
            for (Employee employee:empSelected) {
                System.out.println(employee);
            }

        } catch (SQLException e) {
            throw new EmployeeException("Invalid date");
        }
    }
}


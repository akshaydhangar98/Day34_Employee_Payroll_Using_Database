package UC6_perform_calculation;

import java.time.LocalDate;
import java.util.Scanner;

public class EmployeePayroll {
	
	  public static void main(String[] args) {
	        EmployeePayrollService employeePayRollService = new EmployeePayrollService();
	        Scanner scanner = new Scanner(System.in);

	        final int EXIT = 10;
	        int choice = 0;
	        while (choice != EXIT) {
	            System.out.println("Enter Your Choice\n1. Get employee data\n2. update basic pay\n3. display employee roll\n4. empdata range  \n5. calculate \n6. EXIT\n");
	            choice = scanner.nextInt();
	            switch (choice) {
	                case 1 -> {
	                    String query = "select * from employee_payroll";
	                    employeePayRollService.queryExecute(query);
	                    employeePayRollService.display();
	                }
	                case 2 -> {
	                    System.out.println("enter employee name");
	                    String empName = scanner.next();
	                    System.out.println("enter basic pay you want to update");
	                    double basicPay = scanner.nextDouble();
	                    employeePayRollService.updateBasicPay(empName, basicPay);
	                }
	                case 3 -> employeePayRollService.display();
	                case 4 -> {
	                    System.out.println("enter initial date");
	                    LocalDate iDate = LocalDate.parse(scanner.next());
	                    System.out.println("enter final date");
	                    LocalDate eDate = LocalDate.parse(scanner.next());
	                    employeePayRollService.getEmployee(iDate, eDate);
	                }
	                case 5 -> employeePayRollService.calculate();
	                case 6 -> System.out.println("good bye");
	            }
	        }
	        scanner.close();
	    }
	}


package UC_3_4_update_basicpay;

import java.util.Scanner;

import UC1_establishing_connection.EmployeeException;
import UC1_establishing_connection.EmployeePayrollService;

public class EmployeePayroll {
	
	 public static void main(String[] args) {
	        EmployeePayrollService employeePayRollService = new EmployeePayrollService();
	        Scanner scanner = new Scanner(System.in);

	        final int EXIT = 10;
	        int choice = 0;
	        while (choice != EXIT) {
	            System.out.println("enter your choice\n1. Execute query\n2. update basic pay\n3. display employee roll\n10. EXIT");
	            choice = scanner.nextInt();
	            switch (choice) {
	                case 1 : {
	                    String query = "select * from employee_payroll";
	                    try {
							employeePayRollService.queryExecute(query);
						} catch (EmployeeException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                    employeePayRollService.display();
	                }
	                case 2 : {
	                    System.out.println("enter employee name");
	                    String empName = scanner.next();
	                    System.out.println("enter basic pay you want to update");
	                    double basicPay = scanner.nextDouble();
	                    try {
							employeePayRollService.updateBasicPay(empName, basicPay);
						} catch (EmployeeException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
	                case 3 : employeePayRollService.display();
	                case 10: System.out.println("good bye");
	            }
	        }
	    }
	}



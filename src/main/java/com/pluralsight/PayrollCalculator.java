package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            bufReader.readLine();

            String input;

            while((input = bufReader.readLine()) != null) {
                String[] inputSections = input.split("[|]");

                int employeeId = Integer.parseInt(inputSections[0]);
                String name = inputSections[1];
                double hoursWorked = Double.parseDouble(inputSections[2]);
                double payRate = Double.parseDouble(inputSections[3]);

                Employee employeeInfo = new Employee(employeeId, name, hoursWorked, payRate);

                double grossPay = employeeInfo.getGrossPay();

                System.out.printf("Employee ID: %s | Name: %s | Gross Pay: $%s\n", employeeId, name, grossPay);

            }
            bufReader.close();
        } catch(IOException err) {
            err.printStackTrace();
        }
    }
}

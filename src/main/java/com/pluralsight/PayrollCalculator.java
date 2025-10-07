package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            // Skips first read line in file
            // May not be the best option, useful for skipping the first line
            bufReader.readLine();

            // Defines string for taking in csv text
            String input;

            // While loop to read through the file, line by line. Splits the lines using the "|" delimiter
            // Then assign each array of values to the corresponding variables from the employee class
            // Makes new objects for each employee
            while((input = bufReader.readLine()) != null) {
                String[] inputSections = input.split("[|]");

                // Assigns variables for each list from the split
                int employeeId = Integer.parseInt(inputSections[0]);
                String name = inputSections[1];
                double hoursWorked = Double.parseDouble(inputSections[2]);
                double payRate = Double.parseDouble(inputSections[3]);

                // Makes new objects from the info sent in from each list made
                Employee employeeInfo = new Employee(employeeId, name, hoursWorked, payRate);

                // Calls the gross pay method and calculates gross pay
                double grossPay = employeeInfo.getGrossPay();

                // Prints out employee id, name, and gross pay
                System.out.printf("Employee ID: %s | Name: %s | Gross Pay: $%s\n", employeeId, name, grossPay);

            }
            bufReader.close();
        } catch(IOException err) {
            err.printStackTrace();
        }
    }
}

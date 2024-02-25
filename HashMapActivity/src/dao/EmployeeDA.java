package dao;

import domain.Employee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeDA
{
    private HashMap<String, Employee> employeeMap ;

    public HashMap<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public void setEmployeeMap(HashMap<String, Employee> courseMap) {
        this.employeeMap = employeeMap;
    }

    public EmployeeDA(String empNo) {

        try {
            Scanner employeeFile = new Scanner(new FileReader("src/emp.csv"));
            employeeMap = new HashMap<String, Employee>();

            Employee employee = new Employee();

            employeeFile.nextLine();
            Integer key = 0;
            while (employeeFile.hasNext()) {

                String employeeLineData = new String();
                employeeLineData = employeeFile.nextLine();
                String[] splitData = new String[3];
                splitData = employeeLineData.split(",");

                employee.setEmpNo(splitData[0].trim());
                employee.setLastName(splitData[1].trim());
                employee.setFirstName(splitData[2].trim());



            }



            } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}



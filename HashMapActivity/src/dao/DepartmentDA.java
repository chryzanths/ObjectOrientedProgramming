package dao;

import domain.Department;
import domain.Employee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;

public class DepartmentDA
{
    public DepartmentDA() {

        try {
            Scanner departmentFile = new Scanner(new FileReader("src/dep.csv"));
            departmentFile.nextLine();
            while (departmentFile.hasNext()) {
                String lineData = new String();
                lineData = departmentFile.nextLine();
                String[] splitData = new String[3];
                splitData = lineData.split(",");

                Department department = new Department();

                department.setDepCode(splitData[0].trim());
                department.setDepName(splitData[1].trim());
                //department.setDepTotalSalary(Double.valueOf(splitData[2].trim()));

                Scanner deptEmpFile = new Scanner(new FileReader("src/deptemp.csv"));
                deptEmpFile.nextLine();
                while (deptEmpFile.hasNext()); {

                    String line = new String();
                    line = deptEmpFile.nextLine();
                    String[] split = new String[3];
                    split = line.split(",");

                    Employee employee = new Employee();

                    EmployeeDA employeeDA = new EmployeeDA(employee.getEmpNo());
                    employee.setEmployeeMap(employeeDA.getEmployeeMap());
                    Double counter = 0.0;
                    Double salary =  0.0;
                    Double salaryData =  0.0;
                    Double salaryTotal = 0.0;

                    for (Map.Entry<String, Employee> employeeMap : employeeDA.getEmployeeMap().entrySet()) {
                        salary += employeeMap.getValue().getSalary();
                        salaryData = salary;
                        salaryTotal = salary + salaryData;
                        counter++;
                    }
                    department.setDepTotalSalary(salaryTotal);
                    department.getDepCode(split[0].trim());;

                    System.out.println("Department code: " + department.getDepCode(""));
                    System.out.println("Department name: " + department.getDepName());
                    System.out.println("Department total salary: " + department.getDepTotalSalary());
                    System.out.println(" ---------- Details ---------");
                    System.out.println("EmpNo\tEmployee Name\tSalary");

                    for(Map.Entry<String, Employee> employeeEntryMap: employeeDA.getEmployeeMap().entrySet()){
                        System.out.print(employeeEntryMap.getValue().getEmpNo() + "\t");
                        System.out.print(employeeEntryMap.getValue().getLastName() + ", " + employeeEntryMap.getValue().getFirstName() + "\t");
                        System.out.print(employeeEntryMap.getValue().getSalary());
                    }
                    System.out.println();

                }

            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    }

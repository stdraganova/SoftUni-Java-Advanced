package JavaAdvanced.DefiningClasses.EX.CompanyRoster;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // Map to store employees per department
        Map<String, List<Employee>> employeesInDepartment = new HashMap<>();

        // Reading the input
        for (int i = 0; i < n; i++) {
            String[] employeeData = scanner.nextLine().split("\\s+");
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];

            Employee employee;
            if (employeeData.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (employeeData.length == 5) {
                if (employeeData[4].contains("@")) {
                    employee = new Employee(name, salary, position, department, employeeData[4]);
                } else {
                    employee = new Employee(name, salary, position, department, Integer.parseInt(employeeData[4]));
                }
            } else {
                employee = new Employee(name, salary, position, department, employeeData[4], Integer.parseInt(employeeData[5]));
            }

            // Add employee to the department
            employeesInDepartment.putIfAbsent(department, new ArrayList<>());
            employeesInDepartment.get(department).add(employee);
        }

        // Find the department with the highest average salary
        String topDepartment = employeesInDepartment.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue()
                        .stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .orElse(0.0)))
                .map(Map.Entry::getKey)
                .orElse(null);

        if (topDepartment != null) {
            System.out.printf("Highest Average Salary: %s%n", topDepartment);

            // Print employees in the top department sorted by salary (descending)
            employeesInDepartment.get(topDepartment)
                    .stream()
                    .sorted(Comparator.comparing(Employee::getSalary).reversed())
                    .forEach(System.out::println);
        }
    }
}

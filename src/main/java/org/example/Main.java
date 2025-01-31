package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    private static Map<Integer, Employee> employeeMap;
    private static List<Employee> duplicates;


    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();


        employees.add(new Employee(1, "Emir", "Koral"));
        employees.add(new Employee(2, "Erim", "Eriz"));
        employees.add(new Employee(3, "Kanat", "Baykal"));
        employees.add(new Employee(1, "Emir", "Koral"));
        employees.add(new Employee(2, "Erim", "Eriz"));
        employees.add(new Employee(4, "Batur", "Balcı"));


        System.out.println(removeDuplicates(employees));
        System.out.println(WordCounter.calculatedWord());


    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        employeeMap = new HashMap<>();
        duplicates = new ArrayList<>();
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("null");
                continue;

            }
            if (employeeMap.containsKey(employee.getId())) {
                duplicates.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("null");
                continue;

            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);
            }

        }
        return employeeMap;
    }


    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> unique = findUniques(employees);
        List<Employee> uniques = new LinkedList<>(unique.values());

        uniques.removeAll(duplicates);
        return uniques;
    }


}


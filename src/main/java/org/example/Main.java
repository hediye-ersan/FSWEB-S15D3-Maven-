package org.example;
import org.example.entity.Employee;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"John", "Doe"));
        employees.add(new Employee(2,"Jane", "Doe"));
        employees.add(new Employee(3,"Jack", "Max"));
        employees.add(new Employee(4,"Sarah", "Fox"));
        employees.add(new Employee(2,"Cloe", "Zoe"));
        employees.add(new Employee(1,"Haily", "Karl"));

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Duplicates: " + duplicates);


        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println("Uniques: " + uniques.values());


        List<Employee> noDuplicates = removeDuplicates(employees);
        System.out.println("Without Duplicates: " + noDuplicates);
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        List<Employee> duplicates = new ArrayList<>();
        Set<Employee> seen = new HashSet<>();
        for (Employee employee : employees) {
            if (!seen.add(employee)) {
                duplicates.add(employee);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees){
        Map<Integer, Employee> uniques = new HashMap<>();
        Map<Integer, Integer> frequency = new HashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                frequency.put(employee.getId(), frequency.getOrDefault(employee.getId(), 0) + 1);
            }
        }
        for (Employee employee : employees) {
            if (employee != null && (frequency.get(employee.getId()) == 1 || !uniques.containsKey(employee.getId()))) {
                uniques.put(employee.getId(), employee);
            }
        }
        return uniques;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Integer, Integer> frequency = new HashMap<>();
        List<Employee> result = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee != null) {
                frequency.put(employee.getId(), frequency.getOrDefault(employee.getId(), 0) + 1);
            }
        }
        for (Employee employee : employees) {
            if (employee != null && frequency.get(employee.getId()) == 1) {
                result.add(employee);
            }
        }
        return result;
    }
}
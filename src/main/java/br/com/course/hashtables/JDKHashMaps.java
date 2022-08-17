package br.com.course.hashtables;

import java.util.HashMap;
import java.util.Map;

import br.com.course.common.Employee;

public class JDKHashMaps {
    
    public static void main(String[] args) {
        
        Map<String, Employee> map = new HashMap<>();

        map.put("Jones", new Employee("Joseph", "Jones", 1));
        map.put("Anderson", new Employee("Anne", "Anderson", 2));
        map.put("Simpson", new Employee("Anthony", "Simpson", 3));
        map.put("Mathews", new Employee("Edward", "Mathews", 4));
        map.put("Jacobs", new Employee("Blaire", "Jacobs", 5));

        map.forEach((k, v) -> System.out.println("{" + k + " -> " + v + "}"));

        System.out.println("-------------");

        map.put("Wilson", new Employee("Anthony", "Wilson", 6));

        map.forEach((k, v) -> System.out.println("{" + k + " -> " + v + "}"));

        System.out.println("-------------");

        map.remove("Wilson");

        map.forEach((k, v) -> System.out.println("{" + k + " -> " + v + "}"));
    }
}

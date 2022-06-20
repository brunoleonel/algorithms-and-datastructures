package br.com.course.lists;

import java.util.List;
import java.util.Vector;

public class Vectors {
    
    public static void main(String[] args) {
        
        //Vectors are also backed by an array of default size of 10 items like ArrayLists
        //Unlike ArrayLists, they are synchronized and thread-safe, but a little less performant too
        List<Employee> employeeList = new Vector<>();
        employeeList.add(new Employee("John", "Doe", 1));
        employeeList.add(new Employee("Jane", "Doe", 3));
        employeeList.add(new Employee("John", "Deacon", 12));
        employeeList.add(new Employee("Brian", "May", 22));

        employeeList.forEach(e -> System.out.println(e));
        System.out.println(employeeList.get(0));
        
        //Shows the size of the list, and not the capacity of the back array
        System.out.println(employeeList.size());

        //Adds a new element to the end of the list. If the back array is full, it is resized before.
        employeeList.add(new Employee("Peter", "Quill", 26));

        //Replaces the element in the specified index
        employeeList.set(1, new Employee("Drax", "The Destroyer", 64));

        System.out.println(employeeList.contains(new Employee("John", "Doe", 1)));

        //Removing an item can degrade the performance, cause the other items will be shifted to the left
        employeeList.remove(0);

        employeeList.forEach(s -> System.out.println(s));
    }
}

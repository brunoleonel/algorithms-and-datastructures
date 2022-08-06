package br.com.course.lists;

import java.util.LinkedList;

import br.com.course.common.Employee;

public class JDKLinkedLists {
    
    public static void main(String[] args) {
        
        //JDK LinkedLists are doubly linked lists
        LinkedList<Employee> employeeList = new LinkedList<>();
        employeeList.addFirst(new Employee("John", "Doe", 1));
        employeeList.addFirst(new Employee("Jane", "Doe", 3));
        employeeList.addFirst(new Employee("John", "Deacon", 12));
        employeeList.addFirst(new Employee("Brian", "May", 22));

        employeeList.forEach(e -> System.out.println(e));
        System.out.println(employeeList.get(0));
        
        System.out.println(employeeList.size());

        //The add method adds an element in the end of the list, like addLast.
        //To add an element in the first position, the method is addFirst.
        employeeList.add(new Employee("Peter", "Quill", 26));

        //The remove method removes an element in the head of the list, like removeFirst.
        //To remove an element in the tail, the method is removeLast.
        employeeList.remove();

        employeeList.forEach(s -> System.out.println(s));
    }
}

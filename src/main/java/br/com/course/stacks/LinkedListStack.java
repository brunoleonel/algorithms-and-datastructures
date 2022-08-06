package br.com.course.stacks;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.ListIterator;

import br.com.course.common.Employee;

public class LinkedListStack {
    
    private LinkedList<Employee> stack;
    private int top;

    public LinkedListStack() {
        this.stack = new LinkedList<>();
    }

    public void push(Employee employee) {
        this.stack.push(employee);
    }

    public Employee pop() {
        return this.stack.pop();
    }

    public Employee peek() {
        return this.stack.peek();
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public void print() {
        ListIterator<Employee> it = this.stack.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        
        ArrayStack stack = new ArrayStack(5);
        stack.push(new Employee("Joseph", "Jones", 1));
        stack.push(new Employee("Anne", "Jones", 2));
        stack.push(new Employee("Anthony", "Jones", 3));
        stack.push(new Employee("Edward", "Jones", 4));
        stack.push(new Employee("Blaire", "Jones", 5));

        stack.print();
        
        System.out.println("--------------------------");
        
        System.out.println(stack.peek());
        System.out.println("--------------------------");
        stack.print();

        System.out.println("--------------------------");

        stack.pop();
        stack.print();

        System.out.println("--------------------------");
    }
}

package br.com.course.stacks;

import java.util.EmptyStackException;

import br.com.course.common.Employee;

public class ArrayStack {
    
    private Employee[] stack;
    private int top;

    public ArrayStack(int capacity) {
        this.stack = new Employee[capacity];
    }

    public void push(Employee employee) {
        if (top == stack.length) {
            //Resizing the backing array
            Employee[] resized = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, resized, 0, stack.length);
            this.stack = resized;
        }

        this.stack[top++] = employee;
    }

    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        Employee employee = this.stack[--this.top];
        this.stack[top] = null;
        return employee;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return this.stack[this.top - 1];
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public void print() {
        for (int i = this.top - 1; i >= 0; i--) {
            System.out.println(this.stack[i]);
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

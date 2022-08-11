package br.com.course.queues;

import java.util.NoSuchElementException;

import br.com.course.common.Employee;

public class ArrayQueue {
    
    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if (back == queue.length) {
            Employee[] resized = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, resized, 0, queue.length);
            queue = resized;
        }

        queue[back] = employee;
        back++;
    }

    public Employee remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];
        queue[front] = null;
        front++;

        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return employee;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public void print() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }

    public static void main(String[] args) {
        
        ArrayQueue queue = new ArrayQueue(5);
        
        queue.add(new Employee("Joseph", "Jones", 1));
        queue.add(new Employee("Anne", "Jones", 2));
        queue.add(new Employee("Anthony", "Jones", 3));
        queue.add(new Employee("Edward", "Jones", 4));
        queue.add(new Employee("Blaire", "Jones", 5));
        queue.print();

        System.out.println("--------------");

        queue.add(new Employee("William", "Johnson", 6));
        queue.print();

        System.out.println("--------------");
        System.out.println("Peek:" + queue.peek());

        System.out.println("--------------");

        System.out.println("Remove: " + queue.remove());
        queue.print();
    }
}

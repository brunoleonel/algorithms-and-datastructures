package br.com.course.queues;

import java.util.NoSuchElementException;

import br.com.course.common.Employee;

public class CircularArrayQueue {
    
    private Employee[] queue;
    private int front;
    private int back;

    public CircularArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if (size() == queue.length - 1) {
            int numItems = size();
            Employee[] resized = new Employee[2 * queue.length];
            System.arraycopy(queue, front, resized, 0, queue.length - front);
            System.arraycopy(queue, 0, resized, queue.length - front, back);
            queue = resized;
            front = 0;
            back = numItems;
        }

        queue[back] = employee;
        
        if (back < queue.length - 1) {
            back++;
            return;
        }

        back = 0;
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
        } else if (front == queue.length) {
            front = 0;
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
        if (front <= back) {
            return back - front;
        }

        return back - front + queue.length;
    }

    public void print() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
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

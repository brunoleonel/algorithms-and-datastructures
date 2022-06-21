package br.com.course.lists;

import br.com.course.lists.doublylinked.EmployeeDoublyLinkedList;

public class DoublyLinkedLists {
    
    public static void main(String[] args) {
        
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee janeDoe = new Employee("Jane", "Doe", 3);
        Employee johnDeacon = new Employee("John", "Deacon", 12);
        Employee brianMay = new Employee("Brian", "May", 22);

        EmployeeDoublyLinkedList linkedList = new EmployeeDoublyLinkedList();
        linkedList.addToFront(johnDoe);
        linkedList.addToFront(janeDoe);
        linkedList.addToFront(johnDeacon);
        linkedList.addToFront(brianMay);

        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.getSize());
        linkedList.printList();
        linkedList.removeFromFront();
        linkedList.printList();
        linkedList.addToEnd(new Employee("Johny", "Lawrence", 27));
        linkedList.printList();
        linkedList.removeFromEnd();
        linkedList.printList();
    }
}

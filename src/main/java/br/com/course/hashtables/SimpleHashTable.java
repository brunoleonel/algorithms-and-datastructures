package br.com.course.hashtables;

import br.com.course.common.Employee;

public class SimpleHashTable {
    
    private Employee[] hashtable;

    public SimpleHashTable() {
        hashtable = new Employee[10];
    }

    public void put(String key, Employee employee) {
        int hash = hashKey(key);
        
        if (hashtable[hash] != null) {
            System.out.println("Sorry, position " + hash + " is not available.");
        } else {
            hashtable[hash] = employee;
        }
    }

    public Employee get(String key) {
        int hash = hashKey(key);
        if (hashtable[hash] == null) {
            System.out.println("Element not found with key " + hash);
        }
        return hashtable[hash];
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void print() {
        for (int i = 0; i < hashtable.length; i++) {
            System.out.println(hashtable[i]);
        }
    }

    public static void main(String[] args) {
        
        SimpleHashTable hashTable = new SimpleHashTable();

        hashTable.put("Jones", new Employee("Joseph", "Jones", 1));
        hashTable.put("Anderson", new Employee("Anne", "Anderson", 2));
        hashTable.put("Simpson", new Employee("Anthony", "Simpson", 3));
        hashTable.put("Mathews", new Employee("Edward", "Mathews", 4));
        hashTable.put("Jacobs", new Employee("Blaire", "Jacobs", 5));

        hashTable.print();

        System.out.println("-------------");

        hashTable.put("Jacobs", new Employee("Anthony", "Jacobs", 6));

        System.out.println("-------------");

        hashTable.get("Jacobs");

        System.out.println("-------------");

        hashTable.get("Richards");
    }
}

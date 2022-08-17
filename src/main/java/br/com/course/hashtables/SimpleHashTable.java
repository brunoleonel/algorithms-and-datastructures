package br.com.course.hashtables;

import br.com.course.common.Employee;
import br.com.course.common.KeyValueEmployee;

public class SimpleHashTable {
    
    private KeyValueEmployee[] hashtable;

    public SimpleHashTable() {
        hashtable = new KeyValueEmployee[10];
    }

    public void put(String key, Employee employee) {
        int hash = hashKey(key);
        
        if (occupied(hash)) {
            int stopIndex = hash;
            if (hash == hashtable.length - 1) {
                hash = 0;
            } else {
                hash++;
            }

            while (occupied(hash) && hash != stopIndex) {
                hash = (hash + 1) % hashtable.length;
            }
        }

        if (occupied(hash)) {
            System.out.println("Sorry, position " + hash + " is not available.");
        } else {
            hashtable[hash] = new KeyValueEmployee(key, employee);
        }
    }

    public Employee get(String key) {
        int hash = findKey(key);
        if (hash == -1) {
            return null;
        }
        return hashtable[hash].getEmployee();
    }

    public Employee remove(String key) {
        int hash = findKey(key);
        if (hash == -1) {
            return null;
        }

        Employee employee = hashtable[hash].getEmployee();
        hashtable[hash] = null;
        KeyValueEmployee[] oldHashtable = hashtable;
        hashtable = new KeyValueEmployee[oldHashtable.length];
        
        for (int i = 0; i < hashtable.length; i++) {
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].getKey(), oldHashtable[i].getEmployee());
            }
        } 

        return employee;
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    private int findKey(String key) {
        int hash = hashKey(key);
        if (hashtable[hash] != null && key.equals(hashtable[hash].getKey())) {
            return hash;
        }
        
        int stopIndex = hash;
        if (hash == hashtable.length - 1) {
            hash = 0;
        } else {
            hash++;
        }

        while (hash != stopIndex && 
            hashtable[hash] != null && 
            !key.equals(hashtable[hash].getKey())) {
            hash = (hash + 1) % hashtable.length;
        }

        if (hashtable[hash] != null && key.equals(hashtable[hash].getKey())) {
            return hash;
        }

        return -1;
    }

    public void print() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println(i + "=>  Empty");
            } else {
                System.out.println(i + " => " + hashtable[i].getEmployee());
            }
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

        hashTable.put("Wilson", new Employee("Anthony", "Wilson", 6));

        hashTable.print();

        System.out.println("-------------");

        hashTable.remove("Wilson");

        hashTable.print();
    }
}

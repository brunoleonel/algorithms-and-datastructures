package br.com.course.hashtables;

import java.util.LinkedList;
import java.util.ListIterator;

import br.com.course.common.Employee;
import br.com.course.common.KeyValueEmployee;

public class ChainedHashTable {

    private LinkedList<KeyValueEmployee>[] hashtable;

    public ChainedHashTable() {
        hashtable = new LinkedList[10];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<>();
        }
    }

    public void put(String key, Employee employee) {
        int hash = hashKey(key);
        hashtable[hash].add(new KeyValueEmployee(key, employee));
    }

    public Employee get(String key) {
        int hash = hashKey(key);
        ListIterator<KeyValueEmployee> it = hashtable[hash].listIterator();
        KeyValueEmployee item = null;
        
        while (it.hasNext()) {
            item = it.next();
            if (key.equals(item.getKey())) {
                return item.getEmployee();
            }
        }

        return null;
    }

    public Employee remove(String key) {
        int hash = hashKey(key);
        ListIterator<KeyValueEmployee> it = hashtable[hash].listIterator();
        KeyValueEmployee item = null;
        
        int index = -1;
        while (it.hasNext()) {
            item = it.next();
            index++;
            if (key.equals(item.getKey())) {
                break;
            }
        }

        if (item == null || !key.equals(item.getKey())) {
            return null;
        } 

        hashtable[hash].remove(index);
        return item.getEmployee();
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void print() {
        System.out.print("\n");
        for (int i = 0; i < hashtable.length; i++) {
            if (!hashtable[i].isEmpty()) {
                System.out.print("["+ i + "] ");
                ListIterator<KeyValueEmployee> it  = hashtable[i].listIterator();
                while (it.hasNext()) {
                    System.out.print(it.next().getEmployee());
                    System.out.print(" -> ");
                }
                System.out.print("null ");
            }

            System.out.print("[" + i + "] Empty -> ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        
        ChainedHashTable hashTable = new ChainedHashTable();

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

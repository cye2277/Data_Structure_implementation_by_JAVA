package com.company;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        ChainedHashtable ht = new ChainedHashtable();
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);

        ht.printHashtable();

    }
    private LinkedList<StoredEmployee>[] hashtable;

    public ChainedHashtable(){
        hashtable  = new LinkedList[10];
        for (int i = 0; i< hashtable.length;i++){
            hashtable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while (iterator.hasNext()){
            employee = iterator.next();
            if (employee.key.equals(key)){
                return employee.employee;
            }
        }
        return null;
    }

    public Employee remove(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee remove = null;
        int index = -1;
        while (iterator.hasNext()){
            index++;
            remove = iterator.next();
            if (remove.key.equals(key)){
                break;
            }

        }
        if (remove == null){
            return null;
        }
        else{
            hashtable[hashedKey].remove(index);
            return remove.employee;
        }
    }

    public int hashKey(String key){
        return Math.abs(key.hashCode() % hashtable.length);
    }

    public void printHashtable(){
        for (int i =0; i< hashtable.length;i++){
            if (hashtable[i].isEmpty()){
                System.out.println("position"+i+":empty");
            }
            else{
                System.out.println("position "+ i + ":");
                ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()){
                    System.out.println(iterator.next().employee);
                    System.out.println("->");
                }
                System.out.println("null");
            }
        }
    }


    public class StoredEmployee{
        public String key;
        public Employee employee;

        public StoredEmployee(String key, Employee employee){
            this.key = key;
            this.employee = employee;
        }
    }
}

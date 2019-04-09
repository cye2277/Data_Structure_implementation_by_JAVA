package com.company;

public class SimpleHashtable {
    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        SimpleHashtable ht = new SimpleHashtable();
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);

        ht.printHashtable();

        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
        System.out.println("Retrieve key Smith: " + ht.get("Smith"));

        ht.remove("Wilson");
        ht.remove("Jones");
        ht.printHashtable();

        System.out.println("Retrieve key Smith: " + ht.get("Smith"));
    }

    public static StoredEmployee[] hashtable;

    public SimpleHashtable(){
        hashtable = new StoredEmployee[10];
    }

    public static void put(String name,Employee employee){
        int hashedKey = hashKey(name);
        if (contains(hashedKey)){
            int stopIndex = hashedKey;
            if (hashedKey == hashtable.length-1){
                hashedKey = 0;
            }
            else{
                hashedKey++;
            }
            while (contains(hashedKey) && hashedKey != stopIndex){
                hashedKey = (hashedKey+1) % hashtable.length;
            }

        }

        if(contains(hashedKey)){
            System.out.println("Sorry, there are already an employee at position" + hashedKey);
        }
        else{
            hashtable[hashedKey] = new StoredEmployee(name,employee);
        }
    }


    public static boolean contains(int key){
        if (hashtable[key] != null){
            return true;
        }
        return false;
    }

    public static Employee get(String name){
        int hashedKey = findKey(name);
        if (hashedKey != -1){
            return hashtable[hashedKey].employee;
        }else{
            return null;
        }
    }

    public static Employee remove(String name){
        int hashedKey = findKey(name);
        if (hashedKey == -1){
            return null;
        }
        Employee employee = hashtable[hashedKey].employee;
        hashtable[hashedKey] = null;

        //Because we just create a null value in the table, so we need to rehash the following hashtable to fit the way we find the correspond value

        StoredEmployee[] oldHashtable = hashtable;
        hashtable = new StoredEmployee[oldHashtable.length];
        for (int i =0; i< oldHashtable.length;i++){
            if (oldHashtable[i] != null){
                put(oldHashtable[i].key,oldHashtable[i].employee);
            }
        }
        return employee;

    }

    public static int findKey(String name){
        int hashedKey = hashKey(name);
        if (hashtable[hashedKey]!= null && hashtable[hashedKey].key.equals(name)){
            return hashedKey;
        }

        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length-1){
            hashedKey = 0;
        }
        else{
            hashedKey++;
        }

        while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(name)){
            hashedKey = (hashedKey +1) % hashtable.length;
        }

        if (hashtable[hashedKey]!= null && hashtable[hashedKey].key.equals(name)){
            return  hashedKey;
        }else{
            return -1;
        }
    }


    public static void printHashtable(){
        for (int i = 0; i< hashtable.length;i++){
            if (hashtable[i] == null){
                System.out.println("Position " + i + " is null");
            }else{
                System.out.println("Position " + i + ":" + hashtable[i].employee);
            }
        }
    }

    public static int hashKey(String name){
        return name.hashCode() % hashtable.length;

    }



    public static class StoredEmployee {

        public String key;
        public Employee employee;

        public StoredEmployee(String key, Employee employee) {
            this.key = key;
            this.employee = employee;
        }

    }

}

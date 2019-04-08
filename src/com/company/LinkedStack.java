package com.company;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack {
    private LinkedList<Employee> stack;
    public LinkedStack(){
        stack = new LinkedList<Employee>();
    }

    public void push(Employee employee){
        stack.push(employee);
    }

    public Employee pop(){
        return stack.pop();
    }

    public Employee peek(){
        return stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void printStack(){
        ListIterator<Employee> iterator = stack.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(new Employee("Jane","Jones",123));
        stack.push(new Employee("John","Doe",4567));
        stack.push(new Employee("Yuen","Tsai",132));
        stack.push(new Employee("Kuanchen","Chou",321));
        stack.push(new Employee("Bill","End",12543));
        stack.printStack();

        //System.out.println(stack.peek());
        //System.out.println("popped item: " + stack.pop());
    }

}


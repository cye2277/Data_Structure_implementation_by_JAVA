package com.company;

import java.util.EmptyStackException;
import java.util.Stack;

public class ArrayStack {
    private Employee[] stack ;
    private int top;

    public ArrayStack(int capacity){
        stack = new Employee[capacity];
    }
    public void push(Employee employee){
        if (top == stack.length){
            //resize the array
            Employee[] newArray = new Employee[stack.length*2];
            System.arraycopy(stack,0,newArray,0,stack.length);
            stack = newArray;
        }
        stack[top++] = employee;
    }

    public Employee pop(){
        if (isEmpyty()){
            throw new EmptyStackException();
        }

        Employee employee = stack[--top];
        stack[top] = null;
        return employee;
    }

    public Employee peek(){
        if (isEmpyty()){
            throw new EmptyStackException();
        }
        return stack[top-1];
    }
    public boolean isEmpyty(){
        return top == 0;
    }

    public void printStack(){
        for (int i = top-1; i>=0; i--){
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(new Employee("Jane","Jones",123));
        arrayStack.push(new Employee("John","Doe",4567));
        arrayStack.push(new Employee("Yuen","Tsai",132));
        arrayStack.push(new Employee("Kuanchen","Chou",321));
        arrayStack.push(new Employee("Bill","End",12543));
        arrayStack.printStack();

        System.out.println(arrayStack.peek());
    }
}

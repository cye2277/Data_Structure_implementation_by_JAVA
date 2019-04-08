package com.company;

import java.util.NoSuchElementException;

public class ArrayQueue {
    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity){
        queue = new Employee[capacity];
    }
    public void add(Employee employee){
        if (size() == queue.length -1){
            int numItem = size();
            Employee[] newArray = new Employee[2*queue.length];
            System.arraycopy(queue,front,newArray,0, queue.length-front);
            System.arraycopy(queue, 0, newArray, queue.length-back,back);
            queue = newArray;
            front = 0;
            back = numItem;
        }


        queue[back] = employee;
        if (back < queue.length -1){
            back++;
        }else{
            back = 0;
        }
    }
    public Employee remove(){
        if (size() == 0){
            throw new NoSuchElementException();
        }
        Employee employee = queue[front];
        queue[front] = null;
        front++;
        if (size() == 0){
            front = 0;
            back =0;
        }
        else if(front == queue.length){
            front = 0;
        }
        return employee;
    }

    public Employee peek(){
        if (size() == 0){
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public int size(){
        if (front <= back){
            return back-front;
        }else{
            return back-front+ queue.length;
        }
    }

    public void printQueue(){
        if (front <= back){
            for (int i =front; i< back; i++){
                System.out.println(queue[i]);
            }
        }else {
            for (int i = front; i< queue.length; i++){
                System.out.println(queue[i]);
            }
            for (int i = 0; i< back; i++){
                System.out.println(queue[i]);
            }
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.add(new Employee("Jane","Jones",123));
        queue.add(new Employee("John","Doe",4567));
        queue.add(new Employee("Yuen","Tsai",132));
        queue.add(new Employee("Kuanchen","Chou",321));
        queue.add(new Employee("Adriene","End",12543));
        queue.printQueue();
        System.out.println("-------------------");
        queue.remove();
        queue.printQueue();
    }
}

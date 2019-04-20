package com.company;

public class Heap {

    public int[] heap;
    public int size;

    public Heap(int capacity){
        heap = new int[capacity];
    }

    public void insert(int value){
        if (isFull()){
            throw new IndexOutOfBoundsException("Heap is full.");
        }

        heap[size] = value;
        fixHeapAbove(size);
        size++;

    }
    public boolean isFull(){
        return size == heap.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void fixHeapAbove(int index){
        int newValue = heap[index];
        while (index >0 && newValue > heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    public int delete(int index){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("This is empty");
        }
        int parent = getParent(index);
        int delete = heap[index];
        heap[index] = heap[size-1];
        if (index == 0 || heap[index] < heap[parent]){
            fixHeapBelow(index, size-1);
        }else{
            fixHeapAbove(index);
        }
        size--;

        return delete;
    }

    public void fixHeapBelow(int index, int lastHeapIndex ){
        int childToSwap;
        while (index <= lastHeapIndex){
            int left = getChild(index, true);
            int right = getChild(index, false);
            if (left<lastHeapIndex){
                if (right > lastHeapIndex){
                    childToSwap = left;
                }else{
                    childToSwap = (heap[left] >heap[right] ? left:right ) ;

                }
                if (heap[index]< heap[childToSwap]){
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                }
                else
                    {
                    break;
                }
                index = childToSwap;
            }else{
                break;
            }
        }

    }
    public int peek(){

        if (isEmpty()){
            throw new IndexOutOfBoundsException("It is empty");
        }
        return heap[0];
    }

    public int getParent(int index){
        return(index-1)/2;
    }

    public int getChild(int index, boolean left){
        return 2*index + (left ? 1 : 2);
    }


    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        System.out.println(heap.peek());

        heap.delete(0);
        heap.printHeap();

        System.out.println(heap.peek());

    }


}

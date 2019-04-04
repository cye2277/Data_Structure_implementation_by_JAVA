package com.company;

public class SelectionSort {
    public static void main(String[] args) {
        int[] intArray = {20,35,-1,-15,7,-22,22};
        for (int lastUnsortedIndex = intArray.length-1;lastUnsortedIndex>0; lastUnsortedIndex--){
            int large = 0;
            for (int i = 1; i<lastUnsortedIndex;i++){
                if (intArray[i] > intArray[large]){
                    large = i;
                }
            }
            swap(intArray,large,lastUnsortedIndex);
        }

        for (int i = 0; i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }

    public static void swap(int[] intArray,int i,int j){
        if (i ==j){
            return;
        }
        int tmp = intArray[i];
        intArray[i] = intArray[j];
        intArray[j] = tmp;
    }

}

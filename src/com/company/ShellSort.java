package com.company;

public class ShellSort {
    public static void main(String[] args) {
        int[] intArray = {20,35,-15,7,55,1,-22};
        for (int gap = intArray.length/2; gap > 0 ; gap /= 2 ){
            for (int i = gap; i<intArray.length;i++){

                int newELement = intArray[i];

                int j = i;

                while (j>=gap && intArray[j-gap]> newELement){
                    intArray[j] = intArray[j-gap];
                    j -= gap;
                }

                intArray[j] = newELement;
            }
        }
        for (int i = 0; i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }
}

package com.company;

public class RadixSort {
    public static void main(String[] args) {
        int[] radixArray = {4725, 4586, 1330, 8792, 1594, 5729};

        radixSort(radixArray,10,4);
        for (int i = 0; i< radixArray.length;i++){
            System.out.println(radixArray[i]);
        }

    }
    public static void radixSort(int[] input, int radix, int width){
        for (int i = 0; i< width; i++){
            radixSingleSort(input,i,radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix){
        int numItems = input.length;
        int[] countArray = new int[radix];
        for (int value: input){
            countArray[getDigit(position,value, radix)]++;
        }

        //for building the stable sort
        for (int i = 1; i<radix; i++){
            countArray[i] += countArray[i-1];
        }

        int[] tmp = new int[numItems];
        for (int tmpIndex = numItems-1;tmpIndex >= 0; tmpIndex--){
            tmp[--countArray[getDigit(position,input[tmpIndex],radix)]] = input[tmpIndex];
        }

        for (int tmpIndex = 0; tmpIndex<numItems; tmpIndex++){
            input[tmpIndex] = tmp[tmpIndex];
        }
    }

    public static int getDigit(int position, int value, int radix){
        return value/ (int) Math.pow(10,position) % radix;
    }
}

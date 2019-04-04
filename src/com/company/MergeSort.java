package com.company;

public class MergeSort {
    public static void main(String[] args) {
        int[] intArray = {20,35,-15,7,55,1,-22};

        mergeSort(intArray,0, intArray.length);

        for (int i = 0; i< intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }

    public static void mergeSort(int[] intArray,int start, int end){
        if (end - start  <2){
            return;
        }
        int mid =(start+end)/2;
        mergeSort(intArray,start,mid);
        mergeSort(intArray,mid, end);
        merge(intArray,start,mid,end);

    }
    public static void merge(int[] intArray, int start, int mid, int end){
        if (intArray[mid-1] <intArray[mid]){
            return;
        }
        int i = start;
        int j = mid;
        int tmpIndex = 0;

        int[] tmp = new int[end-start];
        while (i<mid && j< end){
            tmp[tmpIndex++] = intArray[i] <= intArray[j]? intArray[i++]:intArray[j++];
        }

        System.arraycopy(intArray,i,intArray,start+tmpIndex,mid-i);
        System.arraycopy(tmp,0, intArray,start,tmpIndex);
    }
}

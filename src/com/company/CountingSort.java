package com.company;

public class CountingSort {
    public static void main(String[] args) {
        int[] intArray = {1,3,5,2,5,3,5,8,9,4,3,6,8,0};

        countingSort(intArray,0,10 );

        for (int i = 0; i< intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }
    public static void countingSort(int[] nums, int min, int max){
        int[] count = new int[max-min+1];

        for (int i = 0; i<nums.length;i++){
            count[nums[i]-min]++;
        }
        int j = 0;
        for (int i = 0; i<count.length;i++){
            while (count[i]>0){
                nums[j++] = i+min;
                count[i]--;
            }
        }

    }
}

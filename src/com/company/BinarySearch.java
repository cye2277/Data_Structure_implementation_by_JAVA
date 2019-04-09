package com.company;

public class BinarySearch {
    public static void main(String[] args) {
        int[] intArray = {-22, -15, 1, 7, 20, 35, 55};
        System.out.println(iterativeBinarySearch(intArray,-22));
        System.out.println(iterativeBinarySearch(intArray,-15));
        System.out.println(iterativeBinarySearch(intArray,1));
        System.out.println(iterativeBinarySearch(intArray,7));
        System.out.println(iterativeBinarySearch(intArray,55));

    }

    public static int iterativeBinarySearch(int[] input, int value){
        int start = 0;
        int end =input.length;
        while(start< end){
            int midpoint = (start+end)/2;
            if (input[midpoint]== value){
                return midpoint;
            }
            else if(input[midpoint]< value){
                start = midpoint +1;
            }
            else{
                end = midpoint;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] input, int value){
        return recursiveBinarySearch(input,0,input.length,value);
    }
    public static int recursiveBinarySearch(int[] input, int start, int end, int value){
        if (start>end){
            return -1;
        }
        int midpoint = (start+end)/2;
        System.out.println("midpoint = " + midpoint);

        if (input[midpoint]== value){
            return midpoint;
        }
        else if (input[midpoint]< value){
            recursiveBinarySearch(input, midpoint+1,end,value);
        }
        else{
            return recursiveBinarySearch(input,0,midpoint,value);
        }
        return -1;
    }
}
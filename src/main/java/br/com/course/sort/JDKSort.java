package br.com.course.sort;

import java.util.Arrays;

public class JDKSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        //Uses QuickSort with two pivots 
        //Arrays.sort(intArray);

        //Uses a MergeSort and the default Arrays.sort in the end
        Arrays.parallelSort(intArray);

        for (int i = 0; i < intArray.length - 1; i++) {
            System.out.println(intArray[i]);
        }
    }
}

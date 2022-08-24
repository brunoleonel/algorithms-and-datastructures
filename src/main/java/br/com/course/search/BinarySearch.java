package br.com.course.search;

public class BinarySearch {
    
    public static void main(String[] args) {
        
        int[] intArray = {-22, -15, 1, 7, 20, 35, 55};

        System.out.println(iterativeSearch(intArray, -15));
        System.out.println(iterativeSearch(intArray, 35));
        System.out.println(iterativeSearch(intArray, 8888));
        System.out.println(iterativeSearch(intArray, 1));

        System.out.println("---------------");

        System.out.println(recursiveSearch(intArray, -15));
        System.out.println(recursiveSearch(intArray, 35));
        System.out.println(recursiveSearch(intArray, 8888));
        System.out.println(recursiveSearch(intArray, 1));
    }

    public static int iterativeSearch(int[] intArray, int value) {
        int start = 0;
        int end = intArray.length;

        while (start < end) {
            int midpoint = (start + end) / 2;
            if (intArray[midpoint] == value) {
                return intArray[midpoint];
            } else if (intArray[midpoint] < value) {
                start = midpoint + 1;
            } else {
                end = midpoint;
            }
        }

        return -1;
    }

    public static int recursiveSearch(int[] intArray, int value) {
        return recursiveSearch(intArray, 0, intArray.length, value);
    }

    public static int recursiveSearch(int[] intArray, int start, int end, int value) {
        if (start >= end) {
            return -1;
        }

        int midpoint = (start + end) / 2;

        if (intArray[midpoint] == value) {
            return intArray[midpoint];
        } else if (intArray[midpoint] < value) {
            return recursiveSearch(intArray, midpoint + 1, end, value);
        } else {
            return recursiveSearch(intArray, start, midpoint, value);
        }
    }
}

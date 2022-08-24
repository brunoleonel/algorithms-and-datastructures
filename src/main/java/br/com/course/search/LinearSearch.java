package br.com.course.search;

public class LinearSearch {
    
    public static void main(String[] args) {
        
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        System.out.println(linearSearch(intArray, -15));
        System.out.println(linearSearch(intArray, 1));
        System.out.println(linearSearch(intArray, 8888));
        System.out.println(linearSearch(intArray, -22));
    }

    private static int linearSearch(int[] intArray, int value) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == value) {
                return intArray[i];
            }
        }

        return -1;
    }
}

package br.com.course.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex --) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
        }

        for (int i = 0; i < intArray.length - 1; i ++) {
            System.out.println(intArray[i]);
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        if (index1 == index2) {
            return;    
        }

        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

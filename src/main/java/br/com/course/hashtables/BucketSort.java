package br.com.course.hashtables;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    
    public static void main(String[] args) {
        int[] values = { 54, 46, 83, 66, 95, 92, 43 };

        bucketSort(values);

        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }

    private static void bucketSort(int[] values) {
        List<Integer>[] buckets = new List[10]; 

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0; i < values.length; i++) {
            int hash = hash(values[i]); 
            buckets[hash].add(values[i]);
        }

        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int value : buckets[i]) {
                values[j++] = value;
            }
        }
    }

    private static int hash(int value) {
        return value / (int) 10;
    }
}

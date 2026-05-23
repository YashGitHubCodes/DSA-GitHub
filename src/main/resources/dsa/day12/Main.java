package main.resources.dsa.day12;

//Question: Remove duplicates from a sorted array in-place and print unique values.
//        Pattern: Two pointer / write index
//Thought process: Because array is sorted, duplicates are adjacent. Keep first element as accepted. Copy current value only when different from previous value.
//        Complexity: TC = O(n), SC = O(1)
//Java Solution:
// Question: Remove duplicates from sorted array in-place.

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 4, 4};
        if (arr == null || arr.length == 0) {
            System.out.println("Array is null or empty");
            return;
        }
        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[index++] = arr[i];
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.println(arr[i]);
        }
    }
}

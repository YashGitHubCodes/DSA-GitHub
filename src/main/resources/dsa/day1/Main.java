package main.resources.dsa.day1;

//Question: Given an integer array/list, find the maximum element. Handle null/empty and negative numbers.
//Pattern: Linear traversal / running maximum
//Thought process: Initially using max = 0 fails for all-negative input. Use Integer.MIN_VALUE or initialize from first valid element after validation.
//        Complexity: TC = O(n), SC = O(1)

// Question: Find maximum element in an array/list.
// Important: Do not initialize max as 0 because array may contain all negative values.
public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 9, 2, 7, 5};
        if (arr == null || arr.length == 0) {
            System.out.println("Array is null or empty");
            return;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum number: " + max);
    }
}


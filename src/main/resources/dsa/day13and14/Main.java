package main.resources.dsa.day13and14;

//Question: Array contains numbers from 1 to n with exactly one number missing. Find missing number without depending on sorting.
//        Pattern: Mathematical sum formula
//Thought process: Expected sum of 1..n minus actual sum gives missing number. Use long because multiplication may overflow if n is int.
//Complexity: TC = O(n), SC = O(1)
//Java Solution:
// Question: Find missing number from 1 to n where exactly one number is missing.

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        if (arr == null || arr.length == 0) {
            System.out.println("Array is null or empty");
            return;
        }
        long n = arr.length + 1L;
        long expectedSum = n * (n + 1) / 2;
        long actualSum = 0;
        for (int value : arr) {
            actualSum += value;
        }
        System.out.println("Missing number: " + (expectedSum - actualSum));
    }
}

package main.resources.dsa.day28;

//Question: Find maximum sum of any contiguous subarray.
//        Pattern: Kadane algorithm / running sum
//Thought process: Add current value to running sum. Update max. If running sum becomes negative, reset it to 0 because negative baggage hurts future sums. Initialize max with arr[0] for all-negative arrays.
//Complexity: TC = O(n), SC = O(1)
//Java Solution:
// Question: Maximum Sum Subarray using Kadane's Algorithm.
public class Main {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        if (arr == null || arr.length == 0) {
            System.out.println("Array is null or empty");
            return;
        }
        int sum = 0;
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println("Maximum subarray sum: " + max);
    }
}

package main.resources.dsa.day2;

//Question: Find the second largest distinct element in an array.
//        Pattern: One-pass tracking with max and secondMax
//Thought process: When a new max is found, old max becomes secondMax. Duplicates should not become second largest. If secondMax remains unset, no second largest exists.
//        Complexity: TC = O(n), SC = O(1)

// Question: Find second largest distinct element.
// Thought: Maintain max and secondMax in one traversal.
public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 10, 8, 7, 6};
        if (arr == null || arr.length < 2) {
            System.out.println("No second largest available");
            return;
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int value : arr) {
            if (value > max) {
                secondMax = max;
                max = value;
            } else if (value > secondMax && value < max) {
                secondMax = value;
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            System.out.println("No second max value available");
        } else {
            System.out.println("Second largest: " + secondMax);
        }
    }
}
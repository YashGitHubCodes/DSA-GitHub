package main.resources.dsa.day7;

//Question: Find sum of all elements in an array.
//Pattern: Accumulator pattern
//Thought process: Use long for sum when values may be large. int can overflow.
//        Complexity: TC = O(n), SC = O(1)

// Question: Find sum of all array elements.
// Use long to reduce overflow risk for large integer sums.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 8};
        long sum = 0;
        if (arr == null || arr.length == 0) {
            System.out.println("Array is null or empty");
            return;
        }
        for (int value : arr) {
            sum += value;
        }
        System.out.println("Sum: " + sum);
    }
}
package main.resources.dsa.day24;

//Question: Move all negative numbers to left side. Order is not important. Treat 0 as non-negative.
//        Pattern: Two pointer partition
//Thought process: If left is already negative, move start. If right is non-negative, move end. Otherwise swap misplaced values.
//Complexity: TC = O(n), SC = O(1)
//Java Solution:
// Question: Move all negative numbers to left side. Order is not important.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, -1, 5, 0};
        int start = 0, end = arr.length - 1;

        while (start < end) {
            if (arr[start] < 0) {
                start++;
            } else if (arr[end] >= 0) {
                end--;
            } else {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        for (int value : arr) System.out.println(value);
    }
}

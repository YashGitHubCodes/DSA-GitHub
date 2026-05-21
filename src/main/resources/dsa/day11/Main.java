package main.resources.dsa.day11;

//Question: Move all zeroes to end while maintaining relative order of non-zero elements.
//Pattern: Stable in-place write pointer
//Thought process: Use insert index for next non-zero. After copying non-zero elements forward, fill rest with zeroes. Do not use swap-with-end because it breaks order.
//        Complexity: TC = O(n), SC = O(1)

//Java Solution:
// Question: Move all zeroes to end, maintaining order of non-zero elements.

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }
        for (int i = index; i < arr.length; i++) {
            arr[i] = 0;
        }
        for (int value : arr) System.out.println(value);
    }
}

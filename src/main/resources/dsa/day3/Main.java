package main.resources.dsa.day3;

//Question: Reverse an array in-place.
//        Pattern: Two pointers / swapping
//Thought process: Use start and end pointers. Swap and move inward. Stop at start < end because same middle element need not be swapped.
//        Complexity: TC = O(n), SC = O(1)

// Question: Reverse an array in-place.
// Pattern: Two pointers.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int start = 0, end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
        for (int value : arr) System.out.println(value);
    }
    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
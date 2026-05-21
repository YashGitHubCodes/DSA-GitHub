package main.resources.dsa.day4;

//Question: Check whether an array is sorted in non-decreasing order. Equal adjacent values are allowed.
//        Pattern: Adjacent comparison / early break
//Thought process: Compare arr[i] and arr[i+1]. If current > next, array is not sorted. Best case is O(1) when failure appears at first comparison.
//Complexity: TC = Best O(1), Worst O(n), SC = O(1)

// Question: Check if array is sorted in non-decreasing order.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4};
        if (arr == null || arr.length == 0) {
            System.out.println("Array is null or empty");
            return;
        }
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }
        System.out.println(isSorted ? "Array is sorted" : "Array is not sorted");
    }
}

package main.resources.dsa.day5;

//Question: Given an array and target, return the first index of target. If not found, return -1.
//Pattern: Linear search / early termination
//Thought process: Loop from left to right. Return immediately when target is found. For duplicates, first occurrence is returned.
//        Complexity: TC = Best O(1), Worst O(n), SC = O(1)


// Question: Linear search. Return first index of target, else -1.
public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 7, 3};
        int target = 7;
        int indexOfTarget = -1;

        if (arr == null || arr.length == 0) {
            System.out.println("Array is null or empty");
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    indexOfTarget = i;
                    break;
                }
            }
            System.out.println("Index of target: " + indexOfTarget);
        }
    }
}
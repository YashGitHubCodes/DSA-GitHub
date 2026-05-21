package main.resources.dsa.day8;

//Question: Find maximum and minimum elements in one traversal.
//Pattern: Running min and max
//Thought process: Validate before accessing arr[0]. Initialize max and min from first element, then loop from index 1.
//Complexity: TC = O(n), SC = O(1)

// Question: Find largest and smallest element together.
public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 9, 3};
        if (arr == null || arr.length == 0) {
            System.out.println("Array is null or empty");
            return;
        }
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
package main.resources.dsa.day10;

//Question: Two arrays are equal if same size, same elements, and same order.
//        Pattern: Length check + index-wise comparison
//Thought process: Check length first. Then compare corresponding elements. Return false immediately when mismatch occurs.
//Complexity: TC = O(n), SC = O(1)


// Question: Check if two arrays are equal: same length, same values, same order.
public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        System.out.println(areEqual(arr1, arr2));
    }
    private static boolean areEqual(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) return arr1 == arr2;
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}

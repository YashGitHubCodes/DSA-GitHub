package main.resources.dsa.day6;

//Question: Count even numbers in an array. Variation: count odd numbers.
//        Pattern: Counting pattern
//Thought process: Maintain count and increment when condition matches. Only condition changes for odd/even.
//        Complexity: TC = O(n), SC = O(1)


// Question: Count even numbers in an array. For odd numbers use arr[i] % 2 != 0.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 8};
        int count = 0;
        if (arr == null || arr.length == 0) {
            System.out.println("Array is null or empty");
            return;
        }
        for (int value : arr) {
            if (value % 2 == 0) {
                count++;
            }
        }
        System.out.println("Even count: " + count);
    }
}
package main.resources.dsa.day21;

//Question: Find maximum number of consecutive 1s in binary array.
//Pattern: Running streak counter
//Thought process: Increment current count for 1. Reset count to 0 for 0. Track maxCount throughout.
//        Complexity: TC = O(n), SC = O(1)
//Java Solution:
// Question: Find maximum consecutive ones.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        int count = 0;
        int maxCount = 0;

        for (int value : arr) {
            if (value == 1) {
                count++;
                if (count > maxCount) maxCount = count;
            } else {
                count = 0;
            }
        }
        System.out.println("Maximum consecutive ones: " + maxCount);
    }
}

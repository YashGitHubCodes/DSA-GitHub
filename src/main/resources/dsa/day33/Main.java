package main.resources.dsa.day33;

//Question: Count continuous subarrays whose sum equals k. Negative numbers may exist.
//        Pattern: Prefix sum + HashMap frequency
//        Thought process: Sliding window works only for positive numbers. With negatives, use prefix sum. If currentSum - k existed earlier, the subarray between those prefix sums has sum k.
//        Complexity: TC = O(n), SC = O(n)
//        Java Solution:


// Question: Count subarrays with sum equal to k.
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, -1, 2, 3};
        int k = 4;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;

        map.put(0, 1); // handles subarray starting at index 0

        for (int value : arr) {
            sum += value;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println("Count: " + count);
    }
}

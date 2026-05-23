package main.resources.dsa.day22;

//Question: Return indices of two numbers whose sum equals target. Same index cannot be reused.
//        Pattern: HashMap complement lookup
//        Thought process: For current value, complement = target - current. Check complement before inserting current value to handle duplicates like [3,3].
//        Complexity: TC = O(n), SC = O(n)
//        Java Solution:
// Question: Two Sum - return indices of two numbers whose sum equals target.
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 3};
        int target = 6;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                System.out.println(map.get(complement) + ", " + i);
                return;
            }
            map.put(arr[i], i);
        }
        System.out.println("No pair found");
    }
}

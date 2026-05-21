package main.resources.dsa.day9;

//Question: Find duplicate elements in an array, print each duplicate once.
//        Pattern: HashMap frequency counting
//Thought process: HashMap is useful when count/frequency is needed. After counting, print keys where value > 1.
//Complexity: TC = O(n), SC = O(n)

// Question: Find duplicate elements using HashMap frequency count.
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 5, 1};
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int value : arr) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}

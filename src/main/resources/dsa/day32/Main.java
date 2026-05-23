package main.resources.dsa.day32;

//Question: Find length of longest consecutive value sequence in an unsorted array.
//        Pattern: HashSet + sequence start detection
//        Thought process: Only start counting from numbers where num - 1 is absent. This prevents recounting from middle elements.
//        Complexity: TC = O(n), SC = O(n)
//        Java Solution:
// Question: Longest consecutive sequence.
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        HashSet<Integer> set = new HashSet<>();
        for (int value : arr) set.add(value);

        int maxSequenceValue = 0;
        for (int value : set) {
            if (!set.contains(value - 1)) { // true start of a sequence
                int current = value;
                int sequenceValue = 0;
                while (set.contains(current)) {
                    sequenceValue++;
                    current++;
                }
                maxSequenceValue = Math.max(maxSequenceValue, sequenceValue);
            }
        }
        System.out.println("Max sequence length: " + maxSequenceValue);
    }
}

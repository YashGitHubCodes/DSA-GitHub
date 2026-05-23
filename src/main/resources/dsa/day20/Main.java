package main.resources.dsa.day20;

//Question: Find duplicate elements in array, output each duplicate once.
//        Pattern: Two HashSets: seen and duplicates
//        Thought process: HashSet.add() returns false if element already exists. Use second set to store duplicate results uniquely.
//        Complexity: TC = O(n), SC = O(n)
//        Java Solution:
// Question: Find duplicate elements using HashSet.
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 5, 1};
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int value : arr) {
            if (!seen.add(value)) {
                duplicates.add(value);
            }
        }
        System.out.println(duplicates);
    }
}

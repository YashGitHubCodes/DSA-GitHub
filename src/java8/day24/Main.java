package java8.day24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("java", "spring", "boot");

        // Question: Find longest string.
        // Thought process: Do not map to length, because that loses original string.
        // max() returns the actual String; Comparator compares by String length.
        String longest = names.stream()
                .max(Comparator.comparing(String::length))
                .orElse("");

        System.out.println(longest);
    }
}

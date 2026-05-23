package java8.day15;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("amit", "raj", "alex", "neha");

        // Question: Count names starting with letter 'a'.
        // Thought process: filter names using startsWith(), then count().
        // count() returns long.
        long count = names.stream()
                .filter(x -> x.startsWith("a"))
                .count();

        System.out.println(count);
    }
}

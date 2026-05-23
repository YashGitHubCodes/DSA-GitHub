package java8.day09;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Question: Find first element greater than 3.
        // Thought process: filter matching values, then findFirst().
        // findFirst() returns Optional<Integer>, so use orElse fallback.
        int first = numbers.stream()
                .filter(x -> x > 3)
                .findFirst()
                .orElse(-1);

        System.out.println(first);
    }
}

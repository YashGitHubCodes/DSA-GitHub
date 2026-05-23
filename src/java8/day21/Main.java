package java8.day21;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8);

        // Question: Check whether all numbers are even.
        // Thought process: allMatch returns true only if every number satisfies predicate.
        boolean result = numbers.stream()
                .allMatch(x -> x % 2 == 0);

        System.out.println(result);
    }
}

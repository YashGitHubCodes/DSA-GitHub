package java8.day03;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Question: Find sum of all numbers.
        // Thought process: mapToInt converts Stream<Integer> to IntStream.
        // sum() on IntStream returns int.
        int sum = numbers.stream()
                .mapToInt(x -> x)
                .sum();

        System.out.println(sum);
    }
}

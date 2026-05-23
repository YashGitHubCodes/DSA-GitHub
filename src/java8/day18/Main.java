package java8.day18;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Question: Find sum of all even numbers.
        // Thought process: filter even numbers, then sum.
        // Use mapToLong for safer large-sum handling.
        long sum = numbers.stream()
                .mapToLong(x -> x)
                .filter(x -> x % 2 == 0)
                .sum();

        System.out.println(sum);
    }
}

package java8.day13;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Question: Find sum of squares of all numbers.
        // Thought process: map each number to square, then use sum().
        int sum = numbers.stream()
                .mapToInt(x -> x * x)
                .sum();

        System.out.println(sum);
    }
}

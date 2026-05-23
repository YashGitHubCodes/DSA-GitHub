package java8.day17;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20);

        // Question: Check whether any number is greater than 18.
        // Thought process: anyMatch directly answers existence question.
        // It returns boolean and stops early once match is found.
        boolean result = numbers.stream()
                .anyMatch(x -> x > 18);

        System.out.println(result);
    }
}

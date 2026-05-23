package java8.day08;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Question: Count even numbers.
        // Thought process: Filter first, then count.
        // count() returns long, not int.
        long count = numbers.stream()
                .filter(x -> x % 2 == 0)
                .count();

        System.out.println(count);
    }
}

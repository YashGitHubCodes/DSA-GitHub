package java8.day30;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        // Question: Check whether no number is negative.
        // Thought process: noneMatch returns true when no element matches the condition.
        boolean result = numbers.stream()
                .noneMatch(x -> x < 0);

        System.out.println(result);
    }
}

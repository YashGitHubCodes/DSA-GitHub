package java8.day06;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Question: Find maximum number.
        // Thought process: mapToInt gives IntStream; max() returns OptionalInt.
        // orElse(Integer.MIN_VALUE) handles empty stream safely.
        int max = numbers.stream()
                .mapToInt(x -> x)
                .max()
                .orElse(Integer.MIN_VALUE);

        System.out.println(max);
    }
}

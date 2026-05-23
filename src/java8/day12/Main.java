package java8.day12;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 3);

        // Question: Find minimum number.
        // Thought process: min() on IntStream returns OptionalInt.
        // orElseThrow accepts Supplier, so use lambda with new NoSuchElementException.
        int min = numbers.stream()
                .mapToInt(x -> x)
                .min()
                .orElseThrow(() -> new NoSuchElementException("Minimum value not found"));

        System.out.println(min);
    }
}

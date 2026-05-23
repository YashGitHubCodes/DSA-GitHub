package java8.day27;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("java", "spring", "boot", "microservices");

        // Question: Find length of longest string.
        // Thought process: Final result is int length, not String.
        // mapToInt(String::length) gives IntStream; max() returns OptionalInt.
        int maxLength = names.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        System.out.println(maxLength);
    }
}

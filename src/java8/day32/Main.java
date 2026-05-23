package java8.day32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("java", "spring", "boot");

        // Question: Create a single comma-separated string.
        // Thought process: joining(",") joins without space; joining(", ") joins with space.
        String result = names.stream()
                .collect(Collectors.joining(","));

        System.out.println(result);
    }
}

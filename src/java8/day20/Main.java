package java8.day20;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("amit", "raj", "alex", "neha");

        // Question: Convert names into comma-separated string.
        // Thought process: joining() is the dedicated collector for String joining.
        String result = names.stream()
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}

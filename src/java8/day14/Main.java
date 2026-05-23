package java8.day14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("amit", "raj", "neha", "alex");

        // Question: Find names whose length is >= 4.
        // Thought process: This is filtering, final output is List<String>.
        List<String> result = names.stream()
                .filter(x -> x.length() >= 4)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}

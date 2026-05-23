package java8.day01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("amit", "neha", "raj");

        // Question: Convert all names to uppercase and collect into a List.
        // Thought process: This is transformation, so use map().
        // collect(Collectors.toList()) converts Stream<String> back to List<String>.
        List<String> result = names.stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(result);
    }
}

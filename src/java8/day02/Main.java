package java8.day02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("amit", "neha", "raj");

        // Question: Convert all names to uppercase using Java 8 method reference.
        // Thought process: String::toUpperCase is equivalent to x -> x.toUpperCase().
        List<String> result = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}

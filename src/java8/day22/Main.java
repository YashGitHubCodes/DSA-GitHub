package java8.day22;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("amit", "raj", "alex", "neha", "raj");

        // Question: Find duplicate elements using Java 8 streams.
        // Thought process: groupingBy builds frequency map. counting() returns Long counts.
        // Then filter entries where count > 1 and print keys.
        names.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey()));
    }
}

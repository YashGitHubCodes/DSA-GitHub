package java8.day26;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("java", "spring", "boot", "microservices", "node");

        // Question: Group strings by length.
        // Thought process: groupingBy(String::length) creates Map<Integer, List<String>>.
        // Default downstream collector is Collectors.toList().
        Map<Integer, List<String>> result = names.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(result);
    }
}

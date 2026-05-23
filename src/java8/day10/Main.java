package java8.day10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("neha", "amit", "raj");

        // Question: Convert all names to uppercase and sort alphabetically.
        // Thought process: map transforms values; sorted orders them; collect returns List.
        List<String> result = names.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
    }
}

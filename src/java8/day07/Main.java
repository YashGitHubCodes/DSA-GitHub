package java8.day07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("raj", "amit", "neha");

        // Question: Sort names in ascending order.
        // Thought process: sorted() returns Stream<String>, so collect to List.
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedNames);
    }
}

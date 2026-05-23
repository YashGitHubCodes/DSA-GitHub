package java8.day28;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("java", "spring", "java", "boot", "spring");

        // Question: Count frequency of each string.
        // Thought process: groupingBy groups same strings; counting counts each group.
        // Final datatype is Map<String, Long> because counting() returns Long.
        Map<String, Long> frequencyMap = names.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        System.out.println(frequencyMap);
    }
}

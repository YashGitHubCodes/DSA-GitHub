package java8.day23;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);

        // Question: Partition numbers into even and odd numbers.
        // Thought process: partitioningBy creates true/false groups based on predicate.
        // true -> even, false -> odd.
        Map<Boolean, List<Integer>> result = numbers.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));

        System.out.println(result);
    }
}

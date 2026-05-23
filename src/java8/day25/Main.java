package java8.day25;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Question: Create Map<number, square>.
        // Thought process: Use toMap when we need key -> value mapping.
        Map<Integer, Integer> result = numbers.stream()
                .collect(Collectors.toMap(x -> x, x -> x * x));

        System.out.println(result);
    }
}

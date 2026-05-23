package java8.day16;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

        // Question: Find average of all numbers.
        // Thought process: IntStream has average(), which returns OptionalDouble.
        double average = numbers.stream()
                .mapToInt(x -> x)
                .average()
                .orElse(-1);

        System.out.println(average);
    }
}

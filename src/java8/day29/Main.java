package java8.day29;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 1, 4, 2, 3);

        // Question: Sort numbers in descending order.
        // Thought process: sorted() natural order is ascending; use Comparator.reverseOrder() for descending.
        List<Integer> result = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(result);
    }
}

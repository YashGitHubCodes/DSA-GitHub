package java8.day31;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

        // Question: Find first even number.
        // Thought process: filter even numbers first; findFirst returns Optional<Integer>.
        int firstEven = numbers.stream()
                .filter(x -> x % 2 == 0)
                .findFirst()
                .orElse(-1);

        System.out.println(firstEven);
    }
}

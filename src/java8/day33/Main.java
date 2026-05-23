package java8.day33;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Question: Partition numbers into prime and non-prime.
        // Thought process: partitioningBy creates true/false groups based on isPrime predicate.
        // true -> prime numbers, false -> non-prime numbers.
        Map<Boolean, List<Integer>> result = numbers.stream()
                .collect(Collectors.partitioningBy(Main::isPrime));

        System.out.println(result);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

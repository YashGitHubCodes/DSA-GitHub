package java8.day19;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("amit", "raj", "alex", "neha");

        // Question: Check whether all names have length greater than 2.
        // Thought process: allMatch means every element must satisfy condition.
        boolean result = names.stream()
                .allMatch(x -> x.length() > 2);

        System.out.println(result);
    }
}

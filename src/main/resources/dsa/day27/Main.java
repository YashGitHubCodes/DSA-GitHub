package main.resources.dsa.day27;

//Question: Find length of longest substring without repeating characters.
//        Pattern: Sliding window + HashSet
//        Thought process: Window is between start and i. If current char already exists, remove characters from left until duplicate disappears. Then add current char and update max length.
//        Complexity: TC = O(n), SC = O(n)
//        Java Solution:
// Question: Longest substring without repeating characters.
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String str = "cadbzabcd";
        if (str == null || str.length() == 0) {
            System.out.println("String is null or empty");
            return;
        }
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            while (set.contains(current)) {
                set.remove(str.charAt(start));
                start++;
            }
            set.add(current);
            if (i - start + 1 > maxLength) {
                maxLength = i - start + 1;
            }
        }
        System.out.println("Maximum length: " + maxLength);
    }
}

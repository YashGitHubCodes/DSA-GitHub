package main.resources.dsa.day17;

//Question: Find first character in a string whose frequency is 1.
//        Pattern: HashMap frequency + original order traversal
//        Thought process: First count frequencies. Then traverse original string again to preserve first occurrence order.
//        Complexity: TC = O(n), SC = O(n)
//        Java Solution:
// Question: Find first non-repeating character.
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String str = "aabbcdde";
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        char ans = '\0';
        for (char ch : str.toCharArray()) {
            if (map.get(ch) == 1) {
                ans = ch;
                break;
            }
        }
        System.out.println(ans == '\0' ? "No non-repeating character" : ans);
    }
}

package main.resources.dsa.day23;

//Question: Check if two strings contain same characters with same frequencies.
//        Pattern: Frequency counting using one HashMap
//        Thought process: Length check first. Increment counts using first string, decrement using second string. All counts must be zero.
//        Complexity: TC = O(n), SC = O(n)
//        Java Solution:
//// Question: Valid Anagram using one HashMap.
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str1 = "yashhay";
        String str2 = "yyaashh";
        System.out.println(isAnagram(str1, str2));
    }
    private static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        if (str1.length() != str2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str2.toCharArray()) {
            if (!map.containsKey(ch)) return false;
            map.put(ch, map.get(ch) - 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }
}

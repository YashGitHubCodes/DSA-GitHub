package main.resources.dsa.day15;

//Question: Check whether a string reads the same forward and backward.
//Pattern: Two pointers on string
//Thought process: Compare start and end characters. Return false immediately on mismatch. Stop when start >= end.
//        Complexity: TC = O(n), SC = O(1)
//Java Solution:
// Question: Check palindrome string.
public class Main {
    public static void main(String[] args) {
        String str = "madam";
        if (str == null || str.length() == 0) {
            System.out.println("String is null or empty");
        } else {
            System.out.println(validatePalindrome(str) ? "Palindrome" : "Not palindrome");
        }
    }
    private static boolean validatePalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }
}

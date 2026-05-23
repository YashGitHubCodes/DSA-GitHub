package main.resources.dsa.day26;

//Question: Reverse word order in a sentence, not characters inside words.
//        Pattern: Split + two pointer reverse on String[]
//Thought process: Use split to get words. Reverse the String array. Join back with spaces. This gives "Java love I", not "avaJ evol I".
//Complexity: TC = O(n), SC = O(n)
//Java Solution:
// Question: Reverse words in a sentence, not characters.
public class Main {
    public static void main(String[] args) {
        String str = "I love Java";
        if (str == null || str.length() == 0) {
            System.out.println("String is null or empty");
            return;
        }
        String[] words = str.split(" ");
        int start = 0, end = words.length - 1;
        while (start < end) {
            String temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
        System.out.println(String.join(" ", words));
    }
}

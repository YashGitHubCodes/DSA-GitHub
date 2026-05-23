package main.resources.dsa.day25;

//Question: Find longest word in a sentence. If tie, keep first longest word.
//        Pattern: String split + running longest
//Thought process: Split sentence into words. Use > instead of >= so first longest word wins in tie.
//        Complexity: TC = O(n), SC = O(n)
//Java Solution:
// Question: Find longest word in a sentence.
public class Main {
    public static void main(String[] args) {
        String str = "I love microservices architecture";
        if (str == null || str.length() == 0) {
            System.out.println("String is null or empty");
            return;
        }
        String[] words = str.split(" ");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        System.out.println("Longest word: " + longest);
    }
}

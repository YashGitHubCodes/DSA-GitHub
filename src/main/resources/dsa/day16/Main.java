package main.resources.dsa.day16;

//Question: Reverse characters of a string.
//        Pattern: Two pointers on char array
//Thought process: String is immutable, so convert to char[]. Swap characters, then create new String from char array.
//Complexity: TC = O(n), SC = O(n)
//Java Solution:
// Question: Reverse a string.

public class Main {
    public static void main(String[] args) {
        String str = "jayati";
        if (str == null || str.length() == 0) {
            System.out.println("String is null or empty");
            return;
        }
        char[] arr = str.toCharArray();
        int start = 0, end = arr.length - 1;
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        System.out.println("Reverse: " + new String(arr));
    }
}

package main.resources.dsa.day30;

//Question: For each index, return product of all elements except itself. Do not use division.
//Pattern: Prefix product + suffix product
//Thought process: answer[i] = product before i * product after i. Prefix and suffix arrays avoid nested loops and division.
//        Complexity: TC = O(n), SC = O(n)
//Java Solution:
// Question: Product of array except self without division.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] answer = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];
        }

        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }

        for (int i = 0; i < n; i++) {
            answer[i] = prefix[i] * suffix[i];
            System.out.println(answer[i]);
        }
    }
}

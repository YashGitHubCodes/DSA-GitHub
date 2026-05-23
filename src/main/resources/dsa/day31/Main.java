package main.resources.dsa.day31;

//Question: Given heights, find two lines that form container with maximum water area.
//        Pattern: Two pointers with greedy movement
//Thought process: Area = min(leftHeight, rightHeight) * width. Move pointer with smaller height because smaller wall limits water; moving taller wall cannot improve height while width shrinks.
//Complexity: TC = O(n), SC = O(1)
//Java Solution:
// Question: Container With Most Water.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int start = 0, end = arr.length - 1;
        long maxArea = 0;

        while (start < end) {
            long width = end - start;
            long height = Math.min(arr[start], arr[end]);
            long area = width * height;
            if (area > maxArea) maxArea = area;

            if (arr[start] < arr[end]) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println("Max area: " + maxArea);
    }
}

package main.resources.dsa.day29;

//Question: Given prices, find maximum profit by buying before selling once.
//        Pattern: Running minimum + max difference
//Thought process: Track minimum price seen so far. Profit if sold today = price - min. Update max profit. This is not Kadane; it is max difference with order constraint.
//        Complexity: TC = O(n), SC = O(1)
//Java Solution:
// Question: Best time to buy and sell stock - maximum profit.
public class Main {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        if (prices == null || prices.length == 0) {
            System.out.println("Array is null or empty");
            return;
        }
        int min = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int currentProfit = prices[i] - min;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        System.out.println("Maximum profit: " + maxProfit);
    }
}

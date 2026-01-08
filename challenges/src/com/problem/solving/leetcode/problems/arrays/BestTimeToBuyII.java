/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 *
 * However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.
 *
 * Find and return the maximum profit you can achieve.
 */
package com.problem.solving.leetcode.problems.arrays;


public class BestTimeToBuyII {

    public int maxProfit_II(int[] prices) {
        int maxprofit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }

        return maxprofit;
    }

    public int maxProfit(int[] prices) {
        int i         = 0;
        int valley    = prices[0];
        int peak      = prices[0];
        int maxprofit = 0;

        while (i < prices.length - 1) {

            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }

            valley = prices[i];

            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }

            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    void main() {
        int profit = 0;
        int[] prices = {1,2,3,4,5};

        BestTimeToBuyII bestTimeToBuyII = new BestTimeToBuyII();
        profit = bestTimeToBuyII.maxProfit_II(prices);
        System.out.println(profit);
    }
}

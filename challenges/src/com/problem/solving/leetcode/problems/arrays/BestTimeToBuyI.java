package com.problem.solving.leetcode.problems.arrays;

public class BestTimeToBuyI {

  public int maxProfit(int prices[]) {
    int minprice  = Integer.MAX_VALUE;
    int maxprofit = 0;

    for (int i = 0; i < prices.length; i++) {

      if (prices[i] < minprice) {
        minprice = prices[i];
      }

      else if (prices[i] - minprice > maxprofit) {
        maxprofit = prices[i] - minprice;
      }
    }

    return maxprofit;
  }

  public static void main(String[] args) {
    BestTimeToBuyI bestTimeToBuy = new BestTimeToBuyI();
    int[] prices = new int[] { 7, 1, 5, 3, 6, 4, 1, 8 };

    System.out.println(bestTimeToBuy.maxProfit(prices));
  }
}

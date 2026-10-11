/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
package com.problem.solving.leetcode.problems.dynamic.programming;

import java.util.Arrays;

public class ClimbingStairs {

    private int climb(int stair, int[] memoization) {

        if (stair == 0 || stair == 1)
            return 1;

        if (memoization[stair] != -1)
            return memoization[stair];

        return memoization[stair] = climb(stair - 1, memoization) + climb(stair - 2, memoization);
    }

    public int climbStairs(int n) {
        int[] memoization = new int[n + 1];
        Arrays.fill(memoization, -1);

        return climb(n, memoization);
    }

    public static void main(String args[]) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println("Required Steps Are: " + climbingStairs.climbStairs(3));
    }

}

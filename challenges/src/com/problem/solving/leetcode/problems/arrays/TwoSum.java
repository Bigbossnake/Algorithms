/**
 * Given an array of integers nums and an integer target, return indices of
 * the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you
 * may not use the same element twice.
 *
 * You can return the answer in any order.
 */
package com.problem.solving.leetcode.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> possibleNumbers = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            possibleNumbers.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int residue = target - nums[j];

            if (possibleNumbers.containsKey(residue) && possibleNumbers.get(residue) != j) {
                result[0] = j;
                result[1] = possibleNumbers.get(residue);

                break;
            }

        }

        return result;
    }

}

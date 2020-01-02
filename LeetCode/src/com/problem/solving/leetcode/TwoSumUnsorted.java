package com.problem.solving.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSumUnsorted {

    public int[] twoSum(int[] nums, int target) {

        int[] resultIndexes = new int[2];
        Map<Integer, Integer> residues = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            residues.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {

            int residue = target - nums[j];

            if (residues.containsKey(residue) && residues.get(residue) != j) {

                resultIndexes[0] = j;
                resultIndexes[1] = residues.get(residue);

                break;
            }

        }

        return resultIndexes;
    }
}

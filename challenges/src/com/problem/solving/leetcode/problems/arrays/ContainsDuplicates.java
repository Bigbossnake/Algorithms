/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */
package com.problem.solving.leetcode.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicates {

    public boolean containsDuplicate(int[] nums) {
        boolean containsDuplicates   = false;
        Map<Integer, Boolean> values = new HashMap<>();

        if (nums == null || nums.length == 0) {
            return containsDuplicates;
        }

        for (int i = 0; i < nums.length; i++) {

            if (values.containsKey(nums[i])) {
                containsDuplicates = true;
                break;
            }

            else {
               values.put(nums[i], true);
            }

        }

        return containsDuplicates;
    }

    public static void main(String[] args) {

    }
}

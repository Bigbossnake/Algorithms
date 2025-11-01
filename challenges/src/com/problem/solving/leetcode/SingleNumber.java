/**
 * Given a non-empty array of integers nums, every element appears twice except for one.
 * Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and
 * use only constant extra space.
 */
package com.problem.solving.leetcode;

import java.util.Arrays;

public class SingleNumber {

    public int singleNumber_II(int[] nums) {
        int singleNumber  = 0;

        for (int i : nums) {
            singleNumber = singleNumber ^ i;
        }
        return singleNumber;
    }

    public int singleNumber(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int index   = 0;
        Arrays.sort(nums);

        do {
            if (index + 1 < nums.length && nums[index] != nums[index + 1]) {
                return nums[index];
            }

            index+=2;
        } while(index < nums.length);

        return nums[index - 2];
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] input = new int[]{4,1,2,1,2};

        System.out.println(singleNumber.singleNumber_II(input));
    }

}

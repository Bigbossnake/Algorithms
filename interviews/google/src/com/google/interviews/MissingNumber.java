package com.google.interviews;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumberOptimized(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1)/2;
        int actualSum   = Arrays.stream(nums).sum();

        return expectedSum - actualSum;
    }

    public int missingNumber(int[] nums) {

        int missingNumber = -1;
        int maxNumber = nums.length;
        Arrays.sort(nums);

        int nextNumber = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != nextNumber) {
                missingNumber = nextNumber;
                break;
            }

            nextNumber++;
        }

        if (missingNumber < 0) {

            missingNumber = maxNumber;

            if (nums.length == 1) {
                missingNumber = nums[0] - 1 >= 0 ? nums[0] - 1 : nums[0] + 1;
            }
        }

        return missingNumber;
    }

    public static void main(String args[]) {

        int[] input = {3, 0, 1};
        MissingNumber findMissing = new MissingNumber();
        int missingNumber = findMissing.missingNumber(input);

        System.out.println(missingNumber);
    }
}

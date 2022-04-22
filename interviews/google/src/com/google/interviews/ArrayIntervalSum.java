package com.google.interviews;

public class ArrayIntervalSum {

    public int arrayIntervalSum(int[] nums, int from, int to) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            nums[i] = sum;
        }

        if (from == 1) {
            return nums[to - 1];
        }

        return nums[to - 1] - nums[from - 2];
    }

    public static void main(String args[]) {

        int[] nums = {10, 20, 50, 30, 40, 75, 5, 110, 1, 34, 46};

        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }

        ArrayIntervalSum sumatory = new ArrayIntervalSum();
        int result = sumatory.arrayIntervalSum(nums, 8, 9);

        System.out.println("\n" + result);

        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

}

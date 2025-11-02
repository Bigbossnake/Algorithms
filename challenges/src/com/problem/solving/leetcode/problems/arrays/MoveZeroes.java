package com.problem.solving.leetcode.problems.arrays;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes_II(int[] nums) {

        int index             = 0;
        int availablePosition = 0;

        if (nums.length == 0) {
            return;
        }

        while (index < nums.length) {

            if (nums[index] != 0) {
                int temp  = nums[availablePosition];

                nums[availablePosition] = nums[index];
                nums[index] = temp;
                availablePosition++;
            }

            index++;
        }

    }

    public void moveZeroes(int[] nums) {

        int index             = 0;
        int availablePosition = 0;

        if (nums.length == 0) {
            return;
        }

        while (index < nums.length) {

            if (nums[index] != 0) {
                nums[availablePosition] = nums[index];
                availablePosition++;
            }

            index++;
        }

        while (availablePosition < nums.length) {
            nums[availablePosition] = 0;
            availablePosition++;
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] input = new int[]{0,1,0,3,12};

        moveZeroes.moveZeroes_II(input);
        System.out.println(Arrays.toString(input));
    }

}

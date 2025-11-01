package com.problem.solving.leetcode.problems;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        if (height.length == 0) {
            return 0;
        }

        if (height.length == 1) {
            return height[0];
        }

        int maxArea    = 0;
        int leftIndex  = 0;
        int rightIndex = height.length - 1;

        while (leftIndex < rightIndex) {

            maxArea = Math.max((rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]), maxArea);

            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else if (height[leftIndex] >= height[rightIndex]) {
                rightIndex--;
            }
        }

        return maxArea;
    }

    public static void main(String args[]) {
        //int[] height = {1,8,6,2,5,4,8,3,7};
        //int[] height = {3,9,3,4,7,2,12,6};
        //int[] height = {2,1};
        //int[] height = {1,2,1};
        int[] height = {4,3,2,1,4};

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(height));

    }
}

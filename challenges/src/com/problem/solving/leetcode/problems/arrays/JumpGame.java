package com.problem.solving.leetcode.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {

  Map<Integer, Boolean> visited = new HashMap<>();

  public boolean determineJump(int[] nums, int index, int target) {

    if (index >= target) {
      return true;
    }

    if (!visited.containsKey(index)) {
      visited.put(index, true);
      int numberOfJumps = nums[index];

      while (numberOfJumps > 0) {

        if (determineJump(nums, index + numberOfJumps, target)) {
          return true;
        }

        numberOfJumps--;
      }
    }

    return false;
  }

  public boolean canJump(int[] nums) {
    return determineJump(nums, 0, nums.length - 1);
  }

  public boolean canJumpOptimized(int[] nums) {

    int lastPosition = nums.length - 1;

    for (int i = nums.length - 1; i >= 0; i--) {

      if (i + nums[i] >= lastPosition) {
        lastPosition = i;
      }

    }

    return lastPosition == 0;
  }

  public static void main(String args[]) {
    int nums[] = {3, 2, 1, 0, 4};

    JumpGame jumpGame = new JumpGame();
    System.out.println(jumpGame.canJumpOptimized(nums));
  }
}

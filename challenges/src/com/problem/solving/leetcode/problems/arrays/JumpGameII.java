package com.problem.solving.leetcode.problems.arrays;

public class JumpGameII {

  public int jump(int[] nums) {

    int numberOfJumps = 0;
    int numsSize      = nums.length - 1;
    int currentEnd    = 0;
    int currentFar    = 0;

    for (int i = 0; i < numsSize; i++) {
      currentFar = Math.max(currentFar, i + nums[i]);

      if (i == currentEnd) {
        numberOfJumps++;
        currentEnd = currentFar;
      }
    }

    return numberOfJumps;
  }

  public static void main(String args[]) {
    int nums[] = {6,2,6,1,7,9,3,5,3,7,2,8,9,4,7,7,2,2,8,4,6,6,1,3};

    JumpGameII jumpGameII = new JumpGameII();
    System.out.println(jumpGameII.jump(nums));
  }
}

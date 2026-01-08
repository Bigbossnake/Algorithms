package com.problem.solving.leetcode.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MajorityElement {

  public int majorityElement_I(int[] nums) {

    if (nums.length < 2) {
      return nums[0];
    }

    Arrays.sort(nums);

    int currenValue = nums[0];
    int currentRepetions = 0;
    int majorityElementValue = currenValue;
    int majorityElementTimes = currentRepetions;

    for (int i = 0; i < nums.length; i++) {

      if (nums[i] == currenValue) {
        currentRepetions++;
      } else {

        if (currentRepetions > majorityElementTimes) {
          majorityElementTimes = currentRepetions;
          majorityElementValue = currenValue;
        }

        currenValue = nums[i];
        currentRepetions = 1;
      }
    }

    if (currentRepetions > majorityElementTimes) {
      majorityElementTimes = currentRepetions;
      majorityElementValue = currenValue;
    }

    return majorityElementValue;
  }

  public int majorityElement_II(int[] nums) {

    if (nums.length < 2) {
      return nums[0];
    }

    Map<Integer, Integer> repetions = new HashMap<>();

    for (int num : nums) {

      if (!repetions.containsKey(num)) {
        repetions.put(num, 1);
        continue;
      }

      int numberOfRepetitions = repetions.get(num) + 1;
      repetions.put(num, numberOfRepetitions);
    }

    int element      = 0;
    int mostRepeated = 0;

    for (Map.Entry<Integer, Integer> entry : repetions.entrySet()) {

      if (entry.getValue() > mostRepeated) {
        element = entry.getKey();
        mostRepeated = entry.getValue();
      }
    }

    return element;
  }

  public static void main(String[] args) {
    MajorityElement majorityElement = new MajorityElement();

    int[] nums = new int[] {3, 2, 3};
    System.out.println(majorityElement.majorityElement_II(nums));
  }
}

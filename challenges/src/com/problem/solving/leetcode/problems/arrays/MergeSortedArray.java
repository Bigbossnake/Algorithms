package com.problem.solving.leetcode.problems.arrays;

import java.util.Arrays;

public class MergeSortedArray {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int index1 = m - 1;
    int index2 = n - 1;
    int length = m + n - 1;

    for (int index = length; index >= 0; index--) {

      if (index2 < 0) {
        break;
      }

      if (index1 >= 0 && nums1[index1] > nums2[index2]) {
        nums1[index] = nums1[index1];
        index1--;
        continue;
      }

      nums1[index] = nums2[index2];
      index2--;
    }
  }

  public void merge_api(int[] nums1, int m, int[] nums2, int n) {

    if (n > 0) {

      int index1 = (nums1.length - n) - 1;
      int index2 = 0;

      while (index1 < nums1.length) {
        nums1[index1] = nums2[index2];
        index1++;
        index2++;
      }

      Arrays.sort(nums1);
    }
  }

  public static void main(String[] args) {
    int n = 3;
    int nums1[] = {1, 2, 3, 0, 0, 0};
    int nums2[] = {2, 5, 6};

    MergeSortedArray solution = new MergeSortedArray();

    solution.merge(nums1, n, nums2, n);
  }
}

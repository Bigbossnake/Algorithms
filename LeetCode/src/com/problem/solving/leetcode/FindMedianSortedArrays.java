package com.problem.solving.leetcode;

import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int sample[]  = new int[nums1.length + nums2.length];
        double median = 0.0;

        System.arraycopy(nums1, 0, sample, 0, nums1.length);
        System.arraycopy(nums2, 0, sample, nums1.length, nums2.length);
        Arrays.sort(sample);

        if (sample.length == 1) {
            return sample[0];
        }

        if (sample.length % 2 != 0) {
            return sample[sample.length/2];
        }

        int medianIndex = sample.length/2;
        return (double) (sample[medianIndex - 1] + sample[medianIndex]) / 2;
    }

    public static void main(String args[]) {
        FindMedianSortedArrays exercise = new FindMedianSortedArrays();

        int[] nums1 = {1, 3};
        int[] nums2 = {2, 5};

        System.out.println("Array: " + exercise.findMedianSortedArrays(nums1, nums2));

    }
}

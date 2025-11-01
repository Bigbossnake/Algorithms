/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 *
 * Each element in the result must appear as many times as it shows in both arrays
 * and you may return the result in any order.
 */
package com.problem.solving.leetcode;

import java.util.*;

public class IntersectionOfArrays {

    public int[] intersect_II(int[] nums1, int[] nums2) {

        List<Integer> intersection      = new ArrayList<>();
        Map<Integer, Integer> numValues = new HashMap<>();

        for (int num : nums1) {
            numValues.put(num, numValues.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (numValues.containsKey(num) && numValues.get(num) > 0) {
                intersection.add(num);

                numValues.put(num, numValues.get(num) - 1);
            }
        }

        return intersection.parallelStream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> intersection = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0;
        int index2 = 0;

        do {

            // Number1 is Minor Than Number 02
            if (index1 < nums1.length && index2 < nums2.length && nums1[index1] < nums2[index2]) {
                index1++;

                continue;
            }

            // Number1 is Greater Than Number 02
            if (index1 < nums1.length && index2 < nums2.length && nums1[index1] > nums2[index2]) {
                index2++;

                continue;
            }

            // Numbers Are equal
            if (index1 < nums1.length && index2 < nums2.length && nums1[index1] == nums2[index2]) {
                intersection.add(nums1[index1]);

                index1++;
                index2++;

                continue;
            }

            index1++;

        } while (index1 < nums1.length);


        return intersection.parallelStream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        IntersectionOfArrays intersection = new IntersectionOfArrays();
        int nums1[] = {4,9,5};
        int nums2[] = {9,4,9,8,4};

        System.out.println(Arrays.toString(intersection.intersect_II(nums1, nums2)));
    }
}

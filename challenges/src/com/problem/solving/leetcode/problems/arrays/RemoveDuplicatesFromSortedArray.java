/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 *
 * Consider the number of unique elements in nums to be k After removing duplicates, return the number of unique elements k.
 *
 * The first k elements of nums should contain the unique numbers in sorted order.
 * The remaining elements beyond index k - 1 can be ignored.
 */
package com.problem.solving.leetcode.problems.arrays;
import java.util.*;

public class RemoveDuplicatesFromSortedArray {

    // Optimal Solution
    public int removeDuplicates_II(int[] nums) {
        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            // We skip to next index if we see a duplicate element
            if (nums[i - 1] != nums[i]) {
                /* Storing the unique element at insertIndex index and incrementing
                   the insertIndex by 1 */
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums.length;
        }

        int index  = 0;
        int length = 0;
        Map<Integer, Boolean> duplicateElements = new HashMap<Integer, Boolean>();
        Queue<Integer> nextAvailablePosition    = new LinkedList<Integer>();
        nextAvailablePosition.add(0);

        do {
            int currentElement = nums[index];

            if (!duplicateElements.containsKey(currentElement)) {
                duplicateElements.put(currentElement, true);
                length++;

                if (!nextAvailablePosition.isEmpty()) {
                    int position = nextAvailablePosition.poll();
                    nums[position] =  nums[index];
                }

                continue;
            }

            if (duplicateElements.containsKey(currentElement)) {
                nextAvailablePosition.add(index + 1);
            }

            index++;

        } while(index < nums.length);

        return length;
    }

    public static void main(String[] args) {

        int[] sortedArray = new int[]{
                0,0,1,1,1,2,2,3,3,4
        };

        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int realLength = removeDuplicatesFromSortedArray.removeDuplicates(sortedArray);

        System.out.println(realLength);
        System.out.println(Arrays.toString(sortedArray));
    }

}

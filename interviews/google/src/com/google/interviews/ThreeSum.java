package com.google.interviews;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ThreeSum {

    Map<Integer, Boolean> positionWasUsed = new HashMap<>();

    public void findTriplets(int[] nums, int result, List<List<Integer>> possibleTriplets, LinkedList<Integer> triplet) {

        if (triplet.size() == 3) {
            List<Integer> tripletValues = new LinkedList<>();

            int a = nums[triplet.get(0)];
            int b = nums[triplet.get(1)];
            int c = nums[triplet.get(2)];

            tripletValues.add(a);
            tripletValues.add(b);
            tripletValues.add(c);

            boolean isValidCombination = true;

            if (positionWasUsed.containsKey(a)
                    && positionWasUsed.containsKey(b)
                    && positionWasUsed.containsKey(c)) {
                isValidCombination = false;
            }


            if (!possibleTriplets.contains(tripletValues) &&
                    a + b + c == result && isValidCombination) {

                possibleTriplets.add(tripletValues);

                positionWasUsed.put(a, true);
                positionWasUsed.put(b, true);
                positionWasUsed.put(c, true);
            }

        }

        for (int i = 0; i < nums.length; i++) {

            if (triplet.contains(i)) {
                continue;
            }

            triplet.add(i);
            findTriplets(nums, result, possibleTriplets, triplet);
            triplet.removeLast();
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {
        int result = 0;
        LinkedList<Integer> triplet = new LinkedList<>();
        List<List<Integer>> possibleTiplets = new LinkedList<>();

        if (!Optional.ofNullable(nums).isPresent()) {
            return possibleTiplets;
        }

        if (nums.length == 0) {
            return possibleTiplets;
        }

        findTriplets(nums, result, possibleTiplets, triplet);

        return possibleTiplets;
    }

    public static void main (String args[]) {
        ThreeSum sum = new ThreeSum();
        int nums[] = {-1,0,1,2,-1,-4,-2,-3,3,0,4};

        System.out.println(sum.threeSum(nums));
    }

}

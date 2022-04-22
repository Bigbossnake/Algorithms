package company.google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PermutationOptimized {
    int initialPermutationIndex = 0;
    boolean isRepeated = false;
    boolean stopPermutation = false;
    boolean permutationIndexWasFound = false;
    List<Integer> initialPermutation = new LinkedList<>();
    List<List<Integer>> permutations = new LinkedList<>();

    void permute(int[] nums, int permutationLength, LinkedList<Integer> currentPermutation) {

        if (currentPermutation.size() == permutationLength) {

            List<Integer> permutationValues = new LinkedList<>();

            for (int j = 0; j<permutationLength; j++) {
                permutationValues.add(nums[currentPermutation.get(j)]);
            }

            if (!permutations.contains(permutationValues)) {
                permutations.add(permutationValues);
                isRepeated = false;
            } else {
                isRepeated = true;
            }

            if (!permutationIndexWasFound) {

                int numberOfMatches = 0;
                for (int i = 0; i < currentPermutation.size(); i++) {
                    if (initialPermutation.get(i) == nums[currentPermutation.get(i)]) {
                        numberOfMatches++;
                    }
                }

                if (numberOfMatches == initialPermutation.size()) {
                    permutationIndexWasFound = true;
                    initialPermutationIndex = permutations.size();
                }

            } else if (permutationIndexWasFound && !stopPermutation && !isRepeated) {
                stopPermutation = true;
            }

            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (stopPermutation) {
                return;
            }

            if (currentPermutation.contains(i)) {
                continue;
            }

            currentPermutation.add(i);
            permute(nums, permutationLength, currentPermutation);
            currentPermutation.removeLast();
        }
    }

    public void nextPermutation(int[] nums) {

        if (!Optional.ofNullable(nums).isPresent() || nums.length <= 1) {
            return;
        }

        Arrays.stream(nums).forEach(initialPermutation::add);
        Arrays.sort(nums);

        List<Integer> nextPermutation = new LinkedList<>();
        LinkedList<Integer> currentPermutation = new LinkedList<>();
        permute(nums, nums.length, currentPermutation);

        nextPermutation = permutations.get(permutations.size() -1);

        if (nextPermutation.equals(initialPermutation)) {
            nextPermutation = permutations.get(0);
        }

        System.out.println(initialPermutation);
        System.out.println(nextPermutation);
        System.out.println(permutations.size());
        System.out.println(permutations);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nextPermutation.get(i);
        }
    }

    public static void main (String args[]) {
        int nums[] = {5, 4, 3, 2, 1};
        //int nums[] = {1,5,1};


        PermutationOptimized permutation = new PermutationOptimized();
        permutation.nextPermutation(nums);
    }

}

package company.google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Permutation {
    int initialPermutationIndex = 0;
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
                    initialPermutationIndex = permutations.size() - 1;
                    //System.out.println("FOUND: " + permutations.size());
                }

            }

            return;
        }

        for (int i = 0; i < nums.length; i++) {

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

        if (initialPermutationIndex + 1 < permutations.size()) {
            nextPermutation = permutations.get(initialPermutationIndex + 1);
        } else {
            nextPermutation = permutations.get(0);
        }

        System.out.println(initialPermutation);
        System.out.println(initialPermutationIndex);
        System.out.println(nextPermutation);
        System.out.println(permutations);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nextPermutation.get(i);
        }
    }

    public static void main (String args[]) {
        int nums[] = {1,2,3,4,5};

        Permutation permutation = new Permutation();
        permutation.nextPermutation(nums);
    }

}

package company.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];

        List<Integer> positions;
        Map<Integer, List<Integer>> numbersTable = new HashMap<>();

        if (!Optional.ofNullable(nums).isPresent() || nums.length < 1) {
            return indexes;
        }

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];

            if (!numbersTable.containsKey(number)) {
                positions = new ArrayList<>();
            }

            else {
                positions = numbersTable.get(number);
            }

            positions.add(i);
            numbersTable.put(number, positions);
        }

        for (int j = 0; j < nums.length; j++) {
            int currentNumber = nums[j];
            int complement    = target - currentNumber;

            // Two Sum It's Possible
            if (numbersTable.containsKey(complement)) {

                // validate Exception
                if (complement == currentNumber && numbersTable.get(complement).size() < 2) {
                    continue;
                }

                if (complement == currentNumber && numbersTable.get(complement).size() == 2) {
                    indexes[0] = numbersTable.get(complement).get(0);
                    indexes[1] = numbersTable.get(complement).get(1);
                    break;
                }

                indexes[0] = j;
                indexes[1] = numbersTable.get(complement).get(0);

                break;
            }
        }

        return indexes;
    }

    public static void main(String args[]) {
        int[] nums = {3,2,4};
        TwoSum sum = new TwoSum();

        System.out.println(sum.twoSum(nums, 6));
    }

}

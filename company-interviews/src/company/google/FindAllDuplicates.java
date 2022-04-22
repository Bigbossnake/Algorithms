package company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                duplicateNumbers.add(nums[i]);
            }
        }

        return duplicateNumbers;
    }

}

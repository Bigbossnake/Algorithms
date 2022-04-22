package company.google;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveElement {

    public int removeElementOptimized(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
    public int removeElement(int[] nums, int val) {

        if (nums.length == 0) {
            return 0;
        }

        int arrayIndex = 0;
        int size = nums.length;
        Queue<Integer> targetIndexes = new LinkedList<>();

        do {

            if (nums[arrayIndex] == val) {
                targetIndexes.add(arrayIndex);
                size--;
            }

            if (!targetIndexes.isEmpty() && nums[arrayIndex] != val) {

                int repeatIndex   = targetIndexes.poll();
                nums[repeatIndex] = nums[arrayIndex];
                targetIndexes.add(arrayIndex);
            }

            arrayIndex++;

        } while (arrayIndex < nums.length);

        return size;
    }

    public static void main(String args[]) {

        int[] input = {3,2,2,3};
        RemoveElement remover = new RemoveElement();

        int solutionLength = remover.removeElement(input, 3);

        for (int i = 0; i < solutionLength; i++){
            System.out.print(input[i] + ", ");
        }
    }

}

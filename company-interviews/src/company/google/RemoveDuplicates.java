package company.google;


public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String args[]) {

        int[] input = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicates remover = new RemoveDuplicates();

        int solutionLength = remover.removeDuplicates(input);

        for (int i = 0; i < solutionLength; i++){
            System.out.print(input[i] + " ");
        }
    }

}

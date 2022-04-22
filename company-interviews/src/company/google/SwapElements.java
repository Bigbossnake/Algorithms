package company.google;

public class SwapElements {

    public void swapElementsWithoutExtraMemory(int x, int y) {
        System.out.println("\nX = " + x + " Y = " + y);

        x = x + y; // 5 + 4 = 9
        y = x - y; // 9 - 4 = 5
        x = x - y; // 9 - 5 = 4

        System.out.println("X = " + x + " Y = " + y);

    }

    public void swapElementsWithoutExtraMemory(int nums[], int x, int y, int from, int to) {
        x = x + y;
        y = x - y;
        x = x - y;

        nums[from] = x;
        nums[to]   = y;
    }

    public void swapElementsWithoutExtraMemory(int nums[], int x, int y) {
        nums[x] = nums[x] + nums[y];
        nums[y] = nums[x] - nums[y];
        nums[x] = nums[x] - nums[y];
    }

    public static void main(String args[]) {

        int x = 40;
        int y = 30;
        int[] nums = {10, 20, 50, 30, 40, 75, 5, 110, 1, 34, 46};

        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }

        SwapElements swapper = new SwapElements();
        swapper.swapElementsWithoutExtraMemory(x, y);
        // swapper.swapElementsWithoutExtraMemory(nums, nums[4 - 1], nums[5 - 1], 4 - 1, 5 - 1);
        swapper.swapElementsWithoutExtraMemory(nums, 4 - 1, 5 - 1);

        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }

    }

}

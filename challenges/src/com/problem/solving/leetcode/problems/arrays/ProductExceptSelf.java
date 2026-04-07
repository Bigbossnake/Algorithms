/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product
 * of all the elements of nums except nums[i].
 *
 * <p>The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * <p>You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [1,2,3,4] Output: [24,12,8,6]
 *
 * <p>Example 2:
 *
 * <p>Input: nums = [-1,1,0,-3,3] Output: [0,0,9,0,0]
 */
package com.problem.solving.leetcode.problems.arrays;

public class ProductExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    int inputSize      = nums.length;
    int[] leftProduct  = new int[inputSize];
    int[] rigthProduct = new int[inputSize];

    leftProduct[0] = 1;
    for (int i = 1; i < inputSize; i++) {
      leftProduct[i] = nums[i - 1] * leftProduct[i - 1];
    }

    rigthProduct[inputSize - 1] = 1;
    for (int i = inputSize - 2; i >= 0; i--) {
      rigthProduct[i] = nums[i + 1] * rigthProduct[i + 1];
    }

    for (int i = 0; i < inputSize; i++) {
      nums[i] = leftProduct[i] * rigthProduct[i];
    }

    return nums;
  }

  public int[] productExceptSelfOptimized(int[] nums) {
    int inputSize = nums.length;
    int[] result  = new int[inputSize];

    result[0]  = 1;
    for (int i = 1; i < inputSize; i++) {
      result[i] = nums[i - 1] * result[i - 1];
    }

    int rightProduct = 1;
    for (int i = inputSize - 1; i >= 0; i--) {
      result[i]    = result[i] * rightProduct;
      rightProduct = rightProduct * nums[i];
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};

    ProductExceptSelf productExceptSelf = new ProductExceptSelf();

    int result[] = productExceptSelf.productExceptSelf(nums);

    for (int number : result) {
      System.out.print(number + " , ");
    }
  }
}

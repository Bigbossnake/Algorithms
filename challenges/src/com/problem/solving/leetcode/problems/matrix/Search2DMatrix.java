/**
 * You are given an m x n integer matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 */
package com.problem.solving.leetcode.problems.matrix;

public class Search2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {

    int matrixSize = matrix.length;

    if (matrixSize == 0) {
      return false;
    }

    int index;
    int matrixValue;
    int rowLength = matrix[0].length;
    int left = 0;
    int right = matrixSize * rowLength - 1;

    while (left <= right) {
      index = (left + right) / 2;
      matrixValue = matrix[index / rowLength][index % rowLength];

      if (target == matrixValue)
        return true;

      else {

        if (target < matrixValue) {
          right = index - 1;
        }

        else {
          left = index + 1;
        }

      }
    }

    return false;
  }

  public static void main(String args[]) {
    /*int[][] matrix = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 60}
    };*/

    /*int[][] matrix = {
        {1}
    };*/

    int[][] matrix = {
        {1, 3}
    };

    Search2DMatrix matrixSearcher = new Search2DMatrix();
    System.out.println(matrixSearcher.searchMatrix(matrix, 3));
  }
}
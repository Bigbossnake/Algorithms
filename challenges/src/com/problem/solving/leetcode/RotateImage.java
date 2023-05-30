/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees
 * (clockwise).
 *
 * <p>You have to rotate the image in-place, which means you have to modify the input 2D matrix
 * directly.
 *
 * <p>DO NOT allocate another 2D matrix and do the rotation.
 */
package com.problem.solving.leetcode;

public class RotateImage {

  public void rotate(int[][] matrix) {
    transpose(matrix);
    reflect(matrix);
  }

  public void transpose(int[][] image) {
    int n = image.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int tmp     = image[j][i];
        image[j][i] = image[i][j];
        image[i][j] = tmp;

        printMatrix(image);
      }
    }
  }

  public void reflect(int[][] image) {
    int n = image.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int tmp = image[i][j];
        image[i][j] = image[i][n - j - 1];
        image[i][n - j - 1] = tmp;
      }
    }
  }

  public void printMatrix(int[][] image) {
    for (int x = 0; x < image.length; x++) {
      for (int y = 0; y < image[x].length; y++) {
        System.out.print(image[x][y] + ", ");

        if ((y + 1) % image[x].length == 0 && y > 0) {
          System.out.println();
        }
      }
    }

    System.out.println();
  }

  public static void main(String args[]) {

    /*
    int image[][] = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    */

    /*
    int image[][] = {
        {5, 1, 9, 11},
        {2, 4, 8, 10},
        {13, 3, 6, 7},
        {15, 14, 12, 16}
    };*/

    int image[][] = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11,12,13,14,15},
        {16,17,18,19,20},
        {21,22,23,24,25}
    };

    RotateImage imageRotator = new RotateImage();
    imageRotator.printMatrix(image);
    imageRotator.rotate(image);
    imageRotator.printMatrix(image);
  }
}

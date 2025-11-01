/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees
 * (clockwise).
 *
 * <p>You have to rotate the image in-place, which means you have to modify the input 2D matrix
 * directly.
 *
 * <p>DO NOT allocate another 2D matrix and do the rotation.
 */

package com.problem.solving.leetcode.problems.matrix;

public class RotateImageOptimized {

  public void rotate(int image [][]) {
    transpose(image);
    reflect(image);
  }

  public void transpose(int image [][]) {

    for (int x = 0; x < image.length; x++) {
      for (int y = x + 1; y < image[x].length; y++) {
        int tempValue = image[y][x];
        image[y][x] = image[x][y];
        image[x][y] = tempValue;
      }
    }

  }

  public void reflect(int image [][]) {

    int length = image.length - 1;

    for (int x = 0; x < image.length; x++) {
      for (int y = 0; y < image[x].length/2; y++) {
        int tempValue = image[x][length - y ];
        image[x][length - y] = image[x][y];
        image[x][y] = tempValue;
      }
    }
  }

  public void printMatrix(int[][] image) {

    for (int x = 0; x < image.length; x++) {
      for (int y = 0; y < image[x].length; y++) {

        if (image[x][y] < 10) {
          System.out.print("0" + image[x][y] + ", ");
        }

        else {
          System.out.print(image[x][y] + ", ");
        }

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

    RotateImageOptimized imageRotator = new RotateImageOptimized();
    imageRotator.printMatrix(image);
    imageRotator.rotate(image);
    imageRotator.printMatrix(image);
  }

}

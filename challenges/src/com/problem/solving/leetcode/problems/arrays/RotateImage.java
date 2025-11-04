/**
 * You are given an n x n 2D matrix representing an image,
 *  rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to
 * modify the input 2D matrix directly.
 *
 * DO NOT allocate another 2D matrix and do the rotation.
 */
package com.problem.solving.leetcode.problems.arrays;

public class RotateImage {

    public void rotate(int[][] image) {
        transpose(image);
        reflect(image);
    }

    public void transpose(int[][] image) {
        int imageSize = image.length;

        for (int x = 0; x < imageSize; x++) {
            for (int y = x + 1; y < imageSize; y++) {
                 int temp    = image[y][x];
                 image[y][x] = image[x][y];
                 image[x][y] = temp;
            }
        }
    }

    public void reflect(int[][] image) {
        int imageSize = image.length;
        int imageLimit = imageSize/2;

        for (int x = 0; x < imageSize; x++) {
            for (int y = 0; y < imageLimit; y++) {
                int temp       = image[x][y];
                int rightIndex = imageSize-y-1;

                image[x][y] = image[x][rightIndex];
                image[x][rightIndex] = temp;
            }
        }
    }

    public void printMatrix(int[][] image) {
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[x].length; y++) {

                int value = image[x][y];

                if (value < 10) {
                    System.out.print("0" + image[x][y] + ", ");
                }

                else if (value >= 10) {
                    System.out.print(image[x][y] + ", ");
                }

                if ((y + 1) % image[x].length == 0 && y > 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int image[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        RotateImage rotateImage = new RotateImage();

        rotateImage.printMatrix(image);
        rotateImage.rotate(image);
        rotateImage.printMatrix(image);
    }
}

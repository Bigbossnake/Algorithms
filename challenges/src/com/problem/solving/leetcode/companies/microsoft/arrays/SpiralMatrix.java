/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
package com.problem.solving.leetcode.companies.microsoft.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    int rows       = matrix.length;
    int columns    = matrix[0].length;
    int matrixArea = rows * columns;
    int visited    = 0;

    Direction direction  = Direction.EAST;
    List<Integer> result = new ArrayList<>();

    int initialX  = 0;
    int initialY  = 0;
    int minRow    = 0;
    int minColumn = 0;

    while (visited < matrixArea) {

      if (direction == Direction.EAST) {
        while (initialY < columns) {
          result.add(matrix[initialX][initialY]);
          initialY++;
          visited++;
        }

        initialX++;
        initialY--;
        columns--;
        minRow++;
        direction = Direction.SOUTH;
      }

      else if (direction == Direction.SOUTH) {
        while (initialX < rows) {
          result.add(matrix[initialX][initialY]);
          initialX++;
          visited++;
        }

        initialX--;
        initialY--;
        rows--;
        direction = Direction.WEST;
      }

      else if (direction == Direction.WEST) {
        while (initialY >= minColumn) {
          result.add(matrix[initialX][initialY]);
          initialY--;
          visited++;
        }

        initialX--;
        initialY++;
        minColumn++;
        direction = Direction.NORTH;
      }

      else if (direction == Direction.NORTH) {
        while (initialX >= minRow) {
          result.add(matrix[initialX][initialY]);
          initialX--;
          visited++;
        }

        initialX++;
        initialY++;
        direction = Direction.EAST;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    SpiralMatrix spiral = new SpiralMatrix();

    int[][] input = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12}
    };

    System.out.println(spiral.spiralOrder(input));
  }
}

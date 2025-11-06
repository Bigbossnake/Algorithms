package com.problem.solving.leetcode.companies.microsoft.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMatrixZeroes {

  class Coordinate {
    int x;
    int y;
  }

  public void setZeroes(int[][] matrix, Coordinate coordinate) {
    int initialX = coordinate.x - 1;
    int initialY = coordinate.y;

    // Set Zeros To NORTH
    while (initialX >= 0) {
      matrix[initialX][initialY] = 0;
      initialX--;
    }

    // Set Zeros To SOUTH
    initialX = coordinate.x + 1;
    initialY = coordinate.y;

    while (initialX < matrix.length) {
      matrix[initialX][initialY] = 0;
      initialX++;
    }

    // Set Zeros To EAST
    initialX = coordinate.x;
    initialY = coordinate.y - 1;

    while (initialY >= 0) {
      matrix[initialX][initialY] = 0;
      initialY--;
    }

    // Set Zeros To WEST
    initialX = coordinate.x;
    initialY = coordinate.y + 1;

    while (initialY < matrix[0].length) {
      matrix[initialX][initialY] = 0;
      initialY++;
    }
  }

  public void setZeroes(int[][] matrix) {
    int rows    = matrix.length;
    int columns = matrix[0].length;
    List<Coordinate> coordinates = new ArrayList<Coordinate>();

    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < columns; y++) {
        if (matrix[x][y] == 0) {
          Coordinate currentCoordinate = new Coordinate();
          currentCoordinate.x = x;
          currentCoordinate.y = y;

          coordinates.add(currentCoordinate);
        }
      }
    }

    for (Coordinate coordinate : coordinates) {
      setZeroes(matrix, coordinate);
    }
  }

  public void setZeroesOptimized(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;

    Set<Integer> rows = new HashSet<Integer>();
    Set<Integer> cols = new HashSet<Integer>();

    // Essentially, we mark the rows and columns that are to be made zero
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          cols.add(j);
        }
      }
    }

    // Iterate over the array once again and using the rows and cols sets, update the elements.
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (rows.contains(i) || cols.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  public void printMatrix(int[][] matrix) {
    for (int x = 0; x < matrix.length; x++) {
      for (int y = 0; y < matrix[x].length; y++) {

        int value = matrix[x][y];

        if (value < 10) {
          System.out.print("0" + matrix[x][y] + ", ");
        } else if (value >= 10) {
          System.out.print(matrix[x][y] + ", ");
        }

        if ((y + 1) % matrix[x].length == 0 && y > 0) {
          System.out.println();
        }
      }
    }
    System.out.println();
  }

  public static void main(String agrs[]) {
    SetMatrixZeroes initializeMatrix = new SetMatrixZeroes();
    int[][] input = {
      {1, 1, 1},
      {1, 0, 1},
      {1, 1, 1}
    };

    initializeMatrix.printMatrix(input);
    initializeMatrix.setZeroes(input);
    initializeMatrix.printMatrix(input);
  }
}

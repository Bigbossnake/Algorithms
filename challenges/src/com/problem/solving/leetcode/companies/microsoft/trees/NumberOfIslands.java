package com.problem.solving.leetcode.companies.microsoft.trees;

public class NumberOfIslands {

  public void markIsland(char[][] map, int row, int column) {
    int numerOfRows    = map.length;
    int numerOfColumns = map[0].length;

    if (row < 0 || row >= numerOfRows || column < 0 || column >= numerOfColumns || map[row][column] == '0') {
      return;
    }

    map[row][column] = '0';

    // MARK ISLAND IN ALL DIRECTIONS
    // NORTH, SOUTH, EAST, WEST
    markIsland(map, row + 1, column);
    markIsland(map, row - 1, column);
    markIsland(map, row, column + 1);
    markIsland(map, row, column - 1);
  }

  public int numIslands(char[][] grid) {
    int numberOfIslands = 0;

    if (grid == null || grid.length == 0) {
      return numberOfIslands;
    }

    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {
        if (grid[row][column] == '1') {
          numberOfIslands++;
          markIsland(grid, row, column);
        }
      }
    }

    return numberOfIslands;
  }
}

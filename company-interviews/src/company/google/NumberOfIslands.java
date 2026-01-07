package company.google;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {
  public int numIslands(char[][] grid) {

    if (grid == null || grid.length == 0) {
      return 0;
    }

    int numberOfRows    = grid.length;
    int numberOfColumns = grid[0].length;
    int numberOfIslands = 0;

    for (int r = 0; r < numberOfRows; ++r) {
      for (int c = 0; c < numberOfColumns; ++c) {

        if (grid[r][c] == '1') {
          ++numberOfIslands;
          grid[r][c] = '0'; // mark as visited
          Queue<Integer> neighbors = new LinkedList<>();
          neighbors.add(r * numberOfColumns + c);

          // DFS To Mark The Island As Visited
          while (!neighbors.isEmpty()) {
            int id  = neighbors.remove();
            int row = id / numberOfColumns;
            int col = id % numberOfColumns;

            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
              neighbors.add((row - 1) * numberOfColumns + col);
              grid[row - 1][col] = '0';
            }

            if (row + 1 < numberOfRows && grid[row + 1][col] == '1') {
              neighbors.add((row + 1) * numberOfColumns + col);
              grid[row + 1][col] = '0';
            }

            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
              neighbors.add(row * numberOfColumns + col - 1);
              grid[row][col - 1] = '0';
            }

            if (col + 1 < numberOfColumns && grid[row][col + 1] == '1') {
              neighbors.add(row * numberOfColumns + col + 1);
              grid[row][col + 1] = '0';
            }
          }
        }
      }
    }

    return numberOfIslands;
  }
}

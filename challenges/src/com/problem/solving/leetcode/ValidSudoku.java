/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need
 * to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain
 * the digits 1-9 without repetition.
 *
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
package com.problem.solving.leetcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class ValidSudoku {

  public boolean isValidSudoku(char[][] board) {
    Map<Character, List<String>> boardCoordinates = new Hashtable<>();
    String coordinateInfo;
    List<String> coordinateList;
    int quadrant = 0;

    for (int x = 0; x < 9; x ++) {

      if (quadrant > 0) {
        quadrant = x % 3 == 0 ? quadrant: quadrant - 3;
      }

      for (int y = 0; y < 9; y++) {
        char boardValue = board[x][y];
        coordinateInfo = String.valueOf(x) + y + quadrant;

        if (boardValue != '.' && !boardCoordinates.containsKey(boardValue)) {
          coordinateList = new ArrayList<>();
          coordinateList.add(coordinateInfo);

          boardCoordinates.put(boardValue, coordinateList);
        }

        else if (boardValue != '.') {
          coordinateList = boardCoordinates.get(boardValue);

          for (int i = 0; i < coordinateList.size(); i++) {
            int xInfo        = Integer.parseInt(String.valueOf(coordinateList.get(i).charAt(0)));
            int yInfo        = Integer.parseInt(String.valueOf(coordinateList.get(i).charAt(1)));
            int quadrantInfo = Integer.parseInt(String.valueOf(coordinateList.get(i).charAt(2)));


            if (xInfo == x && yInfo != y ||
                xInfo != x && yInfo == y ||
                quadrantInfo == quadrant) {
              return false;
            }

          }

          coordinateList.add(coordinateInfo);
          boardCoordinates.put(boardValue, coordinateList);
        }

        if ((y + 1) % 3 == 0) {
          quadrant++;
        }
      }
    }

    return true;
  }

  public static void main(String args[]) {
    char board[][] = {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
    };

    ValidSudoku sodokuValidator = new ValidSudoku();
    System.out.println(sodokuValidator.isValidSudoku(board));
  }

}

package com.problem.solving.leetcode.problems.arrays;

public class WordSearch {

  private static final char VISITED = '#';

  private char[][] board;
  private int NUMBER_OF_ROWS;
  private int NUMBER_OF_COLUMNS;

  protected boolean backtrack(int row, int column, String word, int wordSize, int index) {

    if (index >= wordSize) {
      return true;
    }

    if (row < 0 || row == NUMBER_OF_ROWS || column < 0 || column == NUMBER_OF_COLUMNS || board[row][column] != word.charAt(index)) {
      return false;
    }

    boolean result = false;
    board[row][column] = VISITED;

    result = this.backtrack(row + 1, column, word, wordSize, index + 1);
    if (result) {
      return true;
    }

    result = this.backtrack(row - 1, column, word, wordSize, index + 1);
    if (result) {
      return true;
    }

    result = this.backtrack(row, column + 1, word, wordSize, index + 1);
    if (result) {
      return true;
    }

    result = this.backtrack(row, column - 1, word, wordSize, index + 1);
    if (result) {
      return true;
    }

    board[row][column] = word.charAt(index);

    return result;
  }

  public boolean exist(char[][] board, String word) {
    this.board             = board;
    this.NUMBER_OF_ROWS    = board.length;
    this.NUMBER_OF_COLUMNS = board[0].length;

    int index = 0;
    int wordSize = word.length();
    for (int row = 0; row < NUMBER_OF_ROWS; ++row) {
      for (int col = 0; col < NUMBER_OF_COLUMNS; ++col) {
        char currentChar = board[row][col];
        if (currentChar == word.charAt(index)) {
          if (this.backtrack(row, col, word, wordSize, index)) {
            return true;
          }
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    String word = "ABCCED";
    char[][] board = {
      {'A', 'B', 'C', 'E'},
      {'S', 'F', 'C', 'S'},
      {'A', 'D', 'E', 'E'}
    };

    WordSearch wordSearch = new WordSearch();
    System.out.println(wordSearch.exist(board, word));
  }
}

package company.google;

import java.util.ArrayList;
import java.util.List;

public class AndroidUnlockPatterns {

    private static int LOCK_SCREEN_SIZE = 3;
    private static int VISITED = -1;

    private static List<String> possibleLockPatterns = new ArrayList<>();

    private void generatePatternCombinations(int[][] lockScreen, int min, int max,
            String lockPattern, int row, int col) {

        if (min != max && lockPattern.length() == min) {
            possibleLockPatterns.add(lockPattern);
        }

        if (lockPattern.length() == max) {
            possibleLockPatterns.add(lockPattern);
            return;
        }

        int lockScreenNumber = lockScreen[row][col];

        if (lockScreenNumber != -1) {
            lockPattern = lockPattern + lockScreenNumber;
        }

        // LEFT
        if (col - 1 >= 0) {
            lockScreenNumber = lockScreen[row][col - 1];
            lockScreen[row][col - 1] = VISITED;

            if (lockScreenNumber != VISITED) {
                generatePatternCombinations(lockScreen, min, max, lockPattern + lockScreenNumber, row, col - 1);
            }

        }

        // RIGHT
        if (col + 1 < LOCK_SCREEN_SIZE) {
            lockScreenNumber = lockScreen[row][col + 1];
            lockScreen[row][col + 1] = VISITED;

            if (lockScreenNumber != VISITED) {
                generatePatternCombinations(lockScreen, min, max, lockPattern + lockScreenNumber, row, col + 1);
            }
        }

        // UP
        if (row - 1 >= 0) {
            lockScreenNumber = lockScreen[row - 1][col];
            lockScreen[row - 1][col] = VISITED;

            if (lockScreenNumber != VISITED) {
                generatePatternCombinations(lockScreen, min, max, lockPattern + lockScreenNumber, row - 1, col);
            }
        }

        // DOWN
        if (row + 1 < LOCK_SCREEN_SIZE) {
            lockScreenNumber = lockScreen[row + 1][col];
            lockScreen[row + 1][col] = VISITED;

            if (lockScreenNumber != VISITED) {
                generatePatternCombinations(lockScreen, min, max, lockPattern + lockScreenNumber, row + 1, col);
            }

        }

        // UPPER RIGHT
        if (row + 1 < LOCK_SCREEN_SIZE && col + 1 < LOCK_SCREEN_SIZE) {
            lockScreenNumber = lockScreen[row + 1][col + 1];
            lockScreen[row + 1][col + 1] = VISITED;

            if (lockScreenNumber != VISITED) {
                generatePatternCombinations(lockScreen, min, max, lockPattern + lockScreenNumber, row + 1, col + 1);
            }
        }

        // DOWN UPPER RIGHT
        if (row - 1 >= 0 && col + 1 < LOCK_SCREEN_SIZE) {
            lockScreenNumber = lockScreen[row - 1][col + 1];
            lockScreen[row - 1][col + 1] = VISITED;

            if (lockScreenNumber != VISITED) {
                generatePatternCombinations(lockScreen, min, max, lockPattern + lockScreenNumber, row - 1, col + 1);
            }
        }

        // UPPER LEFT
        if (row - 1 >= 0 && col - 1 >= 0) {
            lockScreenNumber = lockScreen[row - 1][col - 1];
            lockScreen[row - 1][col - 1] = VISITED;

            if (lockScreenNumber != VISITED) {
                generatePatternCombinations(lockScreen, min, max, lockPattern + lockScreenNumber, row - 1, col - 1);
            }
        }

        // DOWN UPPER RIGHT
        if (row + 1 < LOCK_SCREEN_SIZE && col - 1 >= 0) {
            lockScreenNumber = lockScreen[row + 1][col - 1];
            lockScreen[row + 1][col - 1] = VISITED;

            if (lockScreenNumber != VISITED) {
                generatePatternCombinations(lockScreen, min, max, lockPattern + lockScreenNumber, row + 1, col - 1);
            }
        }

    }

    public int numberOfPatterns(int min, int max) {

        int[][] lockScreen = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };


        for (int row = 0; row < lockScreen.length; row++) {
            for (int col = 0; col < lockScreen[row].length; col++) {
                String lockPattern = "";
                generatePatternCombinations(lockScreen, min, max, lockPattern, row, col);

                lockScreen = new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9},
                };
            }
        }

        if (min == 1) {
            return possibleLockPatterns.size() + 9;
        }

        return possibleLockPatterns.size();
    }

    public static void main(String args[]) {
        int min = 1;
        int max = 2;

        AndroidUnlockPatterns patterns = new AndroidUnlockPatterns();

        System.out.println("Number Of Patterns : " +  patterns.numberOfPatterns(min, max));
        System.out.println("Patterns Length    : " +  possibleLockPatterns.size());
        System.out.println("Possible Patterns  : " + possibleLockPatterns);
    }

}

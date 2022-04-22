package company.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LongestSubstring2CharMax {

    public int lengthOfLongestSubstringTwoDistinct(String input) {
        StringBuilder longestSubString = new StringBuilder();
        Map<Character, Boolean> pairOfChars = new HashMap<>();

        if (!Optional.ofNullable(input).isPresent() || input.isEmpty()) {
            return 0;
        }

        if (input.length() < 2) {
            return 1;
        }

        if (input.length() == 2) {
            return 2;
        }

        int longestPossible        = 0;
        int inputIndex             = 0;
        int numberOfDifferentChars = 0;
        int firstDifferentChar     = 0;
        char previousChar          = input.charAt(inputIndex);

        pairOfChars.put(previousChar, true);
        while (inputIndex < input.length()) {
            char currentChar = input.charAt(inputIndex);
            longestSubString.append(currentChar);

            if (previousChar != currentChar && !pairOfChars.containsKey(currentChar)) {
                numberOfDifferentChars++;
                pairOfChars.put(currentChar, true);

                if (numberOfDifferentChars == 1) {
                    firstDifferentChar = inputIndex;
                }

                else if (numberOfDifferentChars >= 2) {

                    longestSubString.deleteCharAt(longestSubString.length() - 1);

                    if (longestPossible == 0) {
                        longestPossible = longestSubString.length();
                    }
                    else if (longestPossible > 0 && longestSubString.length() > longestPossible) {
                        longestPossible = longestSubString.length();
                    }

                    numberOfDifferentChars = 0;
                    pairOfChars            = new HashMap<>();
                    longestSubString       = new StringBuilder();
                    inputIndex             = firstDifferentChar;
                    previousChar           = input.charAt(inputIndex);

                    pairOfChars.put(previousChar, true);

                    continue;
                }

            }

            inputIndex++;
            previousChar = currentChar;
        }

        if (longestPossible == 0) {
            longestPossible = longestSubString.length();
        } else if (numberOfDifferentChars == 1 && longestSubString.length() > longestPossible) {
            longestPossible = longestSubString.length();
        }

        return longestPossible;
    }

    public static void main (String args[]) {
        LongestSubstring2CharMax longestPossible = new LongestSubstring2CharMax();

        //String input = "abc"; // Number Of DiffChars = 2
        //String input = "aac"; // Number Of DiffChars = 3
        String input = "eceba"; // Number Of DiffChars = 3
        //String input = "aba"; // Number Of DiffChars = 3

        //String input = "bacc"; // Number Of DiffChars = 3
        //String input = "abaccc"; // Number Of DiffChars = 4

        System.out.println(longestPossible.lengthOfLongestSubstringTwoDistinct(input));
    }
}

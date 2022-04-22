package com.problem.solving.leetcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LetterCombinationsOfAphoneNumber {

    static Map<Character, String> phoneNumberKeyBoard;

    static {
        phoneNumberKeyBoard = new Hashtable<>();
        phoneNumberKeyBoard.put('2', "a,b,c,");
        phoneNumberKeyBoard.put('3', "d,e,f,");
        phoneNumberKeyBoard.put('4', "g,h,i,");
        phoneNumberKeyBoard.put('5', "j,k,l,");
        phoneNumberKeyBoard.put('6', "m,n,o,");
        phoneNumberKeyBoard.put('7', "p,q,r,s,");
        phoneNumberKeyBoard.put('8', "t,u,v,");
        phoneNumberKeyBoard.put('9', "w,x,y,z,");
    }

    private void permuteLetters(String[] possibleLetters, int combinationSize, StringBuilder combination,
                                List<String> combinations) {

        if (combination.length() == combinationSize) {
            combinations.add(combination.toString());
        }

        for (int i = 0; i < possibleLetters.length; i++) {
            String currentLetter = possibleLetters[i];

            if (combination.toString().contains(currentLetter)) {
                continue;
            }

            combination.append(possibleLetters[i]);
            permuteLetters(possibleLetters, combinationSize, combination, combinations);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> letterCombinations = new ArrayList<>();

        if (Objects.isNull(digits) || digits.isEmpty()) {
            return letterCombinations;
        }

        Map<Character, Boolean> markedDigit = new Hashtable<>();
        StringBuilder possibleLetters = new StringBuilder();

        for (int i = 0; i < digits.length(); i++) {
            char currentDigit = digits.charAt(i);

            if (!markedDigit.containsKey(currentDigit)) {
                possibleLetters.append(phoneNumberKeyBoard.get(currentDigit));
                markedDigit.put(currentDigit, true);
            }

        }

        permuteLetters(possibleLetters.toString().split(","), digits.length(), new StringBuilder(), letterCombinations);

        return letterCombinations;
    }

    public static void main(String args[]) {

        LetterCombinationsOfAphoneNumber combinator = new LetterCombinationsOfAphoneNumber();
        List<String> letterCombinations = combinator.letterCombinations( "23");
        letterCombinations.forEach(combination -> System.out.print(combination + " ,"));
        System.out.println("\nHasCode: " + combinator.hashCode() % 10);

    }
}

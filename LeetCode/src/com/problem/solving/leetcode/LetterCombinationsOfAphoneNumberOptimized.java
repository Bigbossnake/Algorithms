package com.problem.solving.leetcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LetterCombinationsOfAphoneNumberOptimized {

    static Map<Character, String> phoneNumberKeyBoard;

    static {
        phoneNumberKeyBoard = new Hashtable<>();
        phoneNumberKeyBoard.put('2',"abc");
        phoneNumberKeyBoard.put('3',"def");
        phoneNumberKeyBoard.put('4',"ghi");
        phoneNumberKeyBoard.put('5',"jkl");
        phoneNumberKeyBoard.put('6',"mno");
        phoneNumberKeyBoard.put('7',"pqrs");
        phoneNumberKeyBoard.put('8',"tuv");
        phoneNumberKeyBoard.put('9',"wxyz");
    }

    public void permuteLetters(String digits, Map<Character,String> digitLetters,
                               StringBuilder combination,
                               List<String> letterCombinations, int index){

        if(index == digits.length()){
            letterCombinations.add(String.valueOf(combination));
            return;
        }

        String str = digitLetters.get(digits.charAt(index));

        for(int j = 0; j < str.length(); j++) {
            combination.append(str.charAt(j));
            permuteLetters(digits, digitLetters, combination, letterCombinations,index + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> letterCombinations = new ArrayList<>();

        if(Objects.isNull(digits) || digits.length() == 0) {
            return letterCombinations;
        }

        StringBuilder combination = new StringBuilder();
        permuteLetters(digits, phoneNumberKeyBoard, combination, letterCombinations,0);

        return letterCombinations;
    }
}

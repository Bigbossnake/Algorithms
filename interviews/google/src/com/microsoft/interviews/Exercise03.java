package com.microsoft.interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Exercise03 {

    public int solution(String input) {
       int result = 0;

       Map<Character, Integer> charRepetions = new HashMap<>();
       Map<Integer, Boolean> markedRepetition = new HashMap<>();
       AtomicInteger deleteChars = new AtomicInteger();

        for (int i = 0; i < input.length(); i++) {

           Character currentChar = input.charAt(i);

           if (!charRepetions.containsKey(currentChar)) {
               charRepetions.put(currentChar, 1);
               continue;
           }

           int numberOfRepetions = charRepetions.get(currentChar) + 1;
           charRepetions.put(currentChar, numberOfRepetions);
       }

        charRepetions.forEach((key, value) -> {
            if (!markedRepetition.containsKey(value)) {
                markedRepetition.put(value, true);
            }

            else {
                deleteChars.getAndAdd(value);
            }
        } );

       return deleteChars.get();
    }

    public static void main(String args[]) {
        Exercise03 exercise03 = new Exercise03();

        System.out.println(exercise03.solution("ccaaffddecee"));
    }
}

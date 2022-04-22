package com.microsoft.interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise01 {

    public int solution(int[] input) {
        AtomicInteger answer = new AtomicInteger();

        Map<Integer, Integer> repeatedTimes = new HashMap<>();

        for (int i = 0; i < input.length; i++) {

            int currentElement = input[i];

            if (!repeatedTimes.containsKey(currentElement)) {
                repeatedTimes.put(currentElement, 1);
                continue;
            }

            int numberOfRepetions = repeatedTimes.get(currentElement) + 1;
            repeatedTimes.put(currentElement, numberOfRepetions);
        }

        repeatedTimes.forEach((key, value) -> {

            if (key.intValue() == value.intValue() && key.intValue() > answer.get()) {
                answer.set( key.intValue() );
            }

        } );

        return answer.get();
    }

    public static void main(String args[]) {
        Exercise01 exercise = new Exercise01();

        int[] input = {
                3, 8, 2, 3, 3, 2
        };

        System.out.println(exercise.solution(input));
    }
}

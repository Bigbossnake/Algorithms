package company.amazon;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Exercise01 {

    public static int getMaxFreqDeviation(String input) {

        if (input == null) {
            return 0;
        }

        if (input.isEmpty()) {
            return 0;
        }

        int maxDeviation   = 0;
        int maxRepetitions = 0;
        int minRepetitions = 0;

        Map<Character, Integer> numberOfLetters = new Hashtable<>();

        for(int i = 0; i < input.length(); i++) {

            for(int j = i; j < input.length(); j++) {

                char currentChar = input.charAt(j);

                if (!numberOfLetters.containsKey(currentChar)) {
                    numberOfLetters.put(currentChar, 1);
                } else {
                    int numberOfRepetions = numberOfLetters.get(currentChar) + 1;
                    numberOfLetters.put(currentChar, numberOfRepetions);

                    if (numberOfRepetions > maxRepetitions) {
                        maxRepetitions = numberOfRepetions;
                    }

                    List<Integer> repetitionValues = new ArrayList<>(numberOfLetters.values());

                    minRepetitions = repetitionValues.stream()
                            .mapToInt(v -> v)
                            .min()
                            .orElseThrow(NoSuchElementException::new);
                }

                int currentDeviation = maxRepetitions - minRepetitions;

                if (currentDeviation > maxDeviation) {
                    maxDeviation = currentDeviation;
                }

            }

            maxRepetitions  = 0;
            minRepetitions  = 0;
            numberOfLetters = new Hashtable<>();
        }


        return maxDeviation;
    }

    public static void main (String args[]) {
        String input = "abdbcdacbcadbbc";
        System.out.println( Exercise01.getMaxFreqDeviation(input));
    }
}

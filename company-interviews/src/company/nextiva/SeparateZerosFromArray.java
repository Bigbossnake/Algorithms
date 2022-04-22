package company.nextiva;

import java.util.Arrays;

public class SeparateZerosFromArray {

    // Order 2n
    public static int[] separateZeros(int input[]) {

        int tempIndex = 0;
        int[] temp    = new int[input.length];

        for (int value : input) {

            if (value == 0) {
                temp[tempIndex] = value;
                tempIndex++;
            }
        }

        for (int value : input) {

            if (value != 0) {
                temp[tempIndex] = value;
                tempIndex++;
            }

        }

        return temp;
    }

    public static void main(String args[]) {

        int[] input = {7, 9, 0, 5, 0, 3, 1, 0};

        int[] result = SeparateZerosFromArray.separateZeros(input);

        Arrays.stream(result).forEach(val -> System.out.print(val + " "));
    }

}

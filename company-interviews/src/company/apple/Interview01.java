package company.apple;

import java.util.Arrays;

public class Interview01 {

    public void mergedArrays(int array1[], int array2[]) {
        final int firstElement = 0;

        for (int i = 0; i < array1.length; i++) {

            if (array1[i] > array2[firstElement]) {
                int temp = array1[i];
                array1[i] = array2[firstElement];
                array2[firstElement] = temp;

                Arrays.sort(array2);
            }
        }

    }

    public static void main(String args[]) {
        int array1[] = {1, 3, 5, 10};
        int array2[] = {2, 4, 6, 7, 8, 12};

        Interview01 sortedArray = new Interview01();
        sortedArray.mergedArrays(array1, array2);

        Arrays.stream(array1).forEach(element -> {
            System.out.print(element + " ");
        });

        Arrays.stream(array2).forEach(element -> {
            System.out.print(element + " ");
        });

    }
}

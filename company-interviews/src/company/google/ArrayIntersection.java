package company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIntersection {

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int arrayIndex1 = 0;
        int arrayIndex2 = 0;

        int[] array1 = nums1;
        int[] array2 = nums2;

        List<Integer> intersectionList = new ArrayList<Integer>();

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        if (nums1.length < nums2.length) {
            array1 = nums2;
            array2 = nums1;
        }

        do {

            if (array1[arrayIndex1] > array2[arrayIndex2]) {
                arrayIndex2++;

                if (arrayIndex2 == array2.length) {
                    break;
                }

                continue;
            }

            if (array1[arrayIndex1] < array2[arrayIndex2]) {
                arrayIndex1++;

                if (arrayIndex1 == array1.length) {
                    break;
                }

                continue;
            }

            if (array1[arrayIndex1] == array2[arrayIndex2]) {
                intersectionList.add(array1[arrayIndex1]);

                arrayIndex1++;
                arrayIndex2++;

                if (arrayIndex1 == array1.length || arrayIndex2 == array2.length) {
                    break;
                }
            }


        } while(arrayIndex2 < array2.length);

        return intersectionList.stream().mapToInt(i->i).toArray();
    }

}

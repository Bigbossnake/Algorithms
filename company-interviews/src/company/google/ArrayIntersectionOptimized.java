package company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class ArrayIntersectionOptimized {

    public int[] intersect(int[] nums1, int[] nums2) {

        int[] array1 = nums1;
        int[] array2 = nums2;

        Map<Integer, Integer> array2Map = new Hashtable<Integer, Integer>();
        List<Integer> intersectionList = new ArrayList<Integer>();

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        if (nums1.length < nums2.length) {
            array1 = nums2;
            array2 = nums1;
        }

        Arrays.stream(array2).forEach(element -> {

            if (!array2Map.containsKey(element)) {
                array2Map.put(element, 1);
            }

            else {
                array2Map.put(element, array2Map.get(element) + 1);
            }

        });

        Arrays.stream(array1).forEach(element -> {
            if (array2Map.containsKey(element)) {
                if (array2Map.get(element) > 0) {
                    intersectionList.add(element);
                    array2Map.put(element, array2Map.get(element) - 1);
                }

            }
        });

        return intersectionList.stream().mapToInt(i->i).toArray();
    }

}

package com.problem.solving.leetcode.utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SorMapByKeyAndValue {
  private static final Map<String, Integer> postDetails = new HashMap<>();

  public static void main(String[] args) {
    postDetails.put("1", 10);
    postDetails.put("20", 20);
    postDetails.put("10", 5);
    postDetails.put("30", 5);

    Comparator<Map.Entry<String, Integer>> byValueThenByKey = Map.Entry.<String, Integer>comparingByValue()
            .thenComparing(Map.Entry.comparingByKey());

    Map<String, Integer> sorted = postDetails.entrySet()
            .stream()
            .sorted(byValueThenByKey.reversed())
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (a, b) -> a,
                    LinkedHashMap::new
            ));
    
    for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}

package com.problem.solving.leetcode.problems.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

  private final Map<Integer, Integer> setMap;
  private final List<Integer> setValues;

  public RandomizedSet() {
    setMap    = new HashMap<>();
    setValues = new ArrayList<>();
  }

  public boolean insert(int val) {

    if (setMap.containsKey(val)) {
      return false;
    }

    setMap.put(val, setValues.size());
    setValues.add(setValues.size(), val);

    return true;
  }

  public boolean remove(int val) {

    if (!setMap.containsKey(val)) {
      return false;
    }

    int lastIndex    = setValues.size() - 1;
    int lastElement  = setValues.get(lastIndex);
    int deletedIndex = setMap.get(val);

    setValues.set(deletedIndex, lastElement);
    setMap.put(lastElement, deletedIndex);

    setValues.remove(lastIndex);
    setMap.remove(val);

    return true;
  }

  public int getRandom() {
    Random rand = new Random();
    int index   = rand.nextInt(setValues.size());

    return setValues.get(index);
  }
}

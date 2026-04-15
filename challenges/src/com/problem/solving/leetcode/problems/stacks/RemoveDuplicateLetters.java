/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You
 * must make sure your result is the smallest in lexicographical order among all possible results.
 */
package com.problem.solving.leetcode.problems.stacks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class RemoveDuplicateLetters {

  public String removeDuplicateLetters(String s) {

    Stack<Character> stack  = new Stack<>();
    HashSet<Character> seen = new HashSet<>();

    HashMap<Character, Integer> lastOccurrence = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      lastOccurrence.put(s.charAt(i), i);
    }

    for (int i = 0; i < s.length(); i++) {

      char currentChar = s.charAt(i);

      if (!seen.contains(currentChar)) {

        while (!stack.isEmpty()
            && currentChar < stack.peek()
            && lastOccurrence.get(stack.peek()) > i) {
          seen.remove(stack.pop());
        }

        seen.add(currentChar);
        stack.push(currentChar);
      }
    }

    StringBuilder sb = new StringBuilder(stack.size());

    for (Character letter : stack) {
      sb.append(letter);
    }

    return sb.toString();
  }
}

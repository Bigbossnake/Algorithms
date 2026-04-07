/**
 * We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid
 * in the array represent their relative position in space.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction
 * (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet:
 * - The smaller one will explode.
 * - If both are the same size, both will explode.
 *
 * Two asteroids moving in the same direction will never meet.
 */
package com.problem.solving.leetcode.problems.arrays;

import java.util.Stack;

public class AsteroidCollision {

  public int[] asteroidCollision(int[] asteroids) {

    Stack<Integer> asteroidStack = new Stack<Integer>();

    for (int asteroid : asteroids) {
      boolean addAsteroid = true;

      while (!asteroidStack.isEmpty() && (asteroidStack.peek() > 0 && asteroid < 0)) {

        // Left Asteroid Exploded
        if (Math.abs(asteroidStack.peek()) < Math.abs(asteroid)) {
          asteroidStack.pop();
          continue;
        }

        // Both Asteroids Exploded
        else if (Math.abs(asteroidStack.peek()) == Math.abs(asteroid)) {
          asteroidStack.pop();
        }

        // Right Asteroid Destroyed
        // No Need to add into the Stack
        addAsteroid = false;
        break;
      }

      if (addAsteroid) {
        asteroidStack.push(asteroid);
      }
    }

    // Add the asteroids from the stack to the vector in the reverse order.
    int[] remainingAsteroids = new int[asteroidStack.size()];

    for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
      remainingAsteroids[i] = asteroidStack.pop();
    }

    return remainingAsteroids;
  }

  public static void main(String args[]) {
    int[] asteroids = {10, 2, -5};

    AsteroidCollision asteroidCollision = new AsteroidCollision();
    int collisionResult[] = asteroidCollision.asteroidCollision(asteroids);

    for (int asteroid : collisionResult) {
      System.out.print(asteroid + " ");
    }
  }
}

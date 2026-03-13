package company.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.IntUnaryOperator;

public class MS365_Q2 {

  public static List<Integer> getClusterSizes(List<Integer> serverProperties) {
    int serverCount = serverProperties.size();
    List<Integer> result = new ArrayList<>(serverCount);
    if (serverCount == 0) return result;

    // 1) Find maximum value to size helper arrays
    int maxPropertyValue = 0;
    for (int propertyValue : serverProperties) {
      if (propertyValue > maxPropertyValue) maxPropertyValue = propertyValue;
    }

    // 2) Build SPF (smallest prime factor) array for fast factorization
    int[] smallestPrimeFactor = new int[maxPropertyValue + 1];
    for (int candidate = 2; candidate * candidate <= maxPropertyValue; candidate++) {
      if (smallestPrimeFactor[candidate] != 0) continue; // already marked -> not prime
      smallestPrimeFactor[candidate] = candidate;         // candidate is prime
      for (int multiple = candidate * candidate; multiple <= maxPropertyValue; multiple += candidate) {
        if (smallestPrimeFactor[multiple] == 0) smallestPrimeFactor[multiple] = candidate;
      }
    }
    for (int value = 2; value <= maxPropertyValue; value++) {
      if (smallestPrimeFactor[value] == 0) smallestPrimeFactor[value] = value; // remaining primes
    }

    // 3) DSU (Union-Find) arrays
    int[] parent = new int[serverCount];
    int[] componentSizeByRoot = new int[serverCount];
    for (int index = 0; index < serverCount; index++) {
      parent[index] = index;
      componentSizeByRoot[index] = 1;
    }

    // "find" with path compression, kept inside this single function
    IntUnaryOperator findRoot = new IntUnaryOperator() {
      @Override
      public int applyAsInt(int nodeIndex) {
        int rootIndex = nodeIndex;
        while (rootIndex != parent[rootIndex]) {
          rootIndex = parent[rootIndex];
        }
        while (nodeIndex != rootIndex) {
          int nextIndex = parent[nodeIndex];
          parent[nodeIndex] = rootIndex;
          nodeIndex = nextIndex;
        }
        return rootIndex;
      }
    };

    // "union" by size, kept inside this single function
    BiConsumer<Integer, Integer> union = (leftIndex, rightIndex) -> {
      int leftRoot = findRoot.applyAsInt(leftIndex);
      int rightRoot = findRoot.applyAsInt(rightIndex);
      if (leftRoot == rightRoot) return;

      if (componentSizeByRoot[leftRoot] < componentSizeByRoot[rightRoot]) {
        int temp = leftRoot;
        leftRoot = rightRoot;
        rightRoot = temp;
      }

      parent[rightRoot] = leftRoot;
      componentSizeByRoot[leftRoot] += componentSizeByRoot[rightRoot];
    };

    // 4) Map prime -> first server index that contains that prime factor
    int[] firstServerWithPrime = new int[maxPropertyValue + 1];
    Arrays.fill(firstServerWithPrime, -1);

    // 5) Factor each server property; union servers that share a prime factor
    for (int serverIndex = 0; serverIndex < serverCount; serverIndex++) {
      int propertyValue = serverProperties.get(serverIndex);
      if (propertyValue <= 1) continue; // gcd > 1 is impossible

      int remainingValue = propertyValue;
      while (remainingValue > 1) {
        int primeFactor = smallestPrimeFactor[remainingValue];

        int firstIndex = firstServerWithPrime[primeFactor];
        if (firstIndex == -1) {
          firstServerWithPrime[primeFactor] = serverIndex;
        } else {
          union.accept(serverIndex, firstIndex);
        }

        // remove all copies of this prime so we only process it once per number
        while (remainingValue % primeFactor == 0) {
          remainingValue /= primeFactor;
        }
      }
    }

    // 6) Count final component sizes by root
    int[] finalComponentSizes = new int[serverCount];
    for (int serverIndex = 0; serverIndex < serverCount; serverIndex++) {
      int rootIndex = findRoot.applyAsInt(serverIndex);
      finalComponentSizes[rootIndex]++;
    }

    // 7) Build answer for each server
    for (int serverIndex = 0; serverIndex < serverCount; serverIndex++) {
      int rootIndex = findRoot.applyAsInt(serverIndex);
      result.add(finalComponentSizes[rootIndex]);
    }

    return result;
  }

  public static void main(String[] args) {
    MS365_Q2 question = new MS365_Q2();
  }
}

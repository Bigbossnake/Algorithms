/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
package com.problem.solving.leetcode.problems.desing;

import java.util.HashMap;
import java.util.Map;

class CacheElement implements Comparable<CacheElement> {
    int id;
    int age;
    int value;

    @Override
    public int compareTo(CacheElement cacheElement) {
        return Integer.compare(age, cacheElement.age);
    }
}

public class LRUCache {

    private static final int NOT_FOUND   = -1;

    private final Map<Integer, CacheElement> cache;
    private final int capacity;

    private int cacheAge;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache         = new HashMap<>();
        cacheAge      = 0;
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return NOT_FOUND;
        }

        CacheElement cacheElement = cache.get(key);
        cacheAge++;
        cacheElement.age = cacheAge;
        cache.replace(key, cacheElement);

        return cacheElement.value;
    }

    public void put(int key, int value) {

        CacheElement cacheElement;
        cacheAge++;

        // Need to Update Value
        if (cache.containsKey(key)) {
            cacheElement = cache.get(key);
            cacheElement.value = value;
            cacheElement.age   = cacheAge;

            cache.replace(key, cacheElement);
            return;
        }

        // Need to Add New Value
        if (!cache.containsKey(key) && cache.size() < capacity) {
            cacheElement = new CacheElement();
            cacheElement.id    = key;
            cacheElement.value = value;
            cacheElement.age   = cacheAge;

            cache.put(key, cacheElement);
            return;
        }

        // Cache is full and needs to Evict the LRU element in the MAP
        int lruKey = findLruCacheElement();
        cache.remove(lruKey);

        cacheElement = new CacheElement();
        cacheElement.id    = key;
        cacheElement.value = value;
        cacheElement.age   = cacheAge;

        cache.put(key, cacheElement);
    }

    public void printAllCache() {

        cache.forEach((key, cacheElement) -> {
            System.out.println("Key: " + key + " Value: " + cacheElement.value + " Age: " + cacheElement.age);
        });
    }

    private int findLruCacheElement() {
        return cache.values().stream()
                .sorted()
                .toList()
                .get(0)
                .id;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);

        System.out.println(lRUCache.get(2));
        lRUCache.put(2, 6);

        System.out.println(lRUCache.get(1));
        lRUCache.put(1, 5);
        lRUCache.put(1, 2);

        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
    }
}
package com.company;

import java.util.Arrays;

/**
 * @author anniexp
 * @param <T> - generic type
 */
public class LruCache<T> {
    private final static int CACHE_DEFAULT_SIZE = 3;

    private final T[] elements;
    private final int[] ageBits;
    private int pos = 0;
    private int count = 0;
    private final int size;
    boolean isFilled = false;

    /**
     * constructor
     *
     * @param size - size of cache
     */
    public LruCache(int size) {
        this.size = size;
        this.elements = (T[]) new Object[size];
        this.ageBits = new int[size];
    }

    /**
     * constructor with no params, calls constructor with default cache size
     */
    public LruCache() {
        this(CACHE_DEFAULT_SIZE);
    }

    /**
     * @param element - element to be added as the most recent,
     *                - if cache isn't full - it's added at the end
     *                - if cache is full and element is not present, then it replaces the least recent element
     */
    public void addElement(T element) {
        if (isFilled || pos >= size) {
            isFilled = true;
            pos = isContained(element);
            if (pos == -1) {
                pos = findOldestElPos();
            }
        }
        elements[pos] = element;
        ageBits[pos] = count;
        pos++;
        count++;
    }

    /**
     * @return least recent element
     */
    public int findOldestElPos() {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < ageBits.length; i++) {
            if (ageBits[i] < min) {
                min = ageBits[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    /**
     * @param element element to be checked if its already contained in the LruCache's elements array
     * @return position of element
     */
    public int isContained(T element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && (elements[i] == element || elements[i].equals(element))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "LruCache{" +
                "elements=" + Arrays.toString(elements) +
                ", counter=" + Arrays.toString(ageBits) +
                '}';
    }
}

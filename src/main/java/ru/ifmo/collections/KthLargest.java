package ru.ifmo.collections;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    private final TreeSet<Wrapper> sortedSet;
    private final int k;

    public KthLargest(int k, int[] numbers) {
        this.k = k;
        sortedSet = new TreeSet<>();
        for (int number :
                numbers) {
            sortedSet.add(new Wrapper(number));
        }
    }

    public int add(int val) {
        sortedSet.add(new Wrapper(val));
        return sortedSet.stream()
                .skip(sortedSet.size() - k)
                .findFirst()
                .map(Wrapper::getValue)
                .orElse(-1);
    }
}
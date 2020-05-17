package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 * <p>
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 * <p>
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {
    private final TreeMap<T, Object> contents;
    private static final Object PRESENT = new Object();

    public SortedSet(Comparator<T> comparator) {
        this.contents = new TreeMap<>(comparator);
    }

    public static <T> SortedSet<T> create() {
        return new SortedSet<T>(null);
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<T>(comparator);
    }

    public Collection<T> getSorted() {
        return new ArrayList<>(contents.keySet());
    }

    public Collection<T> getReversed() {
        return new ArrayList<>(contents.descendingKeySet());
    }

    @Override
    public Iterator<T> iterator() {
        return contents.keySet().iterator();
    }

    @Override
    public int size() {
        return contents.size();
    }

    @Override
    public boolean add(T t) {
        return contents.put(t, PRESENT) == null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean result = false;
        for (T t :
                c) {
            if (add(t)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean remove(Object o) {
        return contents.remove(o) == null;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        for (Object o :
                c) {
            if (remove(o)) {
                result = true;
            }
        }
        return result;
    }
}

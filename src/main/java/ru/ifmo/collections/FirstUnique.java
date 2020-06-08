package ru.ifmo.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {

    private final Set<Integer> set;
    private final LinkedHashSet<Integer> firstUniqueElement;

    public FirstUnique(int[] numbers) {
        set = new HashSet<>();
        firstUniqueElement = new LinkedHashSet<>();
        for (int number : numbers) {
            this.add(number);
        }
    }

    public int showFirstUnique() {
        if (!firstUniqueElement.isEmpty()) {
            return (int) firstUniqueElement.iterator().next();
        }
        return -1;
    }

    public void add(int value) {
        if (!set.contains(value)) {
            firstUniqueElement.add(value);
        } else {
            firstUniqueElement.remove(value);
        }
        set.add(value);
    }
}

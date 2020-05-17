package ru.ifmo.collections;

public class Wrapper implements Comparable<Wrapper>{

    private final int value;

    public Wrapper(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Wrapper o) {
        return this.value < o.value ? -1 : 1;
    }
}

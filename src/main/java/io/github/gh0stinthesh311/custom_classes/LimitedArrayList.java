package io.github.gh0stinthesh311.custom_classes;

import io.github.gh0stinthesh311.exceptions.TableSizeException;

import java.util.ArrayList;

/*
 * NOTE: Instead of:
 *
 * public class  LimitedArrayList<T> extends ArrayList<Object>,
 * generic is used. That is because Java Language Specification (Java SE 21 edition) states:
 * The use of raw types is allowed only as a concession to compatibility of legacy code.
 * The use of raw types in code written after the introduction of
 * generics into the Java programming language is strongly discouraged.
 * It is possible that future versions of the Java programming language
 * will disallow the use of raw types.
 * */

public class LimitedArrayList<T> extends ArrayList<T> {
    /*
     * Default size of 64 elements is deliberate design choice.
     * */
    private int maxSize;
    private static final int DEFAULT_MAX_SIZE = 64;

    public LimitedArrayList() {
        this.maxSize = DEFAULT_MAX_SIZE;
    }

    public LimitedArrayList(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        this.maxSize = maxSize;
    }

    @Override
    public boolean add(T e) {
        if (this.size() < maxSize) {
            return super.add(e);
        }
        throw new TableSizeException("Exceeded max table size: " + maxSize);
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int SIZE) {
        this.maxSize = SIZE;
    }
}

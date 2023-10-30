package org.example;

/**
 * A custom iterator for iterating through an array of elements.
 *
 * @param <E> the type of elements in the array
 * */
public class Iterator<E> implements java.util.Iterator<E> {
    private int index = 0;
    private E[] array;

    /**
     * Constructs an iterator for the given array.
     *
     * @param array the array to be iterated
     */
    public Iterator(E[] array) {
        this.array = array;
    }

    /**
     * Checks if there are more elements to iterate.
     *
     * @return true if there are more elements, false otherwise
     */
    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    /**
     * Retrieves the next element in the iteration.
     *
     * @return the next element
     */
    @Override
    public E next() {
        return array[index++];
    }
}

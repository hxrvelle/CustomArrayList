package org.example;

import java.util.Comparator;
import java.util.Iterator;

/**
 * An implementation of the CustomArrayList interface using an array.
 *
 * @param <E> the type of elements in the CustomArrayList
 */
public class CustomArrayList<E> implements CustomArrayListInterface<E> {
    private E[] array;

    /**
     * Constructs an empty CustomArrayList.
     * The initial size of the CustomArrayList is set to 0.
     */
    public CustomArrayList() {
        array = (E[]) new Object[0];
    }

    /**
     * Adds an element to the end of the CustomArrayList.
     *
     * @param element the element to be added
     * @return true if the element was successfully added, false otherwise
     */
    @Override
    public boolean add(E element) {
        E[] container = array;
        array = (E[]) new Object[container.length + 1];
        System.arraycopy(container, 0, array, 0, container.length);
        array[array.length - 1] = element;
        return true;
    }

    /**
     * Adds an element at the specified index in the CustomArrayList.
     * If the index is out of bounds, an IndexOutOfBoundsException is thrown.
     *
     * @param index   the index at which the element should be added
     * @param element the element to be added
     * @return true if the element was successfully added, false otherwise
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds " + array.length);
        }
        E[] container = array;
        array = (E[]) new Object[container.length + 1];
        System.arraycopy(container, 0, array, 0, index);
        array[index] = element;
        int remain = container.length - index;
        System.arraycopy(container, index, array, index + 1, remain);
        return true;
    }

    /**
     * Retrieves the element at the specified index in the CustomArrayList.
     * If the index is out of bounds or the array is empty, an IndexOutOfBoundsException is thrown.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds or the array is empty
     */
    @Override
    public E get(int index) {
        if (array.length == 0) {
            throw new IndexOutOfBoundsException("Array is empty.");
        }
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds " + (array.length - 1));
        }
        return array[index];
    }

    /**
     * Deletes the element at the specified index in the CustomArrayList.
     * If the index is out of bounds, an IndexOutOfBoundsException is thrown.
     *
     * @param index the index of the element to delete
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public void delete(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds " + (array.length - 1));
        }

        E[] container = array;
        array = (E[]) new Object[container.length - 1];
        System.arraycopy(container, 0, array, 0, index);
        int remain = container.length - index - 1;
        System.arraycopy(container, index + 1, array, index, remain);
    }

    /**
     * Deletes all elements in the CustomArrayList.
     * If the array is already empty, no action is taken.
     */
    @Override
    public void deleteAll() {
        if (array.length == 0) {
            return;
        }
        array = (E[]) new Object[0];
    }

    /**
     * Sorts the CustomArrayList in ascending order.
     * If the array is empty, an UnsupportedOperationException is thrown.
     */
    @Override
    public void sortAsc() {
        if (array.length == 0) {
            throw new UnsupportedOperationException("Array is empty.");
        }
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if ((int) array[j] > (int) array[j + 1]) {
                    E num = array[j];
                    array[j] = array[j+1];
                    array[j+1] = num;
                }
            }
        }
    }

    /**
     * Sorts the CustomArrayList in descending order.
     * If the array is empty, an UnsupportedOperationException is thrown.
     */
    @Override
    public void sortDesc() {
        if (array.length == 0) {
            throw new UnsupportedOperationException("Array is empty.");
        }
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if ((int) array[j] < (int) array[j + 1]) { // Change the comparison to <
                    E num = array[j];
                    array[j] = array[j+1];
                    array[j+1] = num;
                }
            }
        }
    }

    /**
     * Performs a QuickSort on the CustomArrayList using the provided comparator.
     * If the array is empty, an UnsupportedOperationException is thrown.
     *
     * @param comparator the comparator to determine the order of elements
     */
    @Override
    public void quickSort(Comparator<? super E> comparator) {
        if (array.length == 0) {
            throw new UnsupportedOperationException("Array is empty.");
        }
        quickSort(0, array.length - 1, comparator);
    }

    private void quickSort(int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pi = partition(low, high, comparator);
            quickSort(low, pi - 1, comparator);
            quickSort(pi + 1, high, comparator);
        }
    }

    private int partition(int low, int high, Comparator<? super E> comparator) {
        E pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], pivot) <= 0) {
                i++;
                E temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        E temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    /**
     * Sets the element at the specified index in the CustomArrayList.
     * If the index is out of bounds, an IndexOutOfBoundsException is thrown.
     *
     * @param index   the index at which the element should be set
     * @param element the element to set
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public void set(int index, E element) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds " + (array.length - 1));
        }
        array[index] = element;
    }

    /**
     * Retrieves the current size of the CustomArrayList.
     *
     * @return the size of the CustomArrayList
     */
    @Override
    public int size() {
        return array.length;
    }

    /**
     * Provides an iterator for iterating through the elements in the CustomArrayList.
     *
     * @return an iterator for the CustomArrayList
     */
    @Override
    public Iterator<E> iterator() {
        return new org.example.Iterator<>(array);
    }
}
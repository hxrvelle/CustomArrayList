package org.example;

import java.util.Iterator;

/**
 * An implementation of the CustomArrayList interface using an array.
 *
 * @param <E> the type of elements in the CustomArrayList
 */
public class CustomArrayList<E> implements CustomArrayListInterface<E> {
    private E[] array;

    /**
     * Constructs an empty CustomArrayListImpl.
     */
    public CustomArrayList() {
        array = (E[]) new Object[0];
    }

    /**
     * Adds an element to the end of the CustomArrayList.
     *
     * @param element the element to be added
     * @throws ClassCastException if not possible to cast an object
     * @return true if the element was successfully added, false otherwise
     */
    @Override
    public boolean add(E element) throws ClassCastException {
        try {
            E[] container = array;
            array = (E[]) new Object[container.length + 1];
            System.arraycopy(container, 0, array, 0, container.length);
            array[array.length - 1] = element;
            return true;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Adds an element at the specified index in the CustomArrayList.
     *
     * @param index   the index at which the element should be added
     * @param element the element to be added
     * @throws IndexOutOfBoundsException if specified index is out of bounds
     * @return true if the element was successfully added, false otherwise
     */
    @Override
    public boolean add(int index, E element) throws IndexOutOfBoundsException {
        try {
            E[] container = array;
            array = (E[]) new Object[container.length + 1];
            System.arraycopy(container, 0, array, 0, index);
            array[index] = element;
            int remain = container.length - index;
            System.arraycopy(container, index, array, index + 1, remain);
            return true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index " + index + " is out of bound " + (array.length - 1));
        }
        return false;
    }

    /**
     * Retrieves the element at the specified index in the CustomArrayList.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if specified index is out of bounds
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        try {
            return array[index];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index " + index + " is out of bound " + (array.length - 1));
        }
        return (E) ("Index " + index + " is out of bound " + (array.length - 1));
    }

    /**
     * Deletes the element at the specified index in the CustomArrayList.
     *
     * @param index the index of the element to delete
     * @throws IndexOutOfBoundsException if specified index is out of bounds
     */
    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        try {
            E[] container = array;
            array = (E[]) new Object[container.length - 1];
            System.arraycopy(container, 0, array, 0, index);
            int remain = container.length - index - 1;
            System.arraycopy(container, index + 1, array, index, remain);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Index " + index + " is out of bound " + (array.length + 1));
        }
    }

    /**
     * Deletes all elements in the CustomArrayList.
     */
    @Override
    public void deleteAll() {
        E[] container = array;
        array = (E[]) new Object[0];
        System.arraycopy(container, 0, array, 0, 0);
    }

    /**
     * Sorts the CustomArrayList in ascending order.
     */
    @Override
    public void sortAsc() {
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
     */
    @Override
    public void sortDesc() {
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
     * Performs a QuickSort on the CustomArrayList.
     */
    @Override
    public void quickSort() {
        quickSort(0, array.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        E pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (((Comparable<E>) array[j]).compareTo(pivot) <= 0) {
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
     *
     * @param index   the index at which the element should be set
     * @param element the element to set
     * @throws IndexOutOfBoundsException if specified index is out of bounds
     */
    @Override
    public void set(int index, E element) throws IndexOutOfBoundsException {
        try {
            array[index] = element;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index " + index + " is out of bound " + (array.length - 1));;
        }
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

    @Override
    public Iterator<E> iterator() {
        return new org.example.Iterator<>(array);
    }
}

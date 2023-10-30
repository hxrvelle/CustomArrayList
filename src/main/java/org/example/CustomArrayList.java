package org.example;

import java.util.Comparator;
import java.util.Iterator;

/**
 * An implementation of the CustomArrayList interface.
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
     * Sorts the CustomArrayList containing numeric values in ascending order.
     * @throws UnsupportedOperationException if the array is empty or if the array contains non-numeric elements
     */
    @Override
    public void sortAsc() {
        if (array.length == 0) {
            throw new UnsupportedOperationException("Array is empty.");
        }

        for (E element : array) {
            if (!(element instanceof Number)) {
                throw new UnsupportedOperationException("Array contains non-numeric elements.");
            }
        }

        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                Number num1 = (Number) array[j];
                Number num2 = (Number) array[j + 1];

                if (num1.doubleValue() > num2.doubleValue()) {
                    E temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts the CustomArrayList containing numeric values in descending order.
     * @throws UnsupportedOperationException if the array is empty or if the array contains non-numeric elements
     */
    @Override
    public void sortDesc() {
        if (array.length == 0) {
            throw new UnsupportedOperationException("Array is empty.");
        }

        for (E element : array) {
            if (!(element instanceof Number)) {
                throw new UnsupportedOperationException("Array contains non-numeric elements.");
            }
        }

        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                Number num1 = (Number) array[j];
                Number num2 = (Number) array[j + 1];

                if (num1.doubleValue() < num2.doubleValue()) {
                    E temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts the CustomArrayList in ascending order (A to Z) using bubble sort.
     * @throws UnsupportedOperationException if the array is empty or if the array contains non-string elements
     */
    public void sortAscAtoZ() {
        if (array.length == 0) {
            throw new UnsupportedOperationException("Array is empty.");
        }

        for (E element : array) {
            if (!(element instanceof String)) {
                throw new UnsupportedOperationException("Array contains non-String elements.");
            }
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (compareStrings(array[j], array[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the CustomArrayList in descending order (Z to A) using bubble sort.
     * @throws UnsupportedOperationException if the array is empty or if the array contains non-string elements
     */
    public void sortDescZtoA() {
        if (array.length == 0) {
            throw new UnsupportedOperationException("Array is empty.");
        }

        for (E element : array) {
            if (!(element instanceof String)) {
                throw new UnsupportedOperationException("Array contains non-String elements.");
            }
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (compareStrings(array[j], array[j + 1]) < 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private int compareStrings(E str1, E str2) {
        return ((String) str1).compareTo((String) str2);
    }

    private void swap(int index1, int index2) {
        E temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * Performs a QuickSort on the CustomArrayList using the provided comparator.
     * @param comparator the comparator to determine the order of elements
     * @throws UnsupportedOperationException if the array is empty
     */
    @Override
    public void quickSort(Comparator<? super E> comparator) {
        if (array.length == 0) {
            throw new UnsupportedOperationException("Array is empty.");
        }
        quickSort(0, array.length - 1, comparator);
    }

    /**
     * The quickSort method is a recursive method that sorts a subarray. It checks if low is less than high, and if so, it proceeds with the sorting process.
     *
     * The main steps are as follows:<br>
     * 1. Find the correct position (partition) for the pivot element.<br>
     * 2. Recursively apply the QuickSort algorithm to the elements before the pivot (elements less than the pivot) and after the pivot (elements greater than the pivot).
     * */
    private void quickSort(int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pi = partition(low, high, comparator);
            quickSort(low, pi - 1, comparator);
            quickSort(pi + 1, high, comparator);
        }
    }

    /**
     The partition method is responsible for selecting a pivot element (a selected element from the array that serves as a reference point for partitioning the array into two subarrays during the sorting process) and partitioning the array into two subarrays: elements less than or equal to the pivot and elements greater than the pivot.<br>
     The steps are as follows:<br>
     1. Choose a pivot element, typically the last element in the subarray.<br>
     2. Initialize the index i to (low - 1).<br>
     3. Iterate through the elements in the subarray from low to high.<br>
     4. Compare each element with the pivot using the provided Comparator.<br>
     5. If the element is less than or equal to the pivot, swap it with the element at index i and increment i.<br>
     6. After the loop, swap the pivot element with the element at index (i + 1), placing the pivot in its correct position.<br>
     7. Return the index (i + 1) as the final position of the pivot.<br>
     This process is repeated recursively until the entire array is sorted.
     */
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
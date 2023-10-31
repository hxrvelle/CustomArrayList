package org.example.datastructures;

import org.example.utils.QuickSortLogic;
import org.example.utils.StringComparator;

import java.util.Comparator;
import java.util.Iterator;

import static org.example.utils.ExceptionHandlers.*;

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
        checkIndex(array, index);

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
        checkEmpty(array);
        checkIndex(array, index);

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
        checkIndex(array, index);

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
        checkEmpty(array);
        checkNonNumericElements(array);

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
        checkEmpty(array);
        checkNonNumericElements(array);

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
        checkEmpty(array);
        checkNonStringElements(array);

        StringComparator<E> stringComparator = new StringComparator();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (stringComparator.compareStrings(array[j], array[j + 1]) > 0) {
                    stringComparator.swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the CustomArrayList in descending order (Z to A) using bubble sort.
     * @throws UnsupportedOperationException if the array is empty or if the array contains non-string elements
     */
    public void sortDescZtoA() {
        checkEmpty(array);
        checkNonStringElements(array);

        StringComparator<E> stringComparator = new StringComparator();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (stringComparator.compareStrings(array[j], array[j + 1]) < 0) {
                    stringComparator.swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * Performs a QuickSort on the CustomArrayList using the provided comparator.
     * @param comparator the comparator to determine the order of elements
     * @throws UnsupportedOperationException if the array is empty
     */
    @Override
    public void quickSort(Comparator<? super E> comparator) {
        QuickSortLogic<E> quickSortLogic = new QuickSortLogic<>();
        checkEmpty(array);
        quickSortLogic.quickSort(array, comparator);
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
    public boolean set(int index, E element) {
        checkIndex(array, index);
        array[index] = element;
        return true;
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
        return new org.example.iterators.Iterator<>(array);
    }
}
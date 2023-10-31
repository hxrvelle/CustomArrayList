package org.example.datastructures;

import java.util.Comparator;

/**
 * An interface representing a СustomArrayList.
 *
 * @param <E> the type of elements in the СustomArrayList
 */
public interface CustomArrayListInterface<E> extends Iterable<E> {
    /**
     * Adds an element to the end of the СustomArrayList.
     *
     * @param element the element to be added
     * @return true if the element was successfully added, false otherwise
     */
    boolean add(E element);

    /**
     * Adds an element at the specified index in the CustomArrayList.
     *
     * @param index   the index at which the element should be added
     * @param element the element to be added
     * @return true if the element was successfully added, false otherwise
     */
    boolean add(int index, E element);

    /**
     * Retrieves the element at the specified index in the СustomArrayList.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     */
    E get(int index);

    /**
     * Deletes the element at the specified index in the СustomArrayList.
     *
     * @param index the index of the element to delete
     */
    void delete(int index);

    /**
     * Deletes all elements in the СustomArrayList.
     */
    void deleteAll();

    /**
     * Sorts the СustomArrayList containing numeric values in ascending order.
     */
    void sortAsc();

    /**
     * Sorts the СustomArrayList containing numeric values in descending order.
     */
    void sortDesc();

    /**
     * Sorts the CustomArrayList in ascending order (A to Z) using bubble sort.
     */
    public void sortAscAtoZ();

    /**
     * Sorts the CustomArrayList in descending order (Z to A) using bubble sort.
     */
    public void sortDescZtoA();

    /**
     * Performs a QuickSort on the СustomArrayList.
     */
    void quickSort(Comparator<? super E> comparator);

    /**
     * Sets the element at the specified index in the СustomArrayList.
     *
     * @param index   the index at which the element should be set
     * @param element the element to set
     */
    boolean set(int index, E element);

    /**
     * Retrieves the current size of the СustomArrayList.
     *
     * @return the size of the СustomArrayList
     */
    int size();
}
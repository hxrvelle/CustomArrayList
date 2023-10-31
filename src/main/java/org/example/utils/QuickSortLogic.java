package org.example.utils;

import java.util.Comparator;

/**
 * This class provides a QuickSort algorithm for sorting an array with custom element types using a provided comparator.
 *
 * @param <E> the type of elements in the array to be sorted
 */
public class QuickSortLogic<E> {
    /**
     * Sorts an array using the QuickSort algorithm with a custom comparator.
     *
     * @param array      the array to be sorted
     * @param comparator the comparator to determine the order of elements
     */
    public void quickSort(E[] array, Comparator<? super E> comparator) {
        quickSort(array, 0, array.length - 1, comparator);
    }

    /**
     * The quickSort method is a recursive method that sorts a subarray. It checks if low is less than high, and if so, it proceeds with the sorting process.
     *
     * The main steps are as follows:
     * <ol>
     *     <li>Find the correct position (partition) for the pivot element.</li>
     *     <li>Recursively apply the QuickSort algorithm to the elements before the pivot (elements less than the pivot) and after the pivot (elements greater than the pivot).</li>
     * </ol>
     *
     * @param array      the array to be sorted
     * @param low        the lowest index of the subarray
     * @param high       the highest index of the subarray
     * @param comparator the comparator to determine the order of elements
     */
    private void quickSort(E[] array, int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pi = partition(array, low, high, comparator);
            quickSort(array, low, pi - 1, comparator);
            quickSort(array, pi + 1, high, comparator);
        }
    }

    /**
     * The partition method is responsible for selecting a pivot element (a reference point for partitioning the array into two subarrays during the sorting process) and partitioning the array into two subarrays: elements less than or equal to the pivot and elements greater than the pivot.
     *
     * The steps are as follows:
     * <ol>
     *     <li>Choose a pivot element, typically the last element in the subarray.</li>
     *     <li>Initialize the index i to (low - 1).</li>
     *     <li>Iterate through the elements in the subarray from low to high.</li>
     *     <li>Compare each element with the pivot using the provided Comparator.</li>
     *     <li>If the element is less than or equal to the pivot, swap it with the element at index i and increment i.</li>
     *     <li>After the loop, swap the pivot element with the element at index (i + 1), placing the pivot in its correct position.</li>
     *     <li>Return the index (i + 1) as the final position of the pivot.</li>
     * </ol>
     *
     * @param array      the array to be partitioned
     * @param low        the lowest index of the subarray
     * @param high       the highest index of the subarray
     * @param comparator the comparator to determine the order of elements
     * @return the final position of the pivot after partitioning
     */
    private int partition(E[] array, int low, int high, Comparator<? super E> comparator) {
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
}

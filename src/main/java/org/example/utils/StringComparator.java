package org.example.utils;

/**
 * The StringComparator class provides utility methods for comparing and swapping elements in an array of strings.
 *
 * @param <E> the type of elements in the array
 */
public class StringComparator<E> {
    /**
     * Compares two strings and returns a value indicating their relative order.
     *
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return a negative integer if str1 is less than str2, 0 if they are equal, or a positive integer if str1 is greater than str2
     */
    public int compareStrings(E str1, E str2) {
        return ((String) str1).compareTo((String) str2);
    }

    /**
     * Swaps two elements in an array at the specified indices.
     *
     * @param array   the array containing elements to be swapped
     * @param index1  the index of the first element to be swapped
     * @param index2  the index of the second element to be swapped
     */
    public void swap(E[] array, int index1, int index2) {
        E temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
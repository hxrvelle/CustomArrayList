package org.example.utils;

/**
 * This utility class provides exception handling methods for validating array indices and element types.
 */
public class ExceptionHandlers {
    /**
     * Checks if the given index is within the bounds of the array. If the index is out of bounds, it throws an IndexOutOfBoundsException.
     *
     * @param array the array to validate against
     * @param index the index to check
     * @param <E>   the type of elements in the array
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public static <E> void checkIndex(E[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds " + (array.length - 1));
        }
    }

    /**
     * Checks if the given array is empty. If the array is empty, it throws an UnsupportedOperationException.
     *
     * @param array the array to check for emptiness
     * @param <E>   the type of elements in the array
     * @throws UnsupportedOperationException if the array is empty
     */
    public static <E> void checkEmpty(E[] array) {
        if (array.length == 0) {
            throw new UnsupportedOperationException("Array is empty.");
        }
    }

    /**
     * Checks if the array contains non-numeric elements. If any element in the array is not an instance of Number, it throws an UnsupportedOperationException.
     *
     * @param array the array to check for non-numeric elements
     * @param <E>   the type of elements in the array
     * @throws UnsupportedOperationException if the array contains non-numeric elements
     */
    public static <E> void checkNonNumericElements(E[] array) {
        for (E element : array) {
            if (!(element instanceof Number)) {
                throw new UnsupportedOperationException("List contains non-numeric elements.");
            }
        }
    }

    /**
     * Checks if the array contains non-String elements. If any element in the array is not an instance of String, it throws an UnsupportedOperationException.
     *
     * @param array the array to check for non-String elements
     * @param <E>   the type of elements in the array
     * @throws UnsupportedOperationException if the array contains non-String elements
     */
    public static <E> void checkNonStringElements(E[] array) {
        for (E element : array) {
            if (!(element instanceof String)) {
                throw new UnsupportedOperationException("List contains non-String elements.");
            }
        }
    }
}
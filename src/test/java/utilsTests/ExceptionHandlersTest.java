package utilsTests;

import org.example.utils.ExceptionHandlers;
import org.junit.Test;

public class ExceptionHandlersTest {
    @Test
    public void testCheckIndexValidIndex() {
        Integer[] array = {1, 2, 3};
        ExceptionHandlers.checkIndex(array, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCheckIndexInvalidIndex() {
        Integer[] array = {1, 2, 3};
        ExceptionHandlers.checkIndex(array, 5);
    }

    @Test
    public void testCheckEmptyNonEmptyArray() {
        Integer[] array = {1, 2, 3};
        ExceptionHandlers.checkEmpty(array);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCheckEmptyEmptyArray() {
        Integer[] array = {};
        ExceptionHandlers.checkEmpty(array);
    }

    @Test
    public void testCheckNonNumericElementsWithNumbers() {
        Integer[] array = {1, 2, 3};
        ExceptionHandlers.checkNonNumericElements(array);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCheckNonNumericElementsWithNonNumbers() {
        String[] array = {"one", "two", "three"};
        ExceptionHandlers.checkNonNumericElements(array);
    }

    @Test
    public void testCheckNonStringElementsWithStrings() {
        String[] array = {"one", "two", "three"};
        ExceptionHandlers.checkNonStringElements(array);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCheckNonStringElementsWithNonStrings() {
        Integer[] array = {1, 2, 3};
        ExceptionHandlers.checkNonStringElements(array);
    }
}

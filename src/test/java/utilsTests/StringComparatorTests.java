package utilsTests;

import org.example.utils.StringComparator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringComparatorTests {
    private StringComparator<String> stringComparator;

    @Before
    public void setUp() {
        stringComparator = new StringComparator<>();
    }

    @Test
    public void testCompareStrings() {
        String str1 = "apple";
        String str2 = "banana";
        int result = stringComparator.compareStrings(str1, str2);
        assertTrue(result < 0);
    }

    @Test
    public void testSwap() {
        String[] array = {"apple", "banana", "cherry"};
        stringComparator.swap(array, 0, 1);
        assertEquals("banana", array[0]);
        assertEquals("apple", array[1]);
    }

    @Test
    public void testCompareStringsWithNull() {
        String str1 = null;
        String str2 = "banana";
        try {
            stringComparator.compareStrings(str1, str2);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            // Success
        }
    }

    @Test
    public void testSwapWithInvalidIndices() {
        String[] array = {"apple", "banana", "cherry"};
        try {
            stringComparator.swap(array, -1, 2);
            fail("Expected ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Success
        }
    }
}

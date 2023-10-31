package utilsTests;

import org.example.utils.QuickSortLogic;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortLogicTests {
    private QuickSortLogic<Integer> quickSortLogic;

    @Before
    public void setUp() {
        quickSortLogic = new QuickSortLogic<>();
    }

    @Test
    public void testQuickSortAscending() {
        Integer[] array = {3, 1, 2, 5, 4};
        quickSortLogic.quickSort(array, Comparator.naturalOrder());
        Integer[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSortDescending() {
        Integer[] array = {3, 1, 2, 5, 4};
        quickSortLogic.quickSort(array, Comparator.reverseOrder());
        Integer[] expected = {5, 4, 3, 2, 1};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSortEmptyArray() {
        Integer[] array = {};
        quickSortLogic.quickSort(array, Comparator.naturalOrder());
        Integer[] expected = {};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSortWithCustomComparator() {
        Integer[] array = {3, 1, 2, 5, 4};
        quickSortLogic.quickSort(array, (a, b) -> b - a);
        Integer[] expected = {5, 4, 3, 2, 1};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSortLargeArray() {
        Integer[] array = new Integer[1000];
        for (int i = 999; i >= 0; i--) {
            array[999 - i] = i;
        }

        Integer[] expected = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            expected[i] = i;
        }

        quickSortLogic.quickSort(array, Comparator.naturalOrder());
        assertArrayEquals(expected, array);
    }
}

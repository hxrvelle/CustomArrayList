package datastructuresTests;

import org.example.datastructures.CustomArrayList;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

public class CustomArrayListNegativeTests {

    private CustomArrayList<Integer> customArrayList;
    private CustomArrayList<String> customArrayListString;

    @Before
    public void setUp() {
        customArrayList = new CustomArrayList<>();
        customArrayListString = new CustomArrayList<>();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexIndexOutOfBoundsException() {
        customArrayList.add(0, 1);
        customArrayList.add(2, 2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetUnsupportedOperationException() {
        customArrayList.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfBoundsException() {
        customArrayList.add(1);
        customArrayList.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteAtIndexIndexOutOfBoundsException() {
        for (int i = 0; i < 2; i++) {
            customArrayList.delete(i);
        }
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSortAscUnsupportedOperationExceptionEmptyArray() {
        customArrayList.sortAsc();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSortAscUnsupportedOperationExceptionNonNumericElements() {
        customArrayListString.add("this");
        customArrayListString.add("is");
        customArrayListString.add("test");
        customArrayList.sortAsc();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSortDescUnsupportedOperationExceptionEmptyArray() {
        customArrayList.sortDesc();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSortDescUnsupportedOperationExceptionNonNumericElements() {
        customArrayListString.add("this");
        customArrayListString.add("is");
        customArrayListString.add("test");
        customArrayList.sortDesc();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSortAscAtoZUnsupportedOperationExceptionEmptyArray() {
        customArrayList.sortAscAtoZ();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSortAscAtoZUnsupportedOperationExceptionNonStringElements() {
        customArrayList.add(5);
        customArrayList.add(1);
        customArrayList.add(10);

        customArrayList.sortAscAtoZ();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSortDescZtoAUnsupportedOperationExceptionEmptyArray() {
        customArrayList.sortDescZtoA();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSortDescZtoAUnsupportedOperationExceptionNonStringElements() {
        customArrayList.add(5);
        customArrayList.add(1);
        customArrayList.add(10);

        customArrayList.sortAscAtoZ();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testQuickSortUnsupportedOperationException() {
        customArrayList.quickSort(Comparator.naturalOrder());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIndexOutOfBoundsException() {
        for (int i = 0; i < 2; i++) {
            customArrayList.set(i, i + 1);
        }
    }
}
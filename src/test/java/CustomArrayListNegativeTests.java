import org.example.CustomArrayList;
import org.example.CustomArrayListInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class CustomArrayListNegativeTests {

    private CustomArrayListInterface<Integer> customArrayList;

    @Before
    public void setUp() {
        customArrayList = new CustomArrayList<>();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexIndexOutOfBoundsException() {
        customArrayList.add(0, 1);
        customArrayList.add(2, 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfBoundsExceptionWhenEmpty() {
        customArrayList.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfBoundsExceptionWhenOutOfBound() {
        customArrayList.add(1);
        customArrayList.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteAtIndexIndexOutOfBoundsExceptionWhenEmpty() {
        customArrayList.delete(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteAtIndexIndexOutOfBoundsExceptionWhenOutOfBound() {
        customArrayList.add(0, 1);
        customArrayList.delete(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSortAscUnsupportedOperationExceptionWhenEmpty() {
        customArrayList.sortAsc();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSortDescUnsupportedOperationExceptionWhenEmpty() {
        customArrayList.sortDesc();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testQuickSortUnsupportedOperationExceptionWhenEmpty() {
        customArrayList.quickSort(Comparator.naturalOrder());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIndexOutOfBoundsExceptionWhenOutOfBound() {
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.set(3, 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIndexOutOfBoundsExceptionWhenEmpty() {
        customArrayList.set(3, 4);
    }
}
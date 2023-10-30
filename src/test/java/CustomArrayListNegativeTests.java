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
    public void testGetIndexOutOfBoundsException() {
        customArrayList.get(0);
        customArrayList.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteAtIndexIndexOutOfBoundsException() {
        for (int i = 0; i < 2; i++) {
            customArrayList.delete(i);
        }
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSortAscUnsupportedOperationException() {
        customArrayList.sortAsc();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSortDescUnsupportedOperationException() {
        customArrayList.sortDesc();
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
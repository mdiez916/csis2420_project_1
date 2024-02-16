package algs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HeapSortTest {

    @Test
    public void testSort_givenArray_sortsArray() {
        HeapSort heapSort = new HeapSort();
        int[] arr = {12, 11, 13, 5, 6, 7};
        int[] expected = {5, 6, 7, 11, 12, 13};
        heapSort.sort(arr);
        assertArrayEquals(expected, arr, "The array should be sorted");
    }

    @Test
    public void testSort_alreadySortedArray_keepsArraySorted() {
        HeapSort heapSort = new HeapSort();
        int[] arr = {5, 6, 7, 11, 12, 13};
        int[] expected = {5, 6, 7, 11, 12, 13};
        heapSort.sort(arr);
        assertArrayEquals(expected, arr, "The already sorted array should remain sorted");
    }

    @Test
    public void testSort_reverseSortedArray_sortsArray() {
        HeapSort heapSort = new HeapSort();
        int[] arr = {13, 12, 11, 7, 6, 5};
        int[] expected = {5, 6, 7, 11, 12, 13};
        heapSort.sort(arr);
        assertArrayEquals(expected, arr, "The reverse sorted array should be sorted");
    }

    @Test
    public void testSort_arrayWithDuplicates_sortsArray() {
        HeapSort heapSort = new HeapSort();
        int[] arr = {12, 11, 13, 5, 6, 7, 5};
        int[] expected = {5, 5, 6, 7, 11, 12, 13};
        heapSort.sort(arr);
        assertArrayEquals(expected, arr, "The array with duplicates should be sorted");
    }

    @Test
    public void testSort_singleElementArray_keepsArraySame() {
        HeapSort heapSort = new HeapSort();
        int[] arr = {1};
        int[] expected = {1};
        heapSort.sort(arr);
        assertArrayEquals(expected, arr, "The single element array should remain the same");
    }

    @Test
    public void testSort_emptyArray_keepsArrayEmpty() {
        HeapSort heapSort = new HeapSort();
        int[] arr = {};
        int[] expected = {};
        heapSort.sort(arr);
        assertArrayEquals(expected, arr, "The empty array should remain empty");
    }
}

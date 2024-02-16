package algs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class QuickSortTest {

	@Test
	public void testQuickSort_givenArray_sortsArray() {
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int[] expected = { 1, 5, 7, 8, 9, 10 };
		QuickSort.quickSort(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr, "The array should be sorted");
	}

	@Test
	public void testQuickSort_alreadySortedArray_keepsArraySorted() {
		int[] arr = { 1, 5, 7, 8, 9, 10 };
		int[] expected = { 1, 5, 7, 8, 9, 10 };
		QuickSort.quickSort(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr, "The already sorted array should remain sorted");
	}

	@Test
	public void testQuickSort_reverseSortedArray_sortsArray() {
		int[] arr = { 10, 9, 8, 7, 5, 1 };
		int[] expected = { 1, 5, 7, 8, 9, 10 };
		QuickSort.quickSort(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr, "The reverse sorted array should be sorted");
	}

	@Test
	public void testQuickSort_arrayWithDuplicates_sortsArray() {
		int[] arr = { 5, 7, 8, 9, 1, 5 };
		int[] expected = { 1, 5, 5, 7, 8, 9 };
		QuickSort.quickSort(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr, "The array with duplicates should be sorted");
	}

	@Test
	public void testQuickSort_singleElementArray_keepsArraySame() {
		int[] arr = { 1 };
		int[] expected = { 1 };
		QuickSort.quickSort(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr, "The single element array should remain the same");
	}

	@Test
	public void testQuickSort_emptyArray_keepsArrayEmpty() {
		int[] arr = {};
		int[] expected = {};
		QuickSort.quickSort(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr, "The empty array should remain empty");
	}
}

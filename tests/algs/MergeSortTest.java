package algs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MergeSortTest {

	@Test
	public void testSort_givenArray_sortsArray() {
		MergeSort mergeSort = new MergeSort();
		int[] arr = { 12, 11, 13, 5, 6, 7 };
		int[] expected = { 5, 6, 7, 11, 12, 13 };
		mergeSort.sort(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr, "The array should be sorted");
	}

	@Test
	public void testSort_alreadySortedArray_keepsArraySorted() {
		MergeSort mergeSort = new MergeSort();
		int[] arr = { 5, 6, 7, 11, 12, 13 };
		int[] expected = { 5, 6, 7, 11, 12, 13 };
		mergeSort.sort(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr, "The already sorted array should remain sorted");
	}

	@Test
	public void testSort_reverseSortedArray_sortsArray() {
		MergeSort mergeSort = new MergeSort();
		int[] arr = { 13, 12, 11, 7, 6, 5 };
		int[] expected = { 5, 6, 7, 11, 12, 13 };
		mergeSort.sort(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr, "The reverse sorted array should be sorted");
	}

	@Test
	public void testSort_arrayWithDuplicates_sortsArray() {
		MergeSort mergeSort = new MergeSort();
		int[] arr = { 12, 11, 13, 5, 6, 7, 5 };
		int[] expected = { 5, 5, 6, 7, 11, 12, 13 };
		mergeSort.sort(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr, "The array with duplicates should be sorted");
	}

	@Test
	public void testSort_singleElementArray_keepsArraySame() {
		MergeSort mergeSort = new MergeSort();
		int[] arr = { 1 };
		int[] expected = { 1 };
		mergeSort.sort(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr, "The single element array should remain the same");
	}

	@Test
	public void testSort_emptyArray_keepsArrayEmpty() {
		MergeSort mergeSort = new MergeSort();
		int[] arr = {};
		int[] expected = {};
		mergeSort.sort(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr, "The empty array should remain empty");
	}
}

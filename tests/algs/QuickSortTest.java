package algs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/**
 * Test cases for QuickSort class.
 */
public class QuickSortTest {

	@Test
	public void testSortEmptyArray() {
		QuickSort sorter = new QuickSort();
		int[] arr = {};
		sorter.quickSort(arr, 0, arr.length - 1);
		assertArrayEquals(new int[] {}, arr, "The sorted empty array should be equal to the original empty array.");
	}

	@Test
	public void testSortSingleElement() {
		QuickSort sorter = new QuickSort();
		int[] arr = { 1 };
		sorter.quickSort(arr, 0, arr.length - 1);
		assertArrayEquals(new int[] { 1 }, arr, "The sorted single-element array should be unchanged.");
	}

	@Test
	public void testSortArray() {
		QuickSort sorter = new QuickSort();
		int[] arr = { 4, 3, 2, 1 };
		sorter.quickSort(arr, 0, arr.length - 1);
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, arr, "The array should be sorted in ascending order.");
	}

	@Test
	public void testSortList() {
		QuickSort sorter = new QuickSort();
		List<Integer> list = Arrays.asList(4, 3, 2, 1);
		sorter.sort(list);
		assertEquals(Arrays.asList(1, 2, 3, 4), list, "The list should be sorted in ascending order.");
	}

	@Test
	public void testComparisonsAfterSort() {
		QuickSort sorter = new QuickSort();
		int[] arr = { 5, 4, 3, 2, 1 };
		sorter.quickSort(arr, 0, arr.length - 1);
		assertTrue(sorter.getComparisons() > 0, "There should be some comparisons made to sort the array.");
	}

	@Test
	public void testSortAlreadySortedArray() {
		QuickSort sorter = new QuickSort();
		int[] arr = { 1, 2, 3, 4, 5 };
		sorter.quickSort(arr, 0, arr.length - 1);
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr, "Sorting an already sorted array should not change it.");
	}
}

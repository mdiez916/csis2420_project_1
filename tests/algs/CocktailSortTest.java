package algs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CocktailSortTest {

	@Test
	public void testBasicFunctionality() {
		CocktailSort sorter = new CocktailSort();
		int[] actual = { 5, 1, 4, 2, 8, 0, 2 };
		int[] expected = { 0, 1, 2, 2, 4, 5, 8 };
		sorter.cocktailSort(actual);
		assertArrayEquals(expected, actual, "The array should be sorted in ascending order.");
	}

	@Test
	public void testEmptyArray() {
		CocktailSort sorter = new CocktailSort();
		int[] actual = {};
		int[] expected = {};
		sorter.cocktailSort(actual);
		assertArrayEquals(expected, actual, "An empty array should remain unchanged.");
	}

	@Test
	public void testAlreadySorted() {
		CocktailSort sorter = new CocktailSort();
		int[] actual = { 1, 2, 3, 4, 5 };
		int[] expected = { 1, 2, 3, 4, 5 };
		sorter.cocktailSort(actual);
		assertArrayEquals(expected, actual, "An already sorted array should remain unchanged.");
	}

	@Test
	public void testReverseSorted() {
		CocktailSort sorter = new CocktailSort();
		int[] actual = { 5, 4, 3, 2, 1 };
		int[] expected = { 1, 2, 3, 4, 5 };
		sorter.cocktailSort(actual);
		assertArrayEquals(expected, actual, "A reverse sorted array should be sorted in ascending order.");
	}

	@Test
	public void testDuplicates() {
		CocktailSort sorter = new CocktailSort();
		int[] actual = { 4, 2, 2, 4, 3 };
		int[] expected = { 2, 2, 3, 4, 4 };
		sorter.cocktailSort(actual);
		assertArrayEquals(expected, actual, "An array with duplicates should be sorted correctly.");
	}
}

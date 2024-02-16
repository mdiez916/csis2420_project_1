package algs;

import java.util.List;

/**
 * @author Group 2
 */
public class CocktailSort {
    private int comparisons = 0; // Tracks the number of comparisons made during sorting.

    /**
     * Performs a Cocktail Sort on the given array.
     * Cocktail Sort is a variation of Bubble Sort that traverses the array in both directions.
     * This approach helps to tackle the turtle and rabbit problem seen in Bubble Sort.
     *
     * @param a The array to be sorted.
     */
    public void cocktailSort(int[] a) {
        boolean swapped = true; // Flag to keep track of whether any swaps were made in the current pass.
        int start = 0; // Starting index of the current pass.
        int end = a.length; // Ending index of the current pass.

        comparisons = 0; // Reset the comparisons counter at the start of the sort.

        while (swapped) {
            swapped = false; // Assume no swaps will be made in this pass.

            // Forward pass: from start to just before the end.
            for (int i = start; i < end - 1; ++i) {
                comparisons++; // Count each comparison.
                if (a[i] > a[i + 1]) { // If the current element is greater than the next element, swap them.
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true; // Mark that a swap has occurred, indicating the list is not yet sorted.
                }
            }

            if (!swapped) break; // If no swaps were made in the forward pass, the array is sorted.

            swapped = false; // Reset swap flag for the backward pass.
            end--; // Decrement the end index since the last element is now sorted.

            // Backward pass: from the end back to the start.
            for (int i = end - 1; i >= start; i--) {
                comparisons++; // Count each comparison.
                if (a[i] > a[i + 1]) { // If the current element is greater than the next element, swap them.
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true; // Mark that a swap has occurred.
                }
            }

            start++; // Increment the start index as the first element is now sorted for the next pass.
        }
    }

    /**
     * Overloaded method to sort a List<Integer>.
     *
     * @param list The list of integers to be sorted.
     */
    public void sort(List<Integer> list) {
        // Convert List<Integer> to int[] for sorting.
        int[] arr = list.stream().mapToInt(i -> i).toArray();

        comparisons = 0; // Reset comparisons counter before sorting.

        cocktailSort(arr); // Perform the sort on the array.

        // Update the original list with the sorted values.
        for (int i = 0; i < arr.length; i++) {
            list.set(i, arr[i]);
        }
    }

    /**
     * Returns the number of comparisons made during the sort.
     *
     * @return The number of comparisons.
     */
    public int getComparisons() {
        return comparisons;
    }
}

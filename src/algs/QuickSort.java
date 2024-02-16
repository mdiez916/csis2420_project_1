package algs;

import java.util.List;

/**
 * @author Group 2
 */
public class QuickSort {
    // Variable to keep track of the number of comparisons made during the sort.
    private int comparisons;

    /**
     * Constructor initializes the comparison count.
     */
    public QuickSort() {
        this.comparisons = 0; // Initialize comparisons to zero at the start.
    }

    /**
     * Swaps two elements in an array.
     * @param arr The array containing elements to be swapped.
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Partitions the array around the pivot such that elements on left of pivot are less than it
     * and elements on the right are greater than it.
     * @param arr The array to be partitioned.
     * @param low The starting index of the portion of the array to be sorted.
     * @param high The ending index of the portion of the array to be sorted.
     * @return The index of the pivot element after partition.
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing the last element as pivot
        int i = (low - 1); // Index of smaller element

        for (int j = low; j <= high - 1; j++) {
            this.comparisons++; // Count each comparison

            if (arr[j] < pivot) {
                i++; // Increment index of smaller element
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1); // Return the partitioning index
    }

    /**
     * The main function that implements QuickSort algorithm.
     * @param arr Array to be sorted.
     * @param low Starting index.
     * @param high Ending index.
     */
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Sorts a List<Integer> using the quick sort algorithm.
     * @param list The list of integers to be sorted.
     */
    public void sort(List<Integer> list) {
        // Convert List<Integer> to int[] for sorting
        int[] arr = list.stream().mapToInt(i -> i).toArray();

        this.comparisons = 0; // Reset the comparisons counter before sorting

        // Perform the sort
        quickSort(arr, 0, arr.length - 1);

        // Update the list with sorted values
        for (int i = 0; i < arr.length; i++) {
            list.set(i, arr[i]);
        }
    }

    /**
     * Returns the total number of comparisons made during the sort.
     * @return The number of comparisons.
     */
    public int getComparisons() {
        return comparisons;
    }
}

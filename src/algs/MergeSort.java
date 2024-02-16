package algs;

import java.util.List;

/**
 * @author Group 2
 */
class MergeSort {
    // Variable to track the number of comparisons made during sorting.
    private int comparisons = 0;

    /**
     * Returns the total number of comparisons made during the sort.
     * @return The number of comparisons.
     */
    public int getComparisons() {
        return comparisons;
    }

    /**
     * Sorts a list of integers using the merge sort algorithm.
     * @param list The list of integers to be sorted.
     */
    public void sort(List<Integer> list) {
        // Convert List<Integer> to int[] for sorting.
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        
        // Reset the comparisons counter before starting the sort.
        comparisons = 0;

        // Perform the recursive sort.
        sort(arr, 0, arr.length - 1);
        
        // Update the original list with the sorted values from the array.
        for (int i = 0; i < arr.length; i++) {
            list.set(i, arr[i]);
        }
    }

    /**
     * Recursively sorts the specified portion of the array using merge sort.
     * @param arr The array to be sorted.
     * @param l The starting index of the portion to be sorted.
     * @param r The ending index of the portion to be sorted.
     */
    public void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point to divide the array into two halves.
            int m = l + (r - l) / 2;

            // Sort the first and second halves.
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves.
            merge(arr, l, m, r);
        }
    }

    /**
     * Merges two subarrays of arr[].
     * First subarray is arr[l..m].
     * Second subarray is arr[m+1..r].
     * @param arr The array containing the subarrays to merge.
     * @param l The starting index of the first subarray.
     * @param m The ending index of the first subarray.
     * @param r The ending index of the second subarray.
     */
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged.
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays.
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays.
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays back into arr[l..r].
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            comparisons++; // Increment comparison count for each comparison made.
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any.
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any.
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * A utility function to print the contents of an array.
     * @param arr The array to be printed.
     * @param comparisons The number of comparisons made during sorting.
     */
    static void printArray(int arr[], int comparisons) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
        System.out.println("Total comparisons made: " + comparisons);
    }

    public static void main(String args[]) {
        MergeSort ob = new MergeSort();
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given array is");
        printArray(arr, 0); // Initial call with 0 comparisons to show the array before sorting.

        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr, ob.getComparisons()); // Display the sorted array and the total number of comparisons.
    }
}

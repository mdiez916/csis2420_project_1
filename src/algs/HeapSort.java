package algs;

import java.util.List;
import java.util.Random;

/**
 * @author Group 2
 */
public class HeapSort {
    // Tracks the number of comparisons during sorting
    public int comparisons = 0;

    /**
     * Sorts an array using heap sort algorithm and returns the number of comparisons made.
     * This method first builds a max heap and then extracts elements from the heap
     * to get them in sorted order.
     *
     * @param arr The array to be sorted.
     * @return The count of comparisons made during the sort.
     */
    public int sort(int[] arr) {
        int n = arr.length;
        comparisons = 0; // Reset comparisons at the start

        // Build heap (rearrange array into a max heap)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end (swap arr[0] with arr[i])
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
        return comparisons;
    }

    /**
     * Overloaded sort method to accept a List<Integer>, sort it, and return the number of comparisons.
     *
     * @param list The list of integers to be sorted.
     * @return The count of comparisons made during the sort.
     */
    public int sort(List<Integer> list) {
        // Convert List<Integer> to int[] for sorting
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        int comps = sort(arr); // Sort the array and get the number of comparisons

        // Update the list with the sorted array
        for (int i = 0; i < arr.length; i++) {
            list.set(i, arr[i]);
        }
        return comps;
    }

    /**
     * Maintains the heap property for a subtree rooted with node i, which is an index in arr[].
     * n is the size of the heap.
     *
     * @param arr The array representation of the heap.
     * @param n The size of the heap.
     * @param i The index of the root element of the current subtree.
     */
    private void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
            comparisons++;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
            comparisons++;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    /**
     * Utility function to print the array on the console.
     *
     * @param arr The array to be printed.
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    /**
     * Returns the total number of comparisons made during the last sort operation.
     *
     * @return The number of comparisons.
     */
    public int getComparisons() {
        return comparisons;
    }

    /**
     * Generates an array of the given size filled with random values up to a specified max.
     *
     * @param size The size of the array to generate.
     * @param max The maximum value for elements in the array.
     * @return An int array filled with random numbers.
     */
    public static int[] generateRandomArray(int size, int max) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(max) + 1; // Elements range from 1 to max
        }
        return arr;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();

        // Example: Sorting a single array
        int[] arr = generateRandomArray(10, 100);
        int comparisons = heapSort.sort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
        System.out.println("Total comparisons made: " + comparisons);
    }
}
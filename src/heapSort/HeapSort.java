package heapSort;

import java.util.Random;

public class HeapSort {
    private int comparisons = 0; // Class-level variable to count comparisons

    public void sort(int[] arr) {
        int n = arr.length;

        // Reset the comparisons counter each time sort is called
        comparisons = 0;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
            comparisons++; // Increment for this comparison
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
            comparisons++; // Increment for this comparison
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify
            heapify(arr, n, largest);
        }
    }

    // A utility function to print the array and number of comparisons
    static void printArray(int[] arr, int comparisons) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
        System.out.println("Total comparisons made: " + comparisons);
    }

    // Generates an array of the given size with values between 1 and the specified max
    public static int[] generateRandomArray(int size, int max) {
        int[] randomArray = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            // Generate random number between 1 and max
            int randomNumber = random.nextInt(max) + 1;
            randomArray[i] = randomNumber;
        }
        return randomArray;
    }

    public static void main(String[] args) {
        // starting array randomly generated, 10 elements, between 1 and max, which is 100.
        int[] arr = generateRandomArray(10, 100);

        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);

        // Output
        System.out.println("Sorted array:");
        printArray(arr, heapSort.comparisons); // Pass comparisons to the print method
    }
}
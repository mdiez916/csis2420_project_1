package algs;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates all permutations of a given size n, with integers from 0 to n-1.
 */
public class ArrayGenerator {

    // Holds all generated permutations.
    private List<List<Integer>> permutations;

    /**
     * Constructor initializes the list to store permutations.
     */
    public ArrayGenerator() {
        this.permutations = new ArrayList<>();
    }

    /**
     * Generates all permutations of integers from 0 to n-1.
     * @param n The number of integers to generate permutations for.
     */
    public void generatePermutations(int n) {
        permutations.clear(); // Clear previous results to prepare for new generation
        List<Integer> initialList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            initialList.add(i); // Initialize the list with integers from 0 to n-1
        }
        permute(initialList, 0); // Begin permutation generation
    }

    /**
     * Recursively generates permutations starting from a given index.
     * @param array The current permutation being generated.
     * @param start The index at which to start generating permutations.
     */
    private void permute(List<Integer> array, int start) {
        if (start >= array.size()) {
            // If the start index is at the end of the list, a new permutation is complete.
            permutations.add(new ArrayList<>(array)); // Add a copy of the current permutation
        } else {
            for (int i = start; i < array.size(); i++) {
                java.util.Collections.swap(array, start, i); // Swap the current element with the start element
                permute(array, start + 1); // Recursively generate permutations for the next index
                java.util.Collections.swap(array, start, i); // Swap back to backtrack to the original configuration
            }
        }
    }

    /**
     * Returns the list of all generated permutations.
     * @return A list of permutations, each represented as a list of integers.
     */
    public List<List<Integer>> getPermutations() {
        return permutations;
    }
}
package algs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Client {

	static class SortingResult {
	    List<Integer> originalPermutation;
	    List<Integer> sortedPermutation;
	    double timeInSeconds;
	    int comparisons;

	    public SortingResult(List<Integer> originalPermutation, List<Integer> sortedPermutation, double timeInSeconds, int comparisons) {
	        this.originalPermutation = new ArrayList<>(originalPermutation); // Store the original permutation
	        this.sortedPermutation = new ArrayList<>(sortedPermutation); // Store the sorted permutation for clarity
	        this.timeInSeconds = timeInSeconds;
	        this.comparisons = comparisons;
	    }
	}

    public static void main(String[] args) {
        ArrayGenerator arrGen = new ArrayGenerator();
        int arrLength = 8; // Modify as needed to test different array lengths
        arrGen.generatePermutations(arrLength);
        List<List<Integer>> permutations = arrGen.getPermutations();

        // HeapSort as an example. Repeat similar blocks for other sorting algorithms.
        HeapSort heapSort = new HeapSort();
        System.out.println("Heap Sort Results:");
        List<SortingResult> heapSortResults = timeSort(permutations, heapSort);
        processAndDisplayResults(heapSortResults);
        
        MergeSort mergeSort = new MergeSort();
        System.out.println("Merge Sort Results:");
        List<SortingResult> mergeSortResults = timeSort(permutations, mergeSort);
        processAndDisplayResults(mergeSortResults);
        
        QuickSort quickSort = new QuickSort();
        System.out.println("Quick Sort Results:");
        List<SortingResult> quickSortResults = timeSort(permutations, quickSort);
        processAndDisplayResults(quickSortResults);
        
        CocktailSort cocktailSort = new CocktailSort();
        System.out.println("Cocktail Sort Results:");
        List<SortingResult> cockTailSortResults = timeSort(permutations, cocktailSort);
        processAndDisplayResults(cockTailSortResults);
    }

    private static List<SortingResult> timeSort(List<List<Integer>> permutations, Object alg) {
        List<SortingResult> results = new ArrayList<>();
        for (List<Integer> originalPermutation : permutations) {
            // Make a copy of the original permutation to sort, preserving the original
            List<Integer> permutationToSort = new ArrayList<>(originalPermutation);

            long startTime = System.nanoTime();
            int comparisons = 0;

            // Sort the copy, not the original
            if (alg instanceof HeapSort) {
                comparisons = ((HeapSort) alg).sort(permutationToSort);
            } else if (alg instanceof MergeSort) {
                ((MergeSort) alg).sort(permutationToSort);
                comparisons = ((MergeSort) alg).getComparisons();
            } else if (alg instanceof QuickSort) {
                ((QuickSort) alg).sort(permutationToSort);
                comparisons = ((QuickSort) alg).getComparisons();
            } else if (alg instanceof CocktailSort) {
                ((CocktailSort) alg).sort(permutationToSort);
                comparisons = ((CocktailSort) alg).getComparisons();
            }

            long endTime = System.nanoTime();
            double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
            
            // Add both the original and the sorted permutations to the results
            results.add(new SortingResult(originalPermutation, permutationToSort, durationSeconds, comparisons));
        }
        return results;
    }

    private static void processAndDisplayResults(List<SortingResult> results) {
        // Sort results by time to find best and worst cases
        results.sort(Comparator.comparingDouble(r -> r.timeInSeconds));

        System.out.println("10 Best Cases:");
        results.stream().limit(10).forEach(Client::printResult);

        System.out.println("\n10 Worst Cases:");
        results.stream().skip(Math.max(0, results.size() - 10)).forEach(Client::printResult);

        // Calculate averages
        double averageTime = results.stream().mapToDouble(r -> r.timeInSeconds).average().orElse(0);
        double averageComparisons = results.stream().mapToInt(r -> r.comparisons).average().orElse(0);

        System.out.printf("\nAverage Time: %.8f seconds\n", averageTime);
        System.out.printf("Average Comparisons: %.0f\n", averageComparisons);
        System.out.println("----------------------------------------\n");
    }

    private static void printResult(SortingResult result) {
        System.out.println("Original Permutation: " + result.originalPermutation 
            + ", Sorted Permutation: " + result.sortedPermutation 
            + ", Time: " + String.format("%.8f", result.timeInSeconds) + " seconds" 
            + ", Comparisons: " + result.comparisons);
    }
}
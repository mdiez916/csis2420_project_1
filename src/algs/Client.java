package algs;

import java.util.List;

/**
 * Driver code to run each algorithm at array length n and each permutation.
 * @author Group 2
 */
public class Client {

	public static void main(String[] args) {
		ArrayGenerator arrGen = new ArrayGenerator();
		int arrLength = 4; // Change this to test different array lengths and its permutations.
//	 	With 6 and 8 array lengths, output is too large to fit in console. Comment in/out algs if necessary.

		List<List<Integer>> permutations = arrGen.getPermutations();


//      Timing HeapSort

		arrGen.generatePermutations(arrLength);
		HeapSort heapSort = new HeapSort();
		System.out.println("Heap Sort");
		timeSort(permutations, heapSort);

//       Timing MergeSort

//        arrGen.generatePermutations(arrLength);
//        permutations = arrGen.getPermutations();
//        MergeSort mergeSort = new MergeSort();
//        System.out.println("Merge Sort");
//        timeSort(permutations, mergeSort);

//        Timing QuickSort

//        arrGen.generatePermutations(arrLength);
//        permutations = arrGen.getPermutations();
//        QuickSort quickSort = new QuickSort();
//        System.out.println("Quick Sort");
//        timeSort(permutations, quickSort);

//        Timing CocktailSort

//        arrGen.generatePermutations(arrLength);
//        permutations = arrGen.getPermutations();
//        CocktailSort cocktailSort = new CocktailSort();
//        System.out.println("Cocktail Sort");
//        timeSort(permutations, cocktailSort);
	}

	/**
	 * Calls the associated alg sort method and passes in the permutation.
	 * 
	 * @param permutations
	 * @param alt
	 */
	private static void timeSort(List<List<Integer>> permutations, Object alg) {
		for (List<Integer> permutation : permutations) {
			System.out.println("Before sorting: " + permutation);
			long startTime = System.nanoTime();
			int comparisons = 0;
			if (alg instanceof HeapSort) {
				comparisons = ((HeapSort) alg).sort(permutation);
			} else if (alg instanceof MergeSort) {
				((MergeSort) alg).sort(permutation);
				comparisons = ((MergeSort) alg).getComparisons();
			} else if (alg instanceof QuickSort) {
				((QuickSort) alg).sort(permutation);
				comparisons = ((QuickSort) alg).getComparisons();
			} else if (alg instanceof CocktailSort) {
				((CocktailSort) alg).sort(permutation);
				comparisons = ((CocktailSort) alg).getComparisons();
			}
			long endTime = System.nanoTime();
			long durationNano = endTime - startTime;
			double durationSeconds = durationNano / 1_000_000_000.0; // Convert nanoseconds to seconds
			System.out.println("After sorting: " + permutation);
			System.out.println("Comparisons made: " + comparisons);
			// Format to 6 decimal points
			System.out.println(String.format("Time taken: %.6f seconds\n", durationSeconds));
		}
		System.out.println("----------------------------------------");
		System.out.println("");
	}
}
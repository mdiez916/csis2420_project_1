package algs;

public class CocktailSort {
    private int comparisons = 0; // Class-level variable to count comparisons

    void cocktailSort(int a[]) {
        boolean swapped = true;
        int start = 0;
        int end = a.length;

        // Reset the comparisons counter each time cocktailSort is called
        comparisons = 0;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                comparisons++; // Increment the counter for each comparison
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;

            swapped = false;

            end = end - 1;

            for (int i = end - 1; i >= start; i--) {
                comparisons++; // Increment the counter for each comparison
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }

            start = start + 1;
        }
    }

    void printArray(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        // Print the total number of comparisons after the array
        System.out.println("Total comparisons made: " + comparisons);
    }

    public static void main(String[] args) {
        CocktailSort ob = new CocktailSort();
        int a[] = { 5, 1, 4, 2, 8, 0, 2 };
        ob.cocktailSort(a);
        System.out.println("Sorted array:");
        ob.printArray(a);
    }
}

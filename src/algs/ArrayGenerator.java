/**The goal with quicksort v3 is to make class QuickSort non-static, so 
 * that class ArrayGenerator can HAVE a QuickSort object, and use the 
 * quicksort method.
 * 
 */
package algs;

import org.ietf.jgss.GSSContext;

/**This is the Geeks4Geeks implementation of Heap's Algorithm for Generating
 * Array Permutations.
 * 
 * TODO this may need some modification to allow inputting of a desired array length,
 * and receiving 0 - n-1 elements in the array. Should be simple, and also unlikely
 * to be necessary I would think. However, it remains worth noting that the instructions
 * DO ask to be able to input a single int, and receive all permutations based on that. 
 * 
 * @author GFG
 *
 */
//Java program to print all permutations using
//Heap's algorithm
class ArrayGenerator {
	
	QuickSort qs = new QuickSort();
    
	
 // Prints the array
 void printArr(int a[], int n)
 {
     for (int i = 0; i < n; i++)
         System.out.print(a[i] + " "); 
     System.out.print(" --> ");
     qs.quickSort(a, 0, n - 1);
     qs.printArr(a); //printing sorted array seems not totally necessary. Hover over method for more.
//     qs.printCount(a);
 }

 // Generating permutation using Heap Algorithm
 void generateArrays(int a[], int size, int n)
 {
     // if size becomes 1 then prints the obtained
     // permutation
     if (size == 1)
         printArr(a, n);

     for (int i = 0; i < size; i++) {
         generateArrays(a, size - 1, n);

         // if size is odd, swap 0th i.e (first) and
         // (size-1)th i.e (last) element
         if (size % 2 == 1) {
             int temp = a[0];
             a[0] = a[size - 1];
             a[size - 1] = temp;
         }

         // If size is even, swap ith 
         // and (size-1)th i.e last element
         else {
             int temp = a[i];
             a[i] = a[size - 1];
             a[size - 1] = temp;
         }
     }
 }

 // Driver code
 public static void main(String args[])
 {
     ArrayGenerator ag = new ArrayGenerator();
     
//     int n4[] = { 0, 1, 2, 3 };
//     ag.generateArrays(n4, n4.length, n4.length); //generates AND sorts the arrays.
     
//     int n6[] = { 0, 1, 2, 3, 4, 5 };
//     ag.generateArrays(n6, n6.length, n6.length);
     
     int n8[] = { 0, 1, 2, 3, 4, 5, 6, 7 };
     ag.generateArrays(n8, n8.length, n8.length);
 }
}

//This code has been contributed by Amit Khandelwal.
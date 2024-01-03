package com.example.search;

// Fibonacci Search
public class FibonacciSearch {
    // Time Complexity: O(log n) - Logarithmic time complexity, similar to binary
    // search.
    public static int search(int[] array, int target) {
        int fibMMinus2 = 0;
        int fibMMinus1 = 1;
        int fibM = fibMMinus1 + fibMMinus2;

        // Find the largest Fibonacci number less than or equal to the array size
        while (fibM < array.length) {
            fibMMinus2 = fibMMinus1;
            fibMMinus1 = fibM;
            fibM = fibMMinus1 + fibMMinus2;
        }

        int offset = -1;

        // Perform binary search using Fibonacci numbers
        while (fibM > 1) {
            int i = Math.min(offset + fibMMinus2, array.length - 1);

            // Adjust the search space based on the current element
            if (array[i] < target) {
                fibM = fibMMinus1;
                fibMMinus1 = fibMMinus2;
                fibMMinus2 = fibM - fibMMinus1;
                offset = i;
            } else if (array[i] > target) {
                fibM = fibMMinus2;
                fibMMinus1 -= fibMMinus2;
                fibMMinus2 = fibM - fibMMinus1;
            } else {
                // Return the index if found
                return i;
            }
        }

        // Check the last element in case it's the target
        if (fibMMinus1 == 1 && array[offset + 1] == target) {
            // Return the index if found
            return offset + 1;
        }

        // Return -1 if the target is not found
        return -1;
    }
}
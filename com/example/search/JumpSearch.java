package com.example.search;

// Jump Search
public class JumpSearch {
    // Time Complexity: O(√n) - Square root of the array size, making it more
    // efficient than linear search.
    public static int search(int[] array, int target) {
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;

        // Jump ahead in fixed steps
        while (start < array.length && array[start] < target) {
            start += blockSize;
        }

        // Perform linear search within the block
        for (int i = start - blockSize; i < Math.min(start, array.length); i++) {
            if (array[i] == target) {
                // Return the index if found
                return i;
            }
        }

        // Return -1 if the target is not found
        return -1;
    }
}

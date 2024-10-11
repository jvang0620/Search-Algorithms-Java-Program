package src.search_algorithms;

import java.util.Arrays;

// Exponential Search
public class ExponentialSearch {
    // Time Complexity: O(log n) - Logarithmic time complexity, similar to binary
    // search.
    public static int search(int[] array, int target) {
        // Check if the target is at the first position
        if (array[0] == target) {
            return 0;
        }

        int i = 1;
        // Exponentially increase the bounds
        while (i < array.length && array[i] <= target) {
            i *= 2;
        }

        // Perform binary search within the adjusted bounds
        return BinarySearch.search(Arrays.copyOfRange(array, i / 2, Math.min(i, array.length)), target);
    }
}

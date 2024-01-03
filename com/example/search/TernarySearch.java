package com.example.search;

// Ternary Search
public class TernarySearch {
    // Time Complexity: O(log3 n) - Logarithmic time complexity, dividing the search
    // space into three parts.
    public static int search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        // Perform ternary search
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            // Check if the target is at one of the midpoints
            if (array[mid1] == target) {
                // Return the index if found
                return mid1;
            } else if (array[mid2] == target) {
                // Return the index if found
                return mid2;
            } else if (target < array[mid1]) {
                high = mid1 - 1;
            } else if (target > array[mid2]) {
                low = mid2 + 1;
            } else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }

        // Return -1 if the target is not found
        return -1;
    }
}

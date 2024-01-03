package com.example.search;

// Interpolation Search
public class InterpolationSearch {
    // Time Complexity: O(log log n) - Expected logarithmic time complexity for
    // uniformly distributed sorted arrays.
    public static int search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        // Perform interpolation search
        while (low <= high && target >= array[low] && target <= array[high]) {
            // Estimate the probable position of the target
            int pos = low + ((high - low) / (array[high] - array[low])) * (target - array[low]);

            // Check if the estimated position contains the target
            if (array[pos] == target) {
                // Return the index if found
                return pos;
            }

            // Adjust the search space based on the estimated position
            if (array[pos] < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        // Return -1 if the target is not found
        return -1;
    }
}

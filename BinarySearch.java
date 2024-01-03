public class BinarySearch {
    // Binary Search
    // Time Complexity: O(log n) - Logarithmic time complexity as it divides the
    // search space in half at each step.
    static int search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        // Perform binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the middle element is equal to the target
            if (array[mid] == target) {
                // Return the index if found
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Return -1 if the target is not found
        return -1;
    }

}

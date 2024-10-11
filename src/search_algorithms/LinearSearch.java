package src.search_algorithms;

public class LinearSearch {
    // LinearSearch
    // Time Complexity: O(n) - Linear time complexity as it traverses the array
    // sequentially.
    public static int search(int[] array, int target) {
        // Traverse the array sequentially
        for (int i = 0; i < array.length; i++) {
            // Check if the current element is equal to the target
            if (array[i] == target) {
                // Return the index if found
                return i;
            }
        }
        // Return -1 if the target is not found
        return -1;
    }
}
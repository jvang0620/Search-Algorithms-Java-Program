/*
This Java program implements various search algorithms for finding a target element in a sorted array. Here's an overview of the program's structure and functionality:

Main Class (SearchAlgorithms):

Contains the main method where the execution starts.
Creates a sorted array of integers.
Specifies target elements for each search algorithm.
Calls each search algorithm with the sorted array and the corresponding target element.
Displays the original sorted array and the result of each search.
Search Algorithm Classes:

LinearSearch:

Implements linear search, traversing the array sequentially until the target element is found.
BinarySearch:

Implements binary search, applicable to sorted arrays, dividing the search space in half at each step.
HashingSearch:

Implements a simple hashing search by sequentially checking each element in the array.
InterpolationSearch:

Implements interpolation search, applicable to uniformly distributed sorted arrays, estimating the probable position of the target element.
ExponentialSearch:

Combines binary search and linear search, initially performing binary search with exponentially increasing bounds.
JumpSearch:

Implements jump search, requiring a sorted array, jumping a fixed number of steps ahead to find the target element.
FibonacciSearch:

Implements Fibonacci search, similar to binary search but dividing the array into Fibonacci numbers.
TernarySearch:

Implements ternary search, dividing the search space into three parts instead of two.
Display Method (displaySearchResult):

Displays the result of each search algorithm, indicating whether the target element was found and at which index.
The program is organized with each search algorithm placed in its own class, promoting modularity and readability. It demonstrates various techniques for efficient searching in sorted arrays, catering to different scenarios and requirements.

*/



import java.util.Arrays;

public class SearchAlgorithms {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};

        int targetLinear = 13;
        int targetBinary = 7;
        int targetHashing = 17;
        int targetInterpolation = 5;
        int targetExponential = 21;
        int targetJump = 9;
        int targetFibonacci = 3;
        int targetTernary = 15;

        System.out.println("Original Sorted Array: " + Arrays.toString(sortedArray));

        // Linear Search
        int linearSearchResult = LinearSearch.search(sortedArray, targetLinear);
        displaySearchResult("Linear Search", targetLinear, linearSearchResult);

        // Binary Search
        int binarySearchResult = BinarySearch.search(sortedArray, targetBinary);
        displaySearchResult("Binary Search", targetBinary, binarySearchResult);

        // Hashing (Hash Table Search)
        int hashingSearchResult = HashingSearch.search(sortedArray, targetHashing);
        displaySearchResult("Hashing (Hash Table Search)", targetHashing, hashingSearchResult);

        // Interpolation Search
        int interpolationSearchResult = InterpolationSearch.search(sortedArray, targetInterpolation);
        displaySearchResult("Interpolation Search", targetInterpolation, interpolationSearchResult);

        // Exponential Search
        int exponentialSearchResult = ExponentialSearch.search(sortedArray, targetExponential);
        displaySearchResult("Exponential Search", targetExponential, exponentialSearchResult);

        // Jump Search
        int jumpSearchResult = JumpSearch.search(sortedArray, targetJump);
        displaySearchResult("Jump Search", targetJump, jumpSearchResult);

        // Fibonacci Search
        int fibonacciSearchResult = FibonacciSearch.search(sortedArray, targetFibonacci);
        displaySearchResult("Fibonacci Search", targetFibonacci, fibonacciSearchResult);

        // Ternary Search
        int ternarySearchResult = TernarySearch.search(sortedArray, targetTernary);
        displaySearchResult("Ternary Search", targetTernary, ternarySearchResult);
    }

    static void displaySearchResult(String algorithm, int target, int result) {
        System.out.println(algorithm + " for target " + target + ":");
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found");
        }
        System.out.println();
    }
}

// Linear Search
class LinearSearch {
    // Time Complexity: O(n) - Linear time complexity as it traverses the array sequentially.
    static int search(int[] array, int target) {
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

// Binary Search
class BinarySearch {
    // Time Complexity: O(log n) - Logarithmic time complexity as it divides the search space in half at each step.
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

// Hashing (Hash Table Search)
class HashingSearch {
    // Time Complexity: O(n) - Linear time complexity in the worst case, depending on the hash function and collision resolution.
    static int search(int[] array, int target) {
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

// Interpolation Search
class InterpolationSearch {
    // Time Complexity: O(log log n) - Expected logarithmic time complexity for uniformly distributed sorted arrays.
    static int search(int[] array, int target) {
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

// Exponential Search
class ExponentialSearch {
    // Time Complexity: O(log n) - Logarithmic time complexity, similar to binary search.
    static int search(int[] array, int target) {
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

// Jump Search
class JumpSearch {
    // Time Complexity: O(√n) - Square root of the array size, making it more efficient than linear search.
    static int search(int[] array, int target) {
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

// Fibonacci Search
class FibonacciSearch {
    // Time Complexity: O(log n) - Logarithmic time complexity, similar to binary search.
    static int search(int[] array, int target) {
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

// Ternary Search
class TernarySearch {
    // Time Complexity: O(log3 n) - Logarithmic time complexity, dividing the search space into three parts.
    static int search(int[] array, int target) {
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
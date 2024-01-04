import java.util.Arrays;

// Import individual search algorithm classes
import com.example.search.BinarySearch;
import com.example.search.ExponentialSearch;
import com.example.search.FibonacciSearch;
import com.example.search.HashingSearch;
import com.example.search.InterpolationSearch;
import com.example.search.JumpSearch;
import com.example.search.LinearSearch;
import com.example.search.TernarySearch;

public class MainProgram {
    public static void main(String[] args) {
        int[] sortedArray = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21 };

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

    // display search result
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

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

        measureSearchTime("Linear Search", () -> LinearSearch.search(sortedArray, targetLinear));
        measureSearchTime("Binary Search", () -> BinarySearch.search(sortedArray, targetBinary));
        measureSearchTime("Hashing (Hash Table Search)", () -> HashingSearch.search(sortedArray, targetHashing));
        measureSearchTime("Interpolation Search", () -> InterpolationSearch.search(sortedArray, targetInterpolation));
        measureSearchTime("Exponential Search", () -> ExponentialSearch.search(sortedArray, targetExponential));
        measureSearchTime("Jump Search", () -> JumpSearch.search(sortedArray, targetJump));
        measureSearchTime("Fibonacci Search", () -> FibonacciSearch.search(sortedArray, targetFibonacci));
        measureSearchTime("Ternary Search", () -> TernarySearch.search(sortedArray, targetTernary));
    }

    // Measure search time
    static void measureSearchTime(String algorithm, SearchFunction searchFunction) {
        long startTime = System.currentTimeMillis();
        int result = searchFunction.search();
        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;
        displaySearchResult(algorithm, result);
        System.out.println("Execution Time: " + executionTime + " milliseconds");
        System.out.println();
    }

    // Functional interface for search functions
    interface SearchFunction {
        int search();
    }

    // display search result
    static void displaySearchResult(String algorithm, int result) {
        System.out.println(algorithm + ":");
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements to generate: ");
        int size = scanner.nextInt();

        int[] sortedArray = generateRandomArray(size);

        int targetLinear = 68;
        int targetBinary = 87;
        int targetHashing = 6;
        int targetInterpolation = 45;
        int targetExponential = 28;
        int targetJump = 91;
        int targetFibonacci = 34;
        int targetTernary = 78;

        /* COMMENT OUT or UNCOMMENT if you don't want to view the Generated Array */
        // System.out.println("Original Sorted Array: " + Arrays.toString(sortedArray));

        measureSearchTime("Linear Search", () -> LinearSearch.search(sortedArray, targetLinear));
        measureSearchTime("Binary Search", () -> BinarySearch.search(sortedArray, targetBinary));
        measureSearchTime("Hashing (Hash Table Search)", () -> HashingSearch.search(sortedArray, targetHashing));
        measureSearchTime("Interpolation Search", () -> InterpolationSearch.search(sortedArray, targetInterpolation));
        measureSearchTime("Exponential Search", () -> ExponentialSearch.search(sortedArray, targetExponential));
        measureSearchTime("Jump Search", () -> JumpSearch.search(sortedArray, targetJump));
        measureSearchTime("Fibonacci Search", () -> FibonacciSearch.search(sortedArray, targetFibonacci));
        measureSearchTime("Ternary Search", () -> TernarySearch.search(sortedArray, targetTernary));

        scanner.close();
    }

    // Generate a random array of size elements with values between 1 and 100
    static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100) + 1; // Generates a random number between 1 and 100
        }

        /* COMMENT OUT or UNCOMMENT if you don't want to view the Generated Array */
        // System.out.println("Generated Array: " + Arrays.toString(array));

        return array;
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

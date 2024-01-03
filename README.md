# SearchAlgorithms

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

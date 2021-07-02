package com.example.dsaready.data

import com.example.dsaready.R
import com.example.dsaready.model.Problem
import com.example.dsaready.model.TextCodeBlock
import com.example.dsaready.model.Topic

object Database {

    val introduction_sorting = "A sorting algorithm is an algorithm that puts elements of a list in a certain order. The most frequently used orders are numerical order and lexicographical order. Efficient sorting is important for optimizing the efficiency of other algorithms (such as search and merge algorithms) that require input data to be in sorted lists."

    val introduction_sample = "This is sample introduction text."

    val theory_sorting = listOf(
            TextCodeBlock("Introduction",
                    "In computer science, a sorting algorithm is an algorithm that puts elements of a list in a certain order. The most frequently used orders are numerical order and lexicographical order. Efficient sorting is important for optimizing the efficiency of other algorithms (such as search and merge algorithms) that require input data to be in sorted lists.",
                    ""),
            TextCodeBlock("In-place Sorting and Not-in-place Sorting",
                    "Sorting algorithms may require some extra space for comparison and temporary storage of few data elements. These algorithms do not require any extra space and sorting is said to happen in-place, or for example, within the array itself. This is called in-place sorting. Bubble sort is an example of in-place sorting.\n" +
                            "\n" +
                            "However, in some sorting algorithms, the program requires space which is more than or equal to the elements being sorted. Sorting which uses equal or more space is called not-in-place sorting. Merge-sort is an example of not-in-place sorting.",
                    ""),
            TextCodeBlock("Stable and Not Stable Sorting",
                    "If a sorting algorithm, after sorting the contents, does not change the sequence of similar content in which they appear, it is called stable sorting. \n If a sorting algorithm, after sorting the contents, changes the sequence of similar content in which they appear, it is called unstable sorting. \n Stability of an algorithm matters when we wish to maintain the sequence of original elements, like in a tuple for example.",
                    ""),
            TextCodeBlock("Types of Sorting Algorithms",
                    "1. Quick Sort\n" +
                            "2. Bubble Sort\n" +
                            "3. Merge Sort\n" +
                            "4. Insertion Sort\n" +
                            "5. Selection Sort\n" +
                            "6. Heap Sort\n" +
                            "7. Radix Sort\n" +
                            "8. Bucket Sort",
                    "")
    )

    val problems_sorting = listOf(
            Problem(
                    "Insertion Sort Algorithm",
                    "",
                    "",
                    listOf(
                            TextCodeBlock(
                                    "Insertion Sort Overview",
                                    "Insertion sort is a stable, in-place sorting algorithm that builds the final sorted array one item at a time. It is not the very best in terms of performance but more efficient traditionally than most other simple O(n2) algorithms such as selection sort or bubble sort. Insertion sort is also used in Hybrid sort, which combines different sorting algorithms to improve performance.\n" +
                                            "\n" +
                                            "It is also a well known online algorithm since it can sort a list as it receives it. In all other algorithms, we need all elements to be provided to the sorting algorithm before applying it. But an insertion sort allows us to start with a partial set of elements, sorts it (called a partially sorted set). If we want, we can insert more elements (these are the new set of elements that were not in memory when the sorting started) and sorts them. In the real world, data to be sorted is usually not static, rather dynamic. If even one additional element is inserted during the sorting process, other algorithms don’t respond easily. But only insertion sort algorithm is not interrupted and can respond well with the additional element.",
                                    ""),
                            TextCodeBlock("How Insertion Sort works?",
                                    "The idea is to divide the array into two subsets – sorted subset and unsorted subset. Initially, a sorted subset consists of only one first element at index 0. Then for each iteration, insertion sort removes the next element from the unsorted subset, finds the location it belongs within the sorted subset and inserts it there. It repeats until no input elements remain.",
                                    ""),
                            TextCodeBlock("Insertion Sort Iterative Implementation",
                                    "",
                                    "#include <stdio.h>\n" +
                                            " \n" +
                                            "// Function to perform insertion sort on `arr[]`\n" +
                                            "void insertionSort(int arr[], int n)\n" +
                                            "{\n" +
                                            "    // start from the second element (the element at index 0\n" +
                                            "    // is already sorted)\n" +
                                            "    for (int i = 1; i < n; i++)\n" +
                                            "    {\n" +
                                            "        int value = arr[i];\n" +
                                            "        int j = i;\n" +
                                            " \n" +
                                            "        // find index `j` within the sorted subset `arr[0…i-1]`\n" +
                                            "        // where element `arr[i]` belongs\n" +
                                            "        while (j > 0 && arr[j - 1] > value)\n" +
                                            "        {\n" +
                                            "            arr[j] = arr[j - 1];\n" +
                                            "            j--;\n" +
                                            "        }\n" +
                                            " \n" +
                                            "        // note that the subarray `arr[j…i-1]` is shifted to\n" +
                                            "        // the right by one position, i.e., `arr[j+1…i]`\n" +
                                            " \n" +
                                            "        arr[j] = value;\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Function to print `n` elements of array `arr`\n" +
                                            "void printArray(int arr[], int n)\n" +
                                            "{\n" +
                                            "    for (int i = 0; i < n; i++) {\n" +
                                            "        printf(\"%d \", arr[i]);\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main(void)\n" +
                                            "{\n" +
                                            "    int arr[] = { 3, 8, 5, 4, 1, 9, -2 };\n" +
                                            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
                                            " \n" +
                                            "    insertionSort(arr, n);\n" +
                                            " \n" +
                                            "    // print the sorted array\n" +
                                            "    printArray(arr, n);\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n" +
                                            "// Output: -2 1 3 4 5 8 9"),
                            TextCodeBlock("Insertion Sort Recursive Implementation",
                                    "",
                                    "#include <stdio.h>\n" +
                                            " \n" +
                                            "// Recursive function to perform insertion sort on subarray `arr[i…n]`\n" +
                                            "void insertionSort(int arr[], int i, int n)\n" +
                                            "{\n" +
                                            "    int value = arr[i];\n" +
                                            "    int j = i;\n" +
                                            " \n" +
                                            "    // find index `j` within the sorted subset `arr[0…i-1]`\n" +
                                            "    // where element `arr[i]` belongs\n" +
                                            "    while (j > 0 && arr[j - 1] > value)\n" +
                                            "    {\n" +
                                            "        arr[j] = arr[j - 1];\n" +
                                            "        j--;\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    arr[j] = value;\n" +
                                            " \n" +
                                            "    // note that the subarray `arr[j…i-1]` is shifted to\n" +
                                            "    // the right by one position, i.e., `arr[j+1…i]`\n" +
                                            " \n" +
                                            "    if (i + 1 <= n) {\n" +
                                            "        insertionSort(arr, i + 1, n);\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Function to print `n` elements of array `arr`\n" +
                                            "void printArray(int arr[], int n)\n" +
                                            "{\n" +
                                            "    for (int i = 0; i < n; i++) {\n" +
                                            "        printf(\"%d \", arr[i]);\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main(void)\n" +
                                            "{\n" +
                                            "    int arr[] = { 3, 8, 5, 4, 1, 9, -2 };\n" +
                                            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
                                            " \n" +
                                            "    // start from the second element (the element at index 0\n" +
                                            "    // is already sorted)\n" +
                                            "    insertionSort(arr, 1, n - 1);\n" +
                                            " \n" +
                                            "    // print the sorted array\n" +
                                            "    printArray(arr, n);\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "} \n \n" +
                                            "// Output: -2 1 3 4 5 8 9"),
                            TextCodeBlock("Insertion Sort Performance",
                                    "The worst-case time complexity of insertion sort is O(n2), where n is the size of the input. The worst case happens when the array is reverse sorted. The best-case time complexity of insertion sort is O(n). The best case happens when the array is already sorted. " +
                                            "The auxiliary space used by the iterative version is O(1) and O(n) by the recursive version for the call stack.\n",
                                    "")
                    )
            ),
            Problem(
                    "Selection Sort Algorithm",
                    "",
                    "",
                    listOf(
                            TextCodeBlock("Selection Sort Overview",
                                    "Selection sort is an unstable, in-place sorting algorithm known for its simplicity. It has performance advantages over more complicated algorithms in certain situations, particularly where the auxiliary memory is limited. It can be implemented as a stable sort and requires O(n2) time to sort n items, making it inefficient to use on large lists. Among simple average-case O(n2) algorithms, selection sort almost always outperforms bubble sort and generally performs worse than the insertion sort. \n" +
                                            "The biggest advantage of using a selection sort is that it does a maximum of n swaps (memory write). The insertion sort, on the other hand, does O(n2) number of writes. This can be critical if memory-write operation is significantly more expensive than memory-read operation, such as flash memory, where every write lessens the memory’s lifespan.\n",
                                    ""),
                            TextCodeBlock("How Selection Sort works?",
                                    "The idea is to divide the array into two subsets – sorted subset and unsorted subset. Initially, the sorted subset is empty, and the unsorted subset is the entire input list. The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element in the unsorted subset, swapping it with the leftmost unsorted element (putting it in sorted order), and moving the subset boundaries one element to the right.",
                                    ""),
                            TextCodeBlock("Selection Sort Iterative Implementation",
                                    "",
                                    "#include <stdio.h>\n" +
                                            " \n" +
                                            "// Utility function to swap values at two indices in an array\n" +
                                            "void swap(int arr[], int i, int j)\n" +
                                            "{\n" +
                                            "    int temp = arr[i];\n" +
                                            "    arr[i] = arr[j];\n" +
                                            "    arr[j] = temp;\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Function to perform selection sort on `arr[]`\n" +
                                            "void selectionSort(int arr[], int n)\n" +
                                            "{\n" +
                                            "    // run `n-1` times\n" +
                                            "    for (int i = 0; i < n - 1; i++)\n" +
                                            "    {\n" +
                                            "        // find the minimum element in the unsorted subarray `[i…n-1]`\n" +
                                            "        // and swap it with `arr[i]`\n" +
                                            "        int min = i;\n" +
                                            " \n" +
                                            "        for (int j = i + 1; j < n; j++)\n" +
                                            "        {\n" +
                                            "            // if `arr[j]` is less, then it is the new minimum\n" +
                                            "            if (arr[j] < arr[min]) {\n" +
                                            "                min = j;    // update the index of minimum element\n" +
                                            "            }\n" +
                                            "        }\n" +
                                            " \n" +
                                            "        // swap the minimum element in subarray `arr[i…n-1]` with `arr[i]`\n" +
                                            "        swap(arr, min, i);\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Function to print `n` elements of array `arr`\n" +
                                            "void printArray(int arr[], int n)\n" +
                                            "{\n" +
                                            "    for (int i = 0; i < n; i++) {\n" +
                                            "        printf(\"%d \", arr[i]);\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main(void)\n" +
                                            "{\n" +
                                            "    int arr[] = { 3, 5, 8, 4, 1, 9, -2 };\n" +
                                            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
                                            " \n" +
                                            "    selectionSort(arr, n);\n" +
                                            "    printArray(arr, n);\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n"+
                                            "// Output: -2 1 3 4 5 8 9"),
                            TextCodeBlock("Selection Sort Recursive Implementation",
                                    "",
                                    "#include <stdio.h>\n" +
                                            " \n" +
                                            "// Utility function to swap values at two indices in an array\n" +
                                            "void swap(int arr[], int i, int j)\n" +
                                            "{\n" +
                                            "    int temp = arr[i];\n" +
                                            "    arr[i] = arr[j];\n" +
                                            "    arr[j] = temp;\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Recursive function to perform selection sort on subarray `arr[i…n-1]`\n" +
                                            "void selectionSort(int arr[], int i, int n)\n" +
                                            "{\n" +
                                            "    // find the minimum element in the unsorted subarray `[i…n-1]`\n" +
                                            "    // and swap it with `arr[i]`\n" +
                                            "    int min = i;\n" +
                                            "    for (int j = i + 1; j < n; j++)\n" +
                                            "    {\n" +
                                            "        // if `arr[j]` is less, then it is the new minimum\n" +
                                            "        if (arr[j] < arr[min]) {\n" +
                                            "            min = j;    // update the index of minimum element\n" +
                                            "        }\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // swap the minimum element in subarray `arr[i…n-1]` with `arr[i]`\n" +
                                            "    swap(arr, min, i);\n" +
                                            " \n" +
                                            "    if (i + 1 < n) {\n" +
                                            "        selectionSort(arr, i + 1, n);\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Function to print `n` elements of array `arr`\n" +
                                            "void printArray(int arr[], int n)\n" +
                                            "{\n" +
                                            "    for (int i = 0; i < n; i++) {\n" +
                                            "        printf(\"%d \", arr[i]);\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main()\n" +
                                            "{\n" +
                                            "    int arr[] = { 3, 5, 8, 4, 1, 9, -2 };\n" +
                                            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
                                            " \n" +
                                            "    selectionSort(arr, 0, n);\n" +
                                            "    printArray(arr, n);\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n"+
                                            "// Output: -2 1 3 4 5 8 9"),
                            TextCodeBlock("Selection Sort Performance",
                                    "Both the worst-case and best-case time complexity of selection sort is O(n2), where n is the input size, and it doesn’t require any extra space.\n The time complexity of the selection sort recursive algorithm remains the same as the iterative version. However, the auxiliary space used by the recursive version is O(n) for the call stack.","")
                    )
            ),
            Problem(
                    "Bubble Sort Algorithm",
                    "",
                    "",
                    listOf(
                            TextCodeBlock(
                                    "Bubble Sort Overview",
                                    "Bubble sort is a stable, in-place sorting algorithm named for smaller or larger elements “bubble” to the top of the list. Although the algorithm is simple, it is too slow and impractical for most problems even compared to insertion sort, and is not recommended for large input. The only significant advantage that bubble sort has over most other implementations, even Quicksort, but not insertion sort, is the ability to detect if the list is already sorted. When the list is already sorted (best-case), bubble sort runs in linear time.",
                                    ""
                            ),
                            TextCodeBlock(
                                    "How Bubble Sort works?",
                                    "Each pass of bubble sort steps through the list to be sorted compares each pair of adjacent items and swaps them if they are in the wrong order. At the end of each pass, the next largest element will “Bubble” up to its correct position. These passes through the list are repeated until no swaps are needed, which indicates that the list is sorted. In the worst-case, we might end up making an n-1 pass, where n is the input size.",
                                    ""
                            ),
                            TextCodeBlock(
                                    "Bubble Sort Iterative Implementation",
                                    "The implementation can be easily optimized by observing that the n'th pass finds the n'th largest element and puts it in its final place. So, the inner loop can avoid looking at the last n-1 items when running for the n'th time. Another optimization is to stop the algorithm when the inner loop didn’t do any swap.",
                                    "#include <stdio.h>\n" +
                                            " \n" +
                                            "// Utility function to swap values at two indices in an array\n" +
                                            "void swap(int arr[], int i, int j)\n" +
                                            "{\n" +
                                            "    int temp = arr[i];\n" +
                                            "    arr[i] = arr[j];\n" +
                                            "    arr[j] = temp;\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Function to print `n` elements of array `arr`\n" +
                                            "void printArray(int arr[], int n)\n" +
                                            "{\n" +
                                            "    for (int i = 0; i < n; i++) {\n" +
                                            "        printf(\"%d \", arr[i]);\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Function to perform bubble sort on a given array `arr[]`\n" +
                                            "void bubbleSort(int arr[], int n)\n" +
                                            "{\n" +
                                            "    // `n-1` passes\n" +
                                            "    for (int k = 0; k < n - 1; k++)\n" +
                                            "    {\n" +
                                            "        // last `k` items are already sorted, so the inner loop can\n" +
                                            "        // avoid looking at the last `k` items\n" +
                                            "        for (int i = 0; i < n - 1 - k; i++)\n" +
                                            "        {\n" +
                                            "            if (arr[i] > arr[i + 1]) {\n" +
                                            "                swap(arr, i, i + 1);\n" +
                                            "            }\n" +
                                            "        }\n" +
                                            " \n" +
                                            "        // the algorithm can be terminated if the inner loop didn't do any swap\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main(void)\n" +
                                            "{\n" +
                                            "    int arr[] = { 3, 5, 8, 4, 1, 9, -2 };\n" +
                                            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
                                            " \n" +
                                            "    bubbleSort(arr, n);\n" +
                                            "    printArray(arr, n);\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n"+
                                            "// Output: -2 1 3 4 5 8 9"),
                            TextCodeBlock(
                                    "Bubble Sort Recursive Implementation",
                                    "",
                                    "#include <stdio.h>\n" +
                                            " \n" +
                                            "// Utility function to swap values at two indices in an array\n" +
                                            "void swap(int arr[], int i, int j)\n" +
                                            "{\n" +
                                            "    int temp = arr[i];\n" +
                                            "    arr[i] = arr[j];\n" +
                                            "    arr[j] = temp;\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Function to print `n` elements of array `arr`\n" +
                                            "void printArray(int arr[], int n)\n" +
                                            "{\n" +
                                            "    for (int i = 0; i < n; i++) {\n" +
                                            "        printf(\"%d \", arr[i]);\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Recursive function to perform bubble sort on subarray `arr[i…n]`\n" +
                                            "void bubbleSort(int arr[], int n)\n" +
                                            "{\n" +
                                            "    for (int i = 0; i < n - 1; i++)\n" +
                                            "    {\n" +
                                            "        if (arr[i] > arr[i + 1]) {\n" +
                                            "            swap(arr, i, i + 1);\n" +
                                            "        }\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    if (n - 1 > 1) {\n" +
                                            "        bubbleSort(arr, n - 1);\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main(void)\n" +
                                            "{\n" +
                                            "    int arr[] = { 3, 5, 8, 4, 1, 9, -2 };\n" +
                                            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
                                            " \n" +
                                            "    bubbleSort(arr, n);\n" +
                                            "    printArray(arr, n);\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n"+
                                            "// Output: -2 1 3 4 5 8 9"),
                            TextCodeBlock("Bubble Sort Performance",
                                    "The worst-case time complexity of bubble sort is O(n2), where n is the size of the input. The worst case happens when the array is reverse sorted. The best-case time complexity of bubble sort is O(n). The best case happens when the array is already sorted, and the algorithm is modified to stop running when the inner loop didn’t do any swap. The optimized implementation can be seen here. \nThe auxiliary space used by the iterative version is O(1) and O(n) by the recursive version for the call stack.","")
                    )
            ),
            Problem(
                    "Merge Sort Algorithm",
                    "",
                    "",
                    listOf(
                            TextCodeBlock(
                                    "Merge Sort Overview",
                                    "Merge sort is an efficient sorting algorithm that produces a stable sort, which means that if two elements have the same value, they hold the same relative position in the sorted sequence as they did in the input. In other words, the relative order of elements with equal values is preserved in the sorted sequence. Merge sort is a comparison sort, which means that it can sort any input for which a less-than relation is defined.",
                                    ""
                            ),
                            TextCodeBlock(
                                    "How Merge sort works?",
                                    "Merge sort is a Divide and Conquer algorithm. Like all divide-and-conquer algorithms, merge sort divides a large array into two smaller subarrays and then recursively sort the subarrays. Basically, two steps are involved in the whole process:\n" +
                                            "\n" +
                                            "Divide the unsorted array into n subarrays, each of size 1 (an array of size 1 is considered sorted). Repeatedly merge subarrays to produce new sorted subarrays until only 1 subarray is left, which would be our sorted array.\n",
                                    ""),
                            TextCodeBlock(
                                    "Merge Sort Implementation",
                                    "",
                                    "#include <stdio.h>\n" +
                                            "#include <stdlib.h>\n" +
                                            "#include <time.h>\n" +
                                            " \n" +
                                            "#define N 15\n" +
                                            " \n" +
                                            "// Merge two sorted subarrays `arr[low … mid]` and `arr[mid+1 … high]`\n" +
                                            "void Merge(int arr[], int aux[], int low, int mid, int high)\n" +
                                            "{\n" +
                                            "    int k = low, i = low, j = mid + 1;\n" +
                                            " \n" +
                                            "    // While there are elements in the left and right runs\n" +
                                            "    while (i <= mid && j <= high)\n" +
                                            "    {\n" +
                                            "        if (arr[i] <= arr[j]) {\n" +
                                            "            aux[k++] = arr[i++];\n" +
                                            "        }\n" +
                                            "        else {\n" +
                                            "            aux[k++] = arr[j++];\n" +
                                            "        }\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // Copy remaining elements\n" +
                                            "    while (i <= mid) {\n" +
                                            "        aux[k++] = arr[i++];\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // No need to copy the second half (since the remaining items\n" +
                                            "    // are already in their correct position in the auxiliary array)\n" +
                                            " \n" +
                                            "    // copy back to the original array to reflect sorted order\n" +
                                            "    for (int i = low; i <= high; i++) {\n" +
                                            "        arr[i] = aux[i];\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Sort array `arr[low…high]` using auxiliary array `aux`\n" +
                                            "void mergesort(int arr[], int aux[], int low, int high)\n" +
                                            "{\n" +
                                            "    // Base case\n" +
                                            "    if (high == low) {        // if run size == 1\n" +
                                            "        return;\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // find midpoint\n" +
                                            "    int mid = (low + ((high - low) >> 1));\n" +
                                            " \n" +
                                            "    // recursively split runs into two halves until run size == 1,\n" +
                                            "    // then merge them and return up the call chain\n" +
                                            " \n" +
                                            "    mergesort(arr, aux, low, mid);          // split/merge left half\n" +
                                            "    mergesort(arr, aux, mid + 1, high);     // split/merge right half\n" +
                                            " \n" +
                                            "    Merge(arr, aux, low, mid, high);        // merge the two half runs.\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Function to check if arr is sorted in ascending order or not\n" +
                                            "int isSorted(int arr[])\n" +
                                            "{\n" +
                                            "    int prev = arr[0];\n" +
                                            "    for (int i = 1; i < N; i++)\n" +
                                            "    {\n" +
                                            "        if (prev > arr[i])\n" +
                                            "        {\n" +
                                            "            printf(\"MergeSort Fails!!\");\n" +
                                            "            return 0;\n" +
                                            "        }\n" +
                                            "        prev = arr[i];\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    return 1;\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Implementation of merge sort algorithm in C\n" +
                                            "int main(void)\n" +
                                            "{\n" +
                                            "    int arr[N], aux[N];\n" +
                                            "    srand(time(NULL));\n" +
                                            " \n" +
                                            "    // generate random input of integers\n" +
                                            "    for (int i = 0; i < N; i++) {\n" +
                                            "        aux[i] = arr[i] = (rand() % 100) - 50;\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // sort array `arr` using auxiliary array `aux`\n" +
                                            "    mergesort(arr, aux, 0, N - 1);\n" +
                                            " \n" +
                                            "    if (isSorted(arr))\n" +
                                            "    {\n" +
                                            "        for (int i = 0; i < N; i++) {\n" +
                                            "            printf(\"%d \", arr[i]);\n" +
                                            "        }\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n"+
                                            "// Output: -50 -41 -34 -23 -21 -11 5 9 10 19 26 33 35 40 49"
                            ),
                            TextCodeBlock(
                                    "Merge Sort Performance",
                                    "The worst-case time complexity of merge sort is O(n.log(n)), where n is the size of the input. \n" +
                                            "The recurrence relation is: T(n) = 2T(n/2) + cn = O(n.log(n)) \n" +
                                            "The recurrence basically summarizes the merge sort algorithm – Sort two lists of half the original list’s size and add the n steps taken to merge the resulting two lists. The auxiliary space required by the merge sort algorithm is O(n) for the call stack.",
                                    "")
                    )
            ),
            Problem(
                    "Quicksort Algorithm",
                    "",
                    "",
                    listOf(
                            TextCodeBlock(
                                    "Quicksort Overview",
                                    "Quicksort is an efficient in-place sorting algorithm, which usually performs about two to three times faster than merge sort and heapsort when implemented well. Quicksort is a comparison sort, meaning that it can sort items of any type for which a less-than relation is defined. In efficient implementations, it is usually not a stable sort. \n" +
                                            "Quicksort, on average, makes O(n.log(n)) comparisons to sort n items. In the worst-case, it makes O(n2) comparisons, though this behavior is very rare.",
                                    ""),
                            TextCodeBlock(
                                    "How Quicksort Works?",
                                    "Quicksort is a Divide and Conquer algorithm. Like all divide-and-conquer algorithms, it first divides a large array into two smaller subarrays and then recursively sort the subarrays. Basically, three steps are involved in the whole process:\n" +
                                            "\n" +
                                            "Pivot selection: Pick an element, called a pivot, from the array (usually the leftmost or the rightmost element of the partition).\n" +
                                            "\n" +
                                            "Partitioning: Reorder the array such that all elements with values less than the pivot come before the pivot. In contrast, all elements with values greater than the pivot come after it. The equal values can go either way. After this partitioning, the pivot is in its final position.\n" +
                                            "\n" +
                                            "Recur: Recursively apply the above steps to the subarray of elements with smaller values than the pivot and separately to the subarray of elements with greater values than the pivot.\n" +
                                            "\n" +
                                            "The base case of the recursion is arrays of size 1, which never need to be sorted. Please note that the pivot selection and partitioning steps can be made in several ways, and the choice of specific implementation schemes significantly affects the algorithm’s performance.",
                                    ""),
                            TextCodeBlock(
                                    "Quicksort Algorithm Implementation",
                                    "",
                                    "#include <iostream>\n" +
                                            "#include <algorithm>\n" +
                                            "using namespace std;\n" +
                                            " \n" +
                                            "// Partition using the Lomuto partition scheme\n" +
                                            "int partition(int a[], int start, int end)\n" +
                                            "{\n" +
                                            "    // Pick the rightmost element as a pivot from the array\n" +
                                            "    int pivot = a[end];\n" +
                                            " \n" +
                                            "    // elements less than the pivot will be pushed to the left of `pIndex`\n" +
                                            "    // elements more than the pivot will be pushed to the right of `pIndex`\n" +
                                            "    // equal elements can go either way\n" +
                                            "    int pIndex = start;\n" +
                                            " \n" +
                                            "    // each time we find an element less than or equal to the pivot, `pIndex`\n" +
                                            "    // is incremented, and that element would be placed before the pivot.\n" +
                                            "    for (int i = start; i < end; i++)\n" +
                                            "    {\n" +
                                            "        if (a[i] <= pivot)\n" +
                                            "        {\n" +
                                            "            swap(a[i], a[pIndex]);\n" +
                                            "            pIndex++;\n" +
                                            "        }\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // swap `pIndex` with pivot\n" +
                                            "    swap (a[pIndex], a[end]);\n" +
                                            " \n" +
                                            "    // return `pIndex` (index of the pivot element)\n" +
                                            "    return pIndex;\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Quicksort routine\n" +
                                            "void quicksort(int a[], int start, int end)\n" +
                                            "{\n" +
                                            "    // base condition\n" +
                                            "    if (start >= end) {\n" +
                                            "        return;\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // rearrange elements across pivot\n" +
                                            "    int pivot = partition(a, start, end);\n" +
                                            " \n" +
                                            "    // recur on subarray containing elements that are less than the pivot\n" +
                                            "    quicksort(a, start, pivot - 1);\n" +
                                            " \n" +
                                            "    // recur on subarray containing elements that are more than the pivot\n" +
                                            "    quicksort(a, pivot + 1, end);\n" +
                                            "}\n" +
                                            " \n" +
                                            "// C++ implementation of the Quicksort algorithm\n" +
                                            "int main()\n" +
                                            "{\n" +
                                            "    int a[] = { 9, -3, 5, 2, 6, 8, -6, 1, 3 };\n" +
                                            "    int n = sizeof(a)/sizeof(a[0]);\n" +
                                            " \n" +
                                            "    quicksort(a, 0, n - 1);\n" +
                                            " \n" +
                                            "    // print the sorted array\n" +
                                            "    for (int i = 0; i < n; i++) {\n" +
                                            "        cout << a[i] << \" \";\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n // Output: -6 -3 1 2 3 5 6 8 9"
                            ),
                            TextCodeBlock(
                                    "Quicksort Performance",
                                    "The worst-case time complexity of Quicksort is O(n2), where n is the size of the input. The worst case happens when the pivot happens to be the smallest or largest element in the list or when all the array elements are equal. This will result in the most unbalanced partition as the pivot divides the array into two subarrays of sizes 0 and n-1. If this repeatedly happens in every partition (say, we have sorted array), then each recursive call processes a list of size one less than the previous list, resulting in O(n2) time. \n" +
                                            "\n" +
                                            "T(n) = T(n-1) + cn = O(n²) (Note – partition takes O(n) time that accounts for cn)   \n" +
                                            "\n" +
                                            "The best-case time complexity of Quicksort is O(n.log(n)). The best case happens when the pivot divides the array into two nearly equal pieces. Now each recursive call processes a list of half the size. \n" +
                                            "\nT(n) = 2 T(n/2) + cn = O(n.log(n))   \n" +
                                            "The auxiliary space required by the Quicksort algorithm is O(n) for the call stack.",
                                    ""
                            )
                    )
            ),
            Problem(
                    "Inversion count of an array",
                    "Hard",
                    "Amazon Microsoft Adobe Flipkart",
                    listOf(
                            TextCodeBlock("Inversion count of an array",
                                    "Given an array, find the total number of inversions of it. If (i < j) and (A[i] > A[j]), then pair (i, j) is called an inversion of an array A. We need to count all such pairs in the array. For example,\n" +
                                            "\n" +
                                            "Input:  A[] = [1, 9, 6, 4, 5]   Output: The inversion count is 5   There are 5 inversions in the array: (9, 6), (9, 4), (9, 5), (6, 4), (6, 5)\n",
                                    ""),
                            TextCodeBlock(
                                    "Brute-Force Solution",
                                    "A simple solution would be for each array element count all elements less than it to its right and add the count to output. The complexity of this solution is O(n2), where n is the size of the input.",
                                    "#include <stdio.h>\n" +
                                            " \n" +
                                            "// Function to find inversion count of a given array\n" +
                                            "int findInversionCount(int arr[], int n)\n" +
                                            "{\n" +
                                            "    int inversionCount = 0;\n" +
                                            "    for (int i = 0; i < n - 1; i++)\n" +
                                            "    {\n" +
                                            "        for (int j = i + 1; j < n; j++)\n" +
                                            "        {\n" +
                                            "            if (arr[i] > arr[j]) {\n" +
                                            "                inversionCount++;\n" +
                                            "            }\n" +
                                            "        }\n" +
                                            "    }\n" +
                                            "    return inversionCount;\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main()\n" +
                                            "{\n" +
                                            "    int arr[] = { 1, 9, 6, 4, 5 };\n" +
                                            "    int N = sizeof(arr)/sizeof(arr[0]);\n" +
                                            " \n" +
                                            "    printf(\"The inversion count is %d\", findInversionCount(arr, N));\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n //Output: The inversion count is 5"
                            ),
                            TextCodeBlock(
                                    "Using Merge Sort",
                                    "This is a classic problem that can be solved by merge sort algorithm. Basically, for each array element, count all elements more than it to its left and add the count to the output. This whole magic happens inside the merge function of merge sort.\nThe time complexity of the above solution is O(n.log(n)) (same as that of merge sort algorithm), and the auxiliary space used by the program is O(n).",
                                    "#include <stdio.h>\n" +
                                            " \n" +
                                            "// Merge two sorted subarrays `arr[low … mid]` and `arr[mid+1 … high]`\n" +
                                            "int Merge(int arr[], int aux[], int low, int mid, int high)\n" +
                                            "{\n" +
                                            "    int k = low, i = low, j = mid + 1;\n" +
                                            "    int inversionCount = 0;\n" +
                                            " \n" +
                                            "    // while there are elements in the left and right runs\n" +
                                            "    while (i <= mid && j <= high)\n" +
                                            "    {\n" +
                                            "        if (arr[i] <= arr[j]) {\n" +
                                            "            aux[k++] = arr[i++];\n" +
                                            "        }\n" +
                                            "        else {\n" +
                                            "            aux[k++] = arr[j++];\n" +
                                            "            inversionCount += (mid - i + 1);    // NOTE\n" +
                                            "        }\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // copy remaining elements\n" +
                                            "    while (i <= mid) {\n" +
                                            "        aux[k++] = arr[i++];\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    /* no need to copy the second half (since the remaining items\n" +
                                            "       are already in their correct position in the temporary array) */\n" +
                                            " \n" +
                                            "    // copy back to the original array to reflect sorted order\n" +
                                            "    for (int i = low; i <= high; i++) {\n" +
                                            "        arr[i] = aux[i];\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    return inversionCount;\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Sort array `arr[low…high]` using auxiliary array `aux`\n" +
                                            "int MergeSort(int arr[], int aux[], int low, int high)\n" +
                                            "{\n" +
                                            "    // Base case\n" +
                                            "    if (high == low) {        // if run size == 1\n" +
                                            "        return 0;\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // find midpoint\n" +
                                            "    int mid = (low + ((high - low) >> 1));\n" +
                                            "    int inversionCount = 0;\n" +
                                            " \n" +
                                            "    // recursively split runs into two halves until run size == 1,\n" +
                                            "    // then merges them and return up the call chain\n" +
                                            " \n" +
                                            "    // split/merge left half\n" +
                                            "    inversionCount += MergeSort(arr, aux, low, mid);\n" +
                                            " \n" +
                                            "    // split/merge right half\n" +
                                            "    inversionCount += MergeSort(arr, aux, mid + 1, high);\n" +
                                            " \n" +
                                            "    // merge the two half runs\n" +
                                            "    inversionCount += Merge(arr, aux, low, mid, high);\n" +
                                            " \n" +
                                            "    return inversionCount;\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main()\n" +
                                            "{\n" +
                                            "    int arr[] = { 1, 9, 6, 4, 5 };\n" +
                                            " \n" +
                                            "    int N = sizeof(arr)/sizeof(arr[0]);\n" +
                                            " \n" +
                                            "    int aux[N];\n" +
                                            "    for (int i = 0; i < N; i++) {\n" +
                                            "        aux[i] = arr[i];\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // get the inversion count by performing merge sort on arr\n" +
                                            "    printf(\"The inversion count is %d\", MergeSort(arr, aux, 0, N - 1));\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n //Output: The inversion count is 5"
                            )
                    )
            ),
            Problem(
                    "Sort an array based on order defined by another array",
                    "Medium",
                    "Microsoft Amazon",
                    listOf(
                            TextCodeBlock(
                                    "Sort an array based on order defined by another array",
                                    "The elements that are not present in the second array but present in the first array should be appended at the end sorted. The second array can contain some extra elements which are not part of the first array.   For example,\n" +
                                            "\n" +
                                            "Input:   first = [5, 8, 9, 3, 5, 7, 1, 3, 4, 9, 3, 5, 1, 8, 4] second = [3, 5, 7, 2]   Output: [3, 3, 3, 5, 5, 5, 7, 1, 1, 4, 4, 8, 8, 9, 9]",
                                    ""
                            ),
                            TextCodeBlock(
                                    "Using Hashing",
                                    "The idea is to count the frequency of each element of the first array and store it in a hash table. Now for each element of the second array, check if the element is present on the map or not. If it is present on the map, print the element n number of times, where n is the frequency of that element in the first array. We also remove that element from the map so that we are only left with only present elements in the first array (but not present in the second array). To append them at the end, they need to be sorted. \n" +
                                            "\n" +
                                            "Note that keys are already ordered in std::map or TreeMap, but we get O(log(n)) insertion and retrieval time. If we use std::unordered_map or HashMap, we get O(1) insertion and retrieval time, but will require sorting since its keys are unordered.\n\nThe time complexity of the above solution is O(m.log(m) + n), where m and n are the total number of elements in the first and second array, respectively.",
                                    "#include <iostream>\n" +
                                            "#include <unordered_map>\n" +
                                            "#include <algorithm>\n" +
                                            "using namespace std;\n" +
                                            " \n" +
                                            "void customSort(int first[], int second[], int m, int n)\n" +
                                            "{\n" +
                                            "    // map to store the frequency of each element of the first array\n" +
                                            "    unordered_map<int, int> freq;\n" +
                                            " \n" +
                                            "    // find the frequency of each element of the first array and\n" +
                                            "    // store it in a map\n" +
                                            "    for (int i = 0; i < m; i++) {\n" +
                                            "        freq[first[i]]++;\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // Note that once we have the frequencies of all elements of\n" +
                                            "    // the first array, we can overwrite elements of the first array\n" +
                                            " \n" +
                                            "    int index = 0;\n" +
                                            " \n" +
                                            "    // do for every element of the second array\n" +
                                            "    for (int i = 0; i < n; i++)\n" +
                                            "    {\n" +
                                            "        // If the current element is present on the map, print it `n` times\n" +
                                            "        // where `n` is the frequency of that element in the first array\n" +
                                            "        while (freq[second[i]])\n" +
                                            "        {\n" +
                                            "            first[index++] = second[i];\n" +
                                            "            freq[second[i]]--;\n" +
                                            "        }\n" +
                                            " \n" +
                                            "        // erase the element from the map\n" +
                                            "        freq.erase(second[i]);\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // Now we are left with elements only present in the first array,\n" +
                                            "    // but not in the second array.\n" +
                                            " \n" +
                                            "    // Sort the remaining elements present on the map (Note that the keys are\n" +
                                            "    // already sorted if we use `std::map`)\n" +
                                            " \n" +
                                            "    int i = index;\n" +
                                            "    for (auto it = freq.begin(); it != freq.end(); it++)\n" +
                                            "    {\n" +
                                            "        while (it->second--) {\n" +
                                            "            first[index++] = (it->first);\n" +
                                            "        }\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // sort the remaining elements\n" +
                                            "    sort(first + i, first + index);\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Utility function to print the first `n` elements of an array `arr`\n" +
                                            "void printArray(int arr[], int n)\n" +
                                            "{\n" +
                                            "    for (int i = 0; i < n; i++) {\n" +
                                            "        cout << arr[i] << \" \";\n" +
                                            "    }\n" +
                                            "    cout << endl;\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main()\n" +
                                            "{\n" +
                                            "    int first[] = { 5, 8, 9, 3, 5, 7, 1, 3, 4, 9, 3, 5, 1, 8, 4 };\n" +
                                            "    int second[] = { 3, 5, 7, 2 };\n" +
                                            " \n" +
                                            "    int m = sizeof(first) / sizeof(first[0]);\n" +
                                            "    int n = sizeof(second) / sizeof(second[0]);\n" +
                                            " \n" +
                                            "    customSort(first, second, m, n);\n" +
                                            " \n" +
                                            "    cout << \"The array after sorting is \";\n" +
                                            "    printArray(first, m);\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n" +
                                            "\n\n//Output: The array after sorting is 3 3 3 5 5 5 7 1 1 4 4 8 8 9 9"
                            )
                    )
            )
    )

    val theory_array = listOf(
            TextCodeBlock(
                    "Introduction to Arrays",
                    "An array is a collection of items stored at contiguous memory locations. The idea is to store multiple items of the same type together.\n\n" +
                            "In C language, array has a fixed size meaning once the size is given to it, it cannot be changed i.e. you can’t shrink it neither can you expand it. The reason was that for expanding, if we change the size we can’t be sure ( it’s not possible every time) that we get the next memory location to us as free. The shrinking will not work because the array, when declared, gets memory statically allocated, and thus compiler is the only one can destroy it.",
                    ""
            ),
            TextCodeBlock(
                    "Types of indexing in an array",
                    "0 (zero-based indexing): The first element of the array is indexed by a subscript of 0.\n" +
                            "1 (one-based indexing): The second element of the array is indexed by the subscript of 1.\n" +
                            "n (n-based indexing): The base index of an array can be freely chosen. Usually, programming languages allowing n-based indexing also allow negative index values, and other scalar data types like enumerations, or characters may be used as an array index.",
                    "#include <stdio.h>\n" +
                            "\n" +
                            "int main()\n" +
                            "{\n" +
                            "\n" +
                            "\t// Creating an integer array named arr of size 10.\n" +
                            "\tint arr[10];\n" +
                            "\t// accessing element at 0 index and setting its value\n" +
                            "\t// to 5.\n" +
                            "\tarr[0] = 5;\n" +
                            "\t// access and print value at 0 index we get the output\n" +
                            "\t// as 5.\n" +
                            "\tprintf(\"%d\", arr[0]);\n" +
                            "\n" +
                            "\treturn 0;\n" +
                            "}\n //Output: 5"
            ),
            TextCodeBlock(
                    "Advantages of using arrays",
                    "Arrays allow random access to elements. This makes accessing elements by position faster.\n" +
                            "Arrays have better cache locality that makes a pretty big difference in performance.\n" +
                            "Arrays represent multiple data items of the same type using a single name.",""
            ),
            TextCodeBlock(
                    "Disadvantages of using arrays",
                    "You can’t change the size i.e. once you have declared the array you can’t change its size because of static memory allocation. Here Insertion(s) and deletion(s) are difficult as the elements are stored in consecutive memory locations and the shifting operation is costly too.",""
            ),
            TextCodeBlock(
                    "Applications on Array",
                    "Array stores data elements of the same data type.\n" +
                            "Arrays can be used for CPU scheduling.\n" +
                            "Used to Implement other data structures like Stacks, Queues, Heaps, Hash tables, etc.",
                    ""
            )
    )

    val problems_array = listOf(
            Problem(
                    "Find a pair with the given sum in an array",
                    "Easy",
                    "Flipkart MorganStanley Amazon Microsoft",
                    listOf(
                            TextCodeBlock(
                                    "Find a pair with the given sum in an array",
                                    "Given an unsorted integer array, find a pair with the given sum in it. For example,\n" +
                                            "\n" +
                                            "Input:   arr = [8, 7, 2, 5, 3, 1] sum = 10   Output:   Pair found (8, 2) or Pair found (7, 3)     \n" +
                                            "\n" +
                                            "Input:   arr = [5, 2, 6, 8, 1, 9] sum = 12   Output: Pair not found\n" +
                                            "\n" +
                                            "There are several methods to solve this problem using brute-force, sorting, and hashing.",""
                            ),
                            TextCodeBlock(
                                    "Using Brute-Force",
                                    "A naive solution is to consider every pair in the given array and return if the desired sum is found. O(n2) Solution.",
                                    "#include <stdio.h>\n" +
                                            " \n" +
                                            "// Naive method to find a pair in an array with a given sum\n" +
                                            "void findPair(int arr[], int n, int sum)\n" +
                                            "{\n" +
                                            "    // consider each element except the last\n" +
                                            "    for (int i = 0; i < n - 1; i++)\n" +
                                            "    {\n" +
                                            "        // start from the i'th element until the last element\n" +
                                            "        for (int j = i + 1; j < n; j++)\n" +
                                            "        {\n" +
                                            "            // if the desired sum is found, print it\n" +
                                            "            if (arr[i] + arr[j] == sum)\n" +
                                            "            {\n" +
                                            "                printf(\"Pair found (%d, %d)\", arr[i], arr[j]);\n" +
                                            "                return;\n" +
                                            "            }\n" +
                                            "        }\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // we reach here if the pair is not found\n" +
                                            "    printf(\"Pair not found\");\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main(void)\n" +
                                            "{\n" +
                                            "    int arr[] = { 8, 7, 2, 5, 3, 1 };\n" +
                                            "    int sum = 10;\n" +
                                            " \n" +
                                            "    int n = sizeof(arr)/sizeof(arr[0]);\n" +
                                            " \n" +
                                            "    findPair(arr, n, sum);\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n//Output: Pair found (8,2)"
                            ),
                            TextCodeBlock(
                                    "Using Sorting",
                                    "The idea is to sort the given array in ascending order and maintain search space by maintaining two indices (low and high) that initially points to two endpoints of the array. Then reduce the search space arr[low…high] at each iteration of the loop by comparing the sum of elements present at indices low and high with the desired sum. Increment low if the sum is less than the expected sum; otherwise, decrement high if the sum is more than the desired sum. If the pair is found, return it. \n\n The time complexity of the above solution is O(n.log(n)) and doesn’t require any extra space.",
                                    "#include <iostream>\n" +
                                            "#include <algorithm>\n" +
                                            "using namespace std;\n" +
                                            " \n" +
                                            "// Function to find a pair in an array with a given sum using sorting\n" +
                                            "void findPair(int arr[], int n, int sum)\n" +
                                            "{\n" +
                                            "    // sort the array in ascending order\n" +
                                            "    sort(arr, arr + n);\n" +
                                            " \n" +
                                            "    // maintain two indices pointing to endpoints of the array\n" +
                                            "    int low = 0;\n" +
                                            "    int high = n - 1;\n" +
                                            " \n" +
                                            "    // reduce the search space `arr[low…high]` at each iteration of the loop\n" +
                                            " \n" +
                                            "    // loop till the search space is exhausted\n" +
                                            "    while (low < high)\n" +
                                            "    {\n" +
                                            "        // sum found\n" +
                                            "        if (arr[low] + arr[high] == sum)\n" +
                                            "        {\n" +
                                            "            cout << \"Pair found (\" << arr[low] << \", \" << arr[high] << \")\" << endl;\n" +
                                            "            return;\n" +
                                            "        }\n" +
                                            " \n" +
                                            "        // increment `low` index if the total is less than the desired sum;\n" +
                                            "        // decrement `high` index if the total is more than the desired sum\n" +
                                            "        (arr[low] + arr[high] < sum)? low++: high--;\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // we reach here if the pair is not found\n" +
                                            "    cout << \"Pair not found\";\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main()\n" +
                                            "{\n" +
                                            "    int arr[] = { 8, 7, 2, 5, 3, 1 };\n" +
                                            "    int sum = 10;\n" +
                                            " \n" +
                                            "    int n = sizeof(arr)/sizeof(arr[0]);\n" +
                                            " \n" +
                                            "    findPair(arr, n, sum);\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n //Output: Pair found (2,8)"
                            ),
                            TextCodeBlock(
                                    "Using Hashing",
                                    "We can use a hash table to solve this problem in linear time. The idea is to insert each array element arr[i] into a map. We also check if difference (arr[i], sum - arr[i]) already exists in the map or not. If the difference is seen before, print the pair and return.\n\nThe time complexity of the above solution is O(n) and requires O(n) extra space, where n is the size of the input.",
                                    "#include <iostream>\n" +
                                            "#include <unordered_map>\n" +
                                            "using namespace std;\n" +
                                            " \n" +
                                            "// Function to find a pair in an array with a given sum using hashing\n" +
                                            "void findPair(int arr[], int n, int sum)\n" +
                                            "{\n" +
                                            "    // create an empty map\n" +
                                            "    unordered_map<int, int> map;\n" +
                                            " \n" +
                                            "    // do for each element\n" +
                                            "    for (int i = 0; i < n; i++)\n" +
                                            "    {\n" +
                                            "        // check if pair `(arr[i], sum - arr[i])` exists\n" +
                                            " \n" +
                                            "        // if the difference is seen before, print the pair\n" +
                                            "        if (map.find(sum - arr[i]) != map.end())\n" +
                                            "        {\n" +
                                            "            cout << \"Pair found (\" << arr[map[sum - arr[i]]] << \", \" << arr[i] << \")\";\n" +
                                            "            return;\n" +
                                            "        }\n" +
                                            " \n" +
                                            "        // store index of the current element in the map\n" +
                                            "        map[arr[i]] = i;\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // we reach here if the pair is not found\n" +
                                            "    cout << \"Pair not found\";\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main()\n" +
                                            "{\n" +
                                            "    int arr[] = { 8, 7, 2, 5, 3, 1 };\n" +
                                            "    int sum = 10;\n" +
                                            " \n" +
                                            "    int n = sizeof(arr)/sizeof(arr[0]);\n" +
                                            " \n" +
                                            "    findPair(arr, n, sum);\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n//Output: Pair found(8,2)"
                            )
                    )
            ),
            Problem(
                    "Sort an array of 0’s, 1’s, and 2’s (Dutch National Flag Problem)",
                    "Medium",
                    "MorganStanley Amazon Microsoft Walmart Adobe Qualcomm",
                    listOf(
                            TextCodeBlock(
                                    "Sort an array of 0’s, 1’s, and 2’s (Dutch National Flag Problem)",
                                    "Given an array containing only 0’s, 1’s, and 2’s, sort it in linear time and using constant space. For example,\n" +
                                            "\n" +
                                            "Input: { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 }   Output:{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2 }\n" +
                                            "\n" +
                                            "A simple solution would be to perform a counting sort. We count the total number of 0’s, 1’s, and 2’s and then put them in the array in their correct order. The time complexity of this solution is O(n), where n is the size of the input. However, this requires two traversals of the array.\n" +
                                            "\n" +
                                            "We can rearrange the array in a single traversal using an alternative linear-time partition routine that separates the values into three groups:\n" +
                                            "\n" +
                                            "The values less than the pivot, The values equal to the pivot, and The values greater than the pivot.\n" +
                                            "\n" +
                                            "To solve this particular problem, consider 1 as a pivot. \n" +
                                            "\n" +
                                            "The time complexity is O(n) and doesn’t require any extra space, where n is the size of the input.",
                                    "#include <stdio.h>\n" +
                                            " \n" +
                                            "// Utility function to swap elements `A[i]` and `A[j]` in an array\n" +
                                            "void swap(int A[], int i, int j)\n" +
                                            "{\n" +
                                            "    int temp = A[i];\n" +
                                            "    A[i] = A[j];\n" +
                                            "    A[j] = temp;\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Linear time partition routine to sort an array containing 0, 1, and 2.\n" +
                                            "// It is similar to 3–way partitioning for the Dutch national flag problem.\n" +
                                            "int threeWayPartition(int A[], int end)\n" +
                                            "{\n" +
                                            "    int start = 0, mid = 0;\n" +
                                            "    int pivot = 1;\n" +
                                            " \n" +
                                            "    while (mid <= end)\n" +
                                            "    {\n" +
                                            "        if (A[mid] < pivot)         // current element is 0\n" +
                                            "        {\n" +
                                            "            swap(A, start, mid);\n" +
                                            "            ++start, ++mid;\n" +
                                            "        }\n" +
                                            "        else if (A[mid] > pivot)    // current element is 2\n" +
                                            "        {\n" +
                                            "            swap(A, mid, end);\n" +
                                            "            --end;\n" +
                                            "        }\n" +
                                            "        else {                      // current element is 1\n" +
                                            "            ++mid;\n" +
                                            "        }\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main()\n" +
                                            "{\n" +
                                            "    int A[] = { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };\n" +
                                            "    int n = sizeof(A)/sizeof(A[0]);\n" +
                                            " \n" +
                                            "    threeWayPartition(A, n - 1);\n" +
                                            " \n" +
                                            "    for (int i = 0; i < n; i++) {\n" +
                                            "        printf(\"%d \", A[i]);\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n//OUtput: 0 0 0 0 0 1 1 1 1 2 2 2"
                            )
                    )
            ),
            Problem(
					"In-place merge two sorted arrays",
					"Medium",
					"Microsoft Amazon GoldmanSachs Linkedin",
					listOf(
						TextCodeBlock(
						"In-place merge two sorted arrays",
						"Given two sorted arrays, X[] and Y[] of size m and n each, merge elements of X[] with elements of array Y[] by maintaining the sorted order, i.e., fill X[] with the first m smallest elements and fill Y[] with remaining elements. Do the conversion in-place and without using any other data structure. \n" +
                                "\n" +
                                "For example, Input: X[] = { 1, 4, 7, 8, 10 } Y[] = { 2, 3, 9 } Output: X[] = { 1, 2, 3, 4, 7 } Y[] = { 8, 9, 10 }\n" +
                                "\n" +
                                "The idea is simple. Consider each array element X[] and ignore it if it is already in the correct order (i.e., the element smallest among all remaining elements); otherwise, swap it with the smallest element, which happens to be the first element of Y[] . After swapping, move the element (now present at Y[0] ) to its correct position in Y[] to maintain the sorted order.\n" +
                                "\n" +
                                "The time complexity is O(m.n), where m is the size of the first array and n is the size of the second array. The solution doesn’t require any extra space. The problem, in fact, can be solved in linear time and constant space.",
                                "#include <iostream>\n" +
                                        "#include <algorithm>\n" +
                                        "using namespace std;\n" +
                                        " \n" +
                                        "// Utility function to print contents of an array\n" +
                                        "void printArray(int arr[], int n)\n" +
                                        "{\n" +
                                        "    for (int i = 0; i < n; i++) {\n" +
                                        "        cout << arr[i] << \" \";\n" +
                                        "    }\n" +
                                        "    cout << endl;\n" +
                                        "}\n" +
                                        " \n" +
                                        "// Function to in-place merge two sorted arrays X[] and Y[]\n" +
                                        "// invariant: `X[]` and `Y[]` are sorted at any point\n" +
                                        "void merge(int X[], int Y[], int m, int n)\n" +
                                        "{\n" +
                                        "    // Consider each element `X[i]` of array `X` and ignore the element if it is\n" +
                                        "    // already in the correct order; otherwise, swap it with the next smaller\n" +
                                        "    // element, which happens to be the first element of `Y`.\n" +
                                        "    for (int i = 0; i < m; i++)\n" +
                                        "    {\n" +
                                        "        // compare the current element of `X[]` with the first element of `Y[]`\n" +
                                        "        if (X[i] > Y[0])\n" +
                                        "        {\n" +
                                        "            swap(X[i], Y[0]);\n" +
                                        "            int first = Y[0];\n" +
                                        " \n" +
                                        "            // move `Y[0]` to its correct position to maintain the sorted\n" +
                                        "            // order of `Y[]`. Note: `Y[1…n-1]` is already sorted\n" +
                                        "            int k;\n" +
                                        "            for (k = 1; k < n && Y[k] < first; k++) {\n" +
                                        "                Y[k - 1] = Y[k];\n" +
                                        "            }\n" +
                                        " \n" +
                                        "            Y[k - 1] = first;\n" +
                                        "        }\n" +
                                        "    }\n" +
                                        "}\n" +
                                        " \n" +
                                        "int main()\n" +
                                        "{\n" +
                                        "    int X[] = { 1, 4, 7, 8, 10 };\n" +
                                        "    int Y[] = { 2, 3, 9 };\n" +
                                        " \n" +
                                        "    int m = sizeof(X) / sizeof(X[0]);\n" +
                                        "    int n = sizeof(Y) / sizeof(Y[0]);\n" +
                                        " \n" +
                                        "    merge(X, Y, m, n);\n" +
                                        " \n" +
                                        "    cout << \"X: \"; printArray(X, m);\n" +
                                        "    cout << \"Y: \"; printArray(Y, n);\n" +
                                        " \n" +
                                        "    return 0;\n" +
                                        "}\n" +
                                        "\n\n //Output: X: 1 2 3 4 7 Y: 8 9 10"
						)
					)
            ),
            Problem(
                    "Maximum Sum Subarray Problem (Kadane’s Algorithm)",
                    "Easy",
                    "Amazon DEShaw Flipkart Microsoft MorganStanley Oracle Samsung Walmart",
                    listOf(
                            TextCodeBlock(
                                    "Maximum Sum Subarray Problem (Kadane’s Algorithm)",
                                    "Given an integer array, find a contiguous subarray within it that has the largest sum. \n" +
                                            "\n" +
                                            "For example, Input: {-2, 1, -3, 4, -1, 2, 1, -5, 4} \n" +
                                            "Output: Subarray with the largest sum is {4, -1, 2, 1} with sum 6. \n" +
                                            "\n" +
                                            "The problem differs from the problem of finding the maximum sum subsequence. Unlike subsequences, subarrays are required to occupy consecutive positions within the original array. \n" +
                                            "\n" +
                                            "We can easily solve this problem in linear time using Kadane’s algorithm. The idea is to maintain a maximum (positive-sum) subarray “ending” at each index of the given array. This subarray is either empty (in which case its sum is zero) or consists of one more element than the maximum subarray ending at the previous index.\n" +
                                            "\n" +
                                            "\n" +
                                            "If the array contains all negative values, the answer is the maximum element. We can easily place this check before continuing to the algorithm. The time complexity is O(n) and doesn’t require any extra space, where n is the size of the input.\n" +
                                            "\n" +
                                            "Because of the way this algorithm uses optimal substructures (the maximum subarray ending at each position is calculated merely from a related but smaller and overlapping subproblem: the maximum subarray ending at the previous position), this algorithm can be viewed as a simple example of dynamic programming.",
                                    "#include <iostream>\n" +
                                            "using namespace std;\n" +
                                            " \n" +
                                            "// Function to find the maximum sum of a contiguous subarray\n" +
                                            "// in a given integer array (handles negative numbers as well)\n" +
                                            "int kadaneNeg(int arr[], int n)\n" +
                                            "{\n" +
                                            "    // stores the maximum sum subarray found so far\n" +
                                            "    int max_so_far = arr[0];\n" +
                                            " \n" +
                                            "    // stores the maximum sum of subarray ending at the current position\n" +
                                            "    int max_ending_here = arr[0];\n" +
                                            " \n" +
                                            "    // traverse the given array\n" +
                                            "    for (int i = 1; i < n; i++)\n" +
                                            "    {\n" +
                                            "        // update the maximum sum of subarray \"ending\" at index `i` (by adding the\n" +
                                            "        // current element to maximum sum ending at previous index `i-1`)\n" +
                                            "        max_ending_here = max_ending_here + arr[i];\n" +
                                            " \n" +
                                            "        // maximum sum should be more than the current element\n" +
                                            "        max_ending_here = max(max_ending_here, arr[i]);\n" +
                                            " \n" +
                                            "        // update the result if the current subarray sum is found to be greater\n" +
                                            "        max_so_far = max(max_so_far, max_ending_here);\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    return max_so_far;\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main()\n" +
                                            "{\n" +
                                            "    int arr[] = { -8, -3, -6, -2, -5, -4 };\n" +
                                            "    int n = sizeof(arr)/sizeof(arr[0]);\n" +
                                            " \n" +
                                            "    cout << \"The maximum sum of a contiguous subarray is \" <<\n" +
                                            "            kadaneNeg(arr, n);\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n //Output: The maximum sum of a contiguous subarray is -2"
                            )
                    )
            ),
            Problem(
                    "Trapping Rain Water Problem",
                    "Hard",
                    "Amazon Microsoft DEShaw Adobe",
                    listOf(
                            TextCodeBlock(
                                    "Trapping Rain Water Problem",
                                    "Find the maximum amount of water that can be trapped within a given set of bars where each bar’s width is 1 unit.\n" +
                                            "\n" +
                                            "For example, Input: An array containing height of bars {7, 0, 4, 2, 5, 0, 6, 4, 0, 5}\n" +
                                            "The maximum amount of water that can be trapped is 25.\n" +
                                            "\n" +
                                            "The idea is to calculate the maximum height bar on the left and right of every bar. The amount of water stored on top of each bar is equal to the minimum among the leading’ bar to the left and right minus the current bar’s height. \n" +
                                            "\n" +
                                            "The time complexity is O(n) and requires O(n) extra space, where n is the total number of given bars.",
                                    "#include <stdio.h>\n" +
                                            "#include <limits.h>\n" +
                                            " \n" +
                                            "int max(int x, int y) {\n" +
                                            "    return (x > y) ? x : y;\n" +
                                            "}\n" +
                                            " \n" +
                                            "int min(int x, int y) {\n" +
                                            "    return (x < y) ? x : y;\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Function to find the amount of water that can be trapped within\n" +
                                            "// a given set of bars in linear time and extra space\n" +
                                            "int trap(int bars[], int n)\n" +
                                            "{\n" +
                                            "    int water = 0;\n" +
                                            " \n" +
                                            "    // `left[i]` stores the maximum height of a bar to the left\n" +
                                            "    // of the current bar\n" +
                                            "    int left[n-1];\n" +
                                            "    left[0] = INT_MIN;\n" +
                                            " \n" +
                                            "    // process bars from left to right\n" +
                                            "    for (int i = 1; i < n - 1; i++) {\n" +
                                            "        left[i] = max(left[i-1], bars[i-1]);\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    /*\n" +
                                            "    int right[n];\n" +
                                            "    right[n - 1] = INT_MIN;\n" +
                                            "    for (int i = n - 2; i >= 0; i--) {\n" +
                                            "        right[i] = max(right[i+1], bars[i+1]);\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    for (int i = 1; i < n - 1; i++)\n" +
                                            "    {\n" +
                                            "        if (min(left[i], right[i]) > bars[i]) {\n" +
                                            "            water += min(left[i], right[i]) - bars[i];\n" +
                                            "        }\n" +
                                            "    }\n" +
                                            "    */\n" +
                                            " \n" +
                                            "    // `right` stores the maximum height of a bar to the right\n" +
                                            "    // of the current bar\n" +
                                            "    int right = INT_MIN;\n" +
                                            " \n" +
                                            "    // process bars from right to left\n" +
                                            "    for (int i = n - 2; i >= 1; i--)\n" +
                                            "    {\n" +
                                            "        right = max(right, bars[i+1]);\n" +
                                            " \n" +
                                            "        // check if it is possible to store water in the current bar\n" +
                                            "        if (min(left[i], right) > bars[i]) {\n" +
                                            "            water += min(left[i], right) - bars[i];\n" +
                                            "        }\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    return water;\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main(void)\n" +
                                            "{\n" +
                                            "    int heights[] = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 };\n" +
                                            "    int n = sizeof(heights) / sizeof(heights[0]);\n" +
                                            " \n" +
                                            "    printf(\"The maximum amount of water that can be trapped is %d\",\n" +
                                            "            trap(heights, n));\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n //Output: The maximum amount of water that can be trapped is 25"
                            ),
                            TextCodeBlock(
                                    "Constant space solution",
                                    "The time complexity is O(n) and doesn’t require any extra space.",
                                    "#include <stdio.h>\n" +
                                            " \n" +
                                            "int max(int x, int y) {\n" +
                                            "    return (x > y) ? x : y;\n" +
                                            "}\n" +
                                            " \n" +
                                            "// Function to find the amount of water that can be trapped within\n" +
                                            "// a given set of bars in linear time and constant space\n" +
                                            "int trap(int heights[], int n)\n" +
                                            "{\n" +
                                            "    // maintain two pointers left and right, pointing to the leftmost and\n" +
                                            "    // rightmost index of the input array\n" +
                                            "    int left = 0, right = n - 1, water = 0;\n" +
                                            " \n" +
                                            "    int maxLeft = heights[left];\n" +
                                            "    int maxRight = heights[right];\n" +
                                            " \n" +
                                            "    while (left < right)\n" +
                                            "    {\n" +
                                            "        if (heights[left] <= heights[right])\n" +
                                            "        {\n" +
                                            "            left++;\n" +
                                            "            maxLeft = max(maxLeft, heights[left]);\n" +
                                            "            water += (maxLeft - heights[left]);\n" +
                                            "        }\n" +
                                            "        else {\n" +
                                            "            right--;\n" +
                                            "            maxRight = max(maxRight, heights[right]);\n" +
                                            "            water += (maxRight - heights[right]);\n" +
                                            "        }\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    return water;\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main(void)\n" +
                                            "{\n" +
                                            "    int heights[] = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 };\n" +
                                            "    int n = sizeof(heights) / sizeof(heights[0]);\n" +
                                            " \n" +
                                            "    printf(\"The maximum amount of water that can be trapped is %d\",\n" +
                                            "            trap(heights, n));\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n//Output: The maximum amount of water that can be trapped is 25"
                            )
                    )
            ),
            Problem(
                    "Find pairs with difference `k` in an array",
                    "Easy",
                    "Facebook Adobe Amazon",
                    listOf(
                            TextCodeBlock(
                                    "Find pairs with difference `k` in an array",
                                    "Given an unsorted integer array, print all pairs with a given difference k in it. \n" +
                                            "\n" +
                                            "For example, Input: arr = [1, 5, 2, 2, 2, 5, 5, 4] k = 3 Output: (2, 5) and (1, 4) \n" +
                                            "\n" +
                                            "A naive solution would be to consider every pair in a given array and return if the desired difference is found. The time complexity of this solution would be O(n ), where n is the size of the input. \n" +
                                            "\n" +
                                            "We can use a set to solve this problem in linear time. The idea is to insert each array element arr[i] into a set. We also check if element (arr[i] - diff) or (arr[i] + diff) already exists in the set or not. If the element is seen before, print the pair (arr[i], arr[i] - diff) or (arr[i] + diff, arr[i]).\n" +
                                            "\n" +
                                            "The time complexity is O(n.log(n)) and requires O(n) extra space, where n is the size of the input.",
                                    "#include <iostream>\n" +
                                            "#include <unordered_set>\n" +
                                            "#include <algorithm>\n" +
                                            "using namespace std;\n" +
                                            " \n" +
                                            "// Function to find a pair with the given difference in an array.\n" +
                                            "// This method handles duplicates in the array\n" +
                                            "void findPair(int arr[], int n, int diff)\n" +
                                            "{\n" +
                                            "    // sort array in ascending order\n" +
                                            "    sort(arr, arr + n);\n" +
                                            " \n" +
                                            "    // take an empty set\n" +
                                            "    unordered_set<int> set;\n" +
                                            " \n" +
                                            "    // do for every array element\n" +
                                            "    for (int i = 0; i < n; i++)\n" +
                                            "    {\n" +
                                            "        // to avoid printing duplicates (skip adjacent duplicates)\n" +
                                            "        while (i+1 < n && arr[i] == arr[i+1]) {\n" +
                                            "            i++;\n" +
                                            "        }\n" +
                                            " \n" +
                                            "        // check if pair with the given difference `(arr[i], arr[i]-diff)` exists\n" +
                                            "        if (set.find(arr[i] - diff) != set.end()) {\n" +
                                            "            cout << \"(\" << arr[i] << \", \" << arr[i] - diff << \")\\n\";\n" +
                                            "        }\n" +
                                            " \n" +
                                            "        // check if pair with the given difference `(arr[i]+diff, arr[i])` exists\n" +
                                            "        if (set.find(arr[i] + diff) != set.end()) {\n" +
                                            "            cout << \"(\" << arr[i] + diff << \", \" << arr[i] << \")\\n\";\n" +
                                            "        }\n" +
                                            " \n" +
                                            "        // insert the current element into the set\n" +
                                            "        set.insert(arr[i]);\n" +
                                            "    }\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main()\n" +
                                            "{\n" +
                                            "    int arr[] = { 1, 5, 2, 2, 2, 5, 5, 4};\n" +
                                            "    int diff = -3;\n" +
                                            " \n" +
                                            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
                                            " \n" +
                                            "    findPair(arr, n, diff);\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n//Output: (1, 4) (2, 5)"
                            )
                    )
            ),
            Problem(
                    "4–Sum Problem | Quadruplets with a given sum",
                    "Medium",
                    "Google Microsoft Amazon",
                    listOf(
                            TextCodeBlock(
                                    "4–Sum Problem | Quadruplets with a given sum",
                                    "4-sum problem: Given an unsorted integer array, check if it contains four elements tuple (quadruplets) having a given sum. \n" +
                                            "\n" +
                                            "For example, Input: arr = [ 2, 7, 4, 0, 9, 5, 1, 3 ] sum = 20 Output: Quadruplet exists. \n" +
                                            "\n" +
                                            "Below are quadruplets with the given sum 20 (0, 4, 7, 9) (1, 3, 7, 9) (2, 4, 5, 9)\n" +
                                            "\n" +
                                            "\n" +
                                            "Efficient solution using Hashing \n" +
                                            "\n" +
                                            "The idea is to consider every pair of elements in the array one by one and insert it into a hash table. For each pair of elements (i, j) , calculate the remaining sum. If the remaining sum exists in the map and elements involved in the previous occurrence doesn’t overlap with the current pair, i.e., (i, j, i, y) or (i, j, x, i) or (i, j, j, y) , or (i, j, x, j) , print the quadruplet and return.\n" +
                                            "\n" +
                                            "The time complexity is O(n3) and requires O(n2) extra space, where n isthe size of the input.",
                                    "#include <iostream>\n" +
                                            "#include <unordered_map>\n" +
                                            "#include <vector>\n" +
                                            "using namespace std;\n" +
                                            " \n" +
                                            "typedef pair<int, int> Pair;\n" +
                                            " \n" +
                                            "// Function to check if quadruplet exists in an array with the given sum\n" +
                                            "bool hasQuadruplet(int arr[], int n, int sum)\n" +
                                            "{\n" +
                                            "    // create an empty map\n" +
                                            "    // `key` —> sum of a pair in the array\n" +
                                            "    // `value` —> vector storing an index of every pair having that sum\n" +
                                            "    unordered_map<int, vector<Pair>> map;\n" +
                                            " \n" +
                                            "    // consider each element except the last element\n" +
                                            "    for (int i = 0; i < n - 1; i++)\n" +
                                            "    {\n" +
                                            "        // start from the i'th element until the last element\n" +
                                            "        for (int j = i + 1; j < n; j++)\n" +
                                            "        {\n" +
                                            "            // calculate the remaining sum\n" +
                                            "            int val = sum - (arr[i] + arr[j]);\n" +
                                            " \n" +
                                            "            // if the remaining sum is found on the map,\n" +
                                            "            // we have found a quadruplet\n" +
                                            "            if (map.find(val) != map.end())\n" +
                                            "            {\n" +
                                            "                // check every pair having a sum equal to the remaining sum\n" +
                                            "                for (auto pair: map.find(val)->second)\n" +
                                            "                {\n" +
                                            "                    int x = pair.first;\n" +
                                            "                    int y = pair.second;\n" +
                                            " \n" +
                                            "                    // if quadruplet doesn't overlap, print it and return true\n" +
                                            "                    if ((x != i && x != j) && (y != i && y != j))\n" +
                                            "                    {\n" +
                                            "                        cout << \"Quadruplet Found (\"\n" +
                                            "                            << arr[i] << \", \" << arr[j] << \", \" << arr[x]\n" +
                                            "                            << \", \" << arr[y] << \")\";\n" +
                                            "                        return true;\n" +
                                            "                    }\n" +
                                            "                }\n" +
                                            "            }\n" +
                                            " \n" +
                                            "            // insert the current pair into the map\n" +
                                            "            map[arr[i] + arr[j]].push_back({i, j});\n" +
                                            "        }\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    // return false if quadruplet doesn't exist\n" +
                                            "    return false;\n" +
                                            "}\n" +
                                            " \n" +
                                            "int main()\n" +
                                            "{\n" +
                                            "    int arr[] = { 2, 7, 4, 0, 9, 5, 1, 3 };\n" +
                                            "    int sum = 20;\n" +
                                            " \n" +
                                            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
                                            " \n" +
                                            "    if (!hasQuadruplet(arr, n, sum)) {\n" +
                                            "        cout << \"Quadruplet Doesn't Exist\";\n" +
                                            "    }\n" +
                                            " \n" +
                                            "    return 0;\n" +
                                            "}\n\n//Output: Quadruplet Found (4, 0, 7, 9)"
                            )
                    )
            )
    )


    val topicList=listOf(
            Topic(
                    "Sorting",
                    7,
                    R.drawable.topic_sorting,
                    introduction_sorting,
                    theory_sorting,
                    problems_sorting
            ),
            Topic(
                    "Array",
                    7,
                    R.drawable.topic_array,
                    "An array is a collection of items stored at contiguous memory locations. The idea is to store multiple items of the same type together.",
                    theory_array,
                    problems_array
            ),
            Topic(
                    "String",
                    0,
                    R.drawable.topic_string,
                    introduction_sample,
                    listOf(TextCodeBlock("","","")),
                    listOf(Problem("","","",listOf(TextCodeBlock("","",""))))
                    ),
            Topic(
                    "Linked List",
                    0,
                    R.drawable.topic_linked_list,
                    introduction_sample,
                    listOf(TextCodeBlock("","","")),
                    listOf(Problem("","","",listOf(TextCodeBlock("","",""))))
                    ),
            Topic(
                    "Divide & Conquer, Binary Search",
                    0,
                    R.drawable.topic_divide_and_conquer,
                    introduction_sample,
                    listOf(TextCodeBlock("","","")),
                    listOf(Problem("","","",listOf(TextCodeBlock("","",""))))
                    ),
            Topic(
                    "Bit Manipulation",
                    0,
                    R.drawable.topic_bit_manipulation,
                    introduction_sample,
                    listOf(TextCodeBlock("","","")),
                    listOf(Problem("","","",listOf(TextCodeBlock("","",""))))
                    ),
            Topic(
                    "Recursion & Backtracking",
                    0,
                    R.drawable.topic_recursion,
                    introduction_sample,
                    listOf(TextCodeBlock("","","")),
                    listOf(Problem("","","",listOf(TextCodeBlock("","",""))))
            ),
            Topic(
                    "Stack",
                    0,
                    R.drawable.topic_stack,
                    introduction_sample,
                    listOf(TextCodeBlock("","","")),
                    listOf(Problem("","","",listOf(TextCodeBlock("","",""))))
            ),
            Topic(
                    "Queue",
                    0,
                    R.drawable.topic_queue,
                    introduction_sample,
                    listOf(TextCodeBlock("","","")),
                    listOf(Problem("","","",listOf(TextCodeBlock("","",""))))
            ),
            Topic(
                    "Greedy",
                    0,
                    R.drawable.topic_greedy,
                    introduction_sample,
                    listOf(TextCodeBlock("","","")),
                    listOf(Problem("","","",listOf(TextCodeBlock("","",""))))
                    ),
            Topic(
                    "Dynamic Programming",
                    0,
                    R.drawable.topic_dp,
                    introduction_sample,
                    listOf(TextCodeBlock("","","")),
                    listOf(Problem("","","",listOf(TextCodeBlock("","",""))))
                    ),
            Topic(
                    "Graph",
                    0,
                    R.drawable.topic_graph,
                    introduction_sample,
                    listOf(TextCodeBlock("","","")),
                    listOf(Problem("","","",listOf(TextCodeBlock("","",""))))
                    ),
            Topic(
                    "Binary Tree",
                    0,
                    R.drawable.topic_binary_tree,
                    introduction_sample,
                    listOf(TextCodeBlock("","","")),
                    listOf(Problem("","","",listOf(TextCodeBlock("","",""))))
                    ),
            Topic(
                    "Binary Search Tree",
                    0,
                    R.drawable.topic_binary_search_tree,
                    introduction_sample,
                    listOf(TextCodeBlock("","","")),
                    listOf(Problem("","","",listOf(TextCodeBlock("","",""))))
                    ),
            Topic(
                    "Heap",
                    0,
                    R.drawable.topic_heap,
                    introduction_sample,
                    listOf(TextCodeBlock("","","")),
                    listOf(Problem("","","",listOf(TextCodeBlock("","",""))))
                    )
    )

}
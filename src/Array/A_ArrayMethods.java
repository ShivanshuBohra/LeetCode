package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A_ArrayMethods {

    /*
     * ============================================================
     *        MUST-KNOW Arrays Methods for Java 8 Interviews
     * ============================================================
     *
     * 1. Arrays.sort()              -> Sort array
     * 2. Arrays.parallelSort()      -> Parallel sorting (Java 8)
     * 3. Arrays.binarySearch()      -> Search in sorted array
     * 4. Arrays.fill()              -> Fill array with same value
     * 5. Arrays.copyOf()            -> Copy complete/partial array
     * 6. Arrays.copyOfRange()       -> Copy specific range
     * 7. Arrays.equals()            -> Compare two arrays
     * 8. Arrays.toString()          -> Print array
     * 9. Arrays.deepToString()      -> Print multidimensional array
     * 10. Arrays.stream()           -> Convert array to Stream
     * 11. Arrays.asList()           -> Convert Object Array to List
     *
     * -------- Stream Methods --------
     *
     * sum()
     * average()
     * max()
     * min()
     * filter()
     * map()
     * sorted()
     * distinct()
     * anyMatch()
     * allMatch()
     * noneMatch()
     * count()
     * findFirst()
     * forEach()
     * boxed()
     * collect()
     *
     * NOTE:
     * Arrays.binarySearch() works ONLY on sorted arrays.
     */

    public static void main(String[] args) {

        // =============================================================
        // Create Array
        // =============================================================

        int[] arr1 = {10, 5, 3, 7};

        int[] arr2 = new int[5];

        int[] arr3 = new int[] {1, 2, 3};

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));



        // =============================================================
        // List Creation
        // =============================================================

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);

        System.out.println(list);

        List<Integer> list2 = Arrays.asList(30,40,50);

        System.out.println(list2);



        // =============================================================
        // Arrays.sort()
        // =============================================================

        int[] sortArray = {9,4,7,1,6};

        Arrays.sort(sortArray);

        System.out.println(Arrays.toString(sortArray));



        // =============================================================
        // Arrays.sort(start,end)
        // end index is exclusive
        // =============================================================

        int[] partialSort = {9,4,7,1,6};

        Arrays.sort(partialSort,1,4);

        System.out.println(Arrays.toString(partialSort));



        // =============================================================
        // Arrays.parallelSort()
        // Faster for large arrays
        // =============================================================

        int[] parallel = {10,8,6,4,2,9,7};

        Arrays.parallelSort(parallel);

        System.out.println(Arrays.toString(parallel));

//        Arrays.sort() sorts using a single thread.
//        Arrays.parallelSort() uses the Fork/Join framework to divide the array into smaller chunks, 
//sort them concurrently on multiple threads, and merge the results. Both produce the same sorted output.
//        parallelSort() generally performs better on large arrays and multi-core processors, 
//        while sort() is often more efficient for small arrays due to lower overhead.


        // =============================================================
        // Arrays.binarySearch()
        // Works only on sorted arrays
        // =============================================================

        int[] searchArray = {10,3,15,4,2,1};

        Arrays.sort(searchArray);

        int index = Arrays.binarySearch(searchArray,4);

        System.out.println(index);



        // =============================================================
        // Arrays.fill()
        // =============================================================

        int[] filled = new int[5];

        Arrays.fill(filled,100);

        System.out.println(Arrays.toString(filled));



        // =============================================================
        // Arrays.copyOf()
        // =============================================================
//        First parameter → Original array
//        Second parameter → Length of the new array
//If length in param is smaller then original array onl,y those are copied if greater default values are added
        int[] copy = Arrays.copyOf(searchArray,4);

        System.out.println(Arrays.toString(copy));



        // =============================================================
        // Arrays.copyOfRange()
        // start inclusive
        // end exclusive
        // =============================================================

        int[] range = Arrays.copyOfRange(searchArray,2,5);

        System.out.println(Arrays.toString(range));



        // =============================================================
        // Arrays.equals()
        // =============================================================

        int[] a = {1,2,3};

        int[] b = {1,2,3};

        int[] c = {1,2,4};

        System.out.println(Arrays.equals(a,b));

        System.out.println(Arrays.equals(a,c));



        // =============================================================
        // Arrays.toString()
        // =============================================================

        System.out.println(Arrays.toString(a));



        // =============================================================
        // Arrays.deepToString()
        // Used for multidimensional arrays
        // =============================================================

        int[][] matrix = {
                {1,2},
                {3,4}
        };

        System.out.println(Arrays.deepToString(matrix));



        // =============================================================
        // Arrays.stream()
        // =============================================================

        int[] streamArray = {2,5,8,1,4,6};



        // forEach()

        Arrays.stream(streamArray)
                .forEach(System.out::println);



        // sum()

        System.out.println(Arrays.stream(streamArray).sum());



        // average()

        System.out.println(Arrays.stream(streamArray)
                .average()
                .getAsDouble());



        // max()

        System.out.println(Arrays.stream(streamArray)
                .max()
                .getAsInt());



        // min()

        System.out.println(Arrays.stream(streamArray)
                .min()
                .getAsInt());



        // filter()

        Arrays.stream(streamArray)
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);



        // map()

        Arrays.stream(streamArray)
                .map(x -> x * 10)
                .forEach(System.out::println);



        // sorted()

        Arrays.stream(streamArray)
                .sorted()
                .forEach(System.out::println);



        // distinct()

        int[] duplicateArray = {1,2,2,3,4,4,5};

        Arrays.stream(duplicateArray)
                .distinct()
                .forEach(System.out::println);



        // anyMatch()

        System.out.println(Arrays.stream(streamArray)
                .anyMatch(x -> x == 5));



        // allMatch()

        System.out.println(Arrays.stream(streamArray)
                .allMatch(x -> x > 0));



        // noneMatch()

        System.out.println(Arrays.stream(streamArray)
                .noneMatch(x -> x < 0));



        // count()

        System.out.println(Arrays.stream(streamArray)
                .filter(x -> x % 2 == 0)
                .count());



        // findFirst()

        System.out.println(Arrays.stream(streamArray)
                .filter(x -> x > 4)
                .findFirst()
                .orElse(-1));



        // =============================================================
        // boxed()
        // Convert IntStream to Stream<Integer>
        // =============================================================

        List<Integer> boxedList =
                Arrays.stream(streamArray)
                        .boxed()
                        .collect(Collectors.toList());

        System.out.println(boxedList);



        // =============================================================
        // Arrays.asList()
        // Object arrays only
        // =============================================================

        Integer[] integerArray = {10,20,30};

        List<Integer> numbers = Arrays.asList(integerArray);

        System.out.println(numbers);



        // =============================================================
        // Convert Array -> List using Stream
        // =============================================================

        List<Integer> listFromArray =
                Arrays.stream(integerArray)
                        .collect(Collectors.toList());

        System.out.println(listFromArray);



        // =============================================================
        // Convert List -> Array
        // =============================================================

        Integer[] array =
                listFromArray.toArray(new Integer[0]);

        System.out.println(Arrays.toString(array));

    }
}
import java.util.ArrayList;
import java.util.Comparator;

public class testFile
{

    // Example result class to store individual test results
    static class SortResult {
        int[] unsortedArray;
        int[] sortedArray;
        int comparisons;

        SortResult(int[] unsortedArray, int[] sortedArray, int comparisons) {
            this.unsortedArray = unsortedArray;
            this.sortedArray = sortedArray;
            this.comparisons = comparisons;
        }
    }

    private static void printArray(int[] n) {
        for (int e : n) {
            System.out.print(" " + e);
        }

        System.out.println();
    }



    public static void testMergeSort()
    {
        ArrayList<int[]> arr1 = IntegerPermutationsGenerator.getPermutations(8);
        ArrayList<SortResult> results = new ArrayList<>();

        for (int[] test : arr1) {
            MergeSort.comparisonCount = 0;
            MergeSort.mergeSort(test);
            results.add(new SortResult(test.clone(), test, MergeSort.getComparisons()));
        }

        // Analyze results
        analyzeResults(results);


        System.out.println("--------------------------------");
    }

    private static void analyzeResults(ArrayList<SortResult> results) {
        // Sort by number of comparisons
        results.sort(Comparator.comparingInt(result -> result.comparisons));

        // Calculate average
        double average = results.stream().mapToInt(result -> result.comparisons).average().orElse(0);

        // Print the best 10 cases
        System.out.println("10 BEST CASES:");
        for (int i = 0; i < Math.min(10, results.size()); i++) {
            printResult(results.get(i));
        }

        // Print the worst 10 cases
        System.out.println("10 WORST CASES:");
        for (int i = Math.max(0, results.size() - 10); i < results.size(); i++) {
            printResult(results.get(i));
        }

        // Print average
        System.out.println("Average number of comparisons: " + average);
    }

    private static void printResult(SortResult result) {
        System.out.println("Unsorted array: ");
        printArray(result.unsortedArray);
        System.out.println("Sorted Array: ");
        printArray(result.sortedArray);
        System.out.println("Number of comparisons: " + result.comparisons);
        System.out.println("--------------------------------");
    }

    public static void testHeapSort()
    {
        //int numComparisons = 0;


        int n = 8;
        // Testing for n = 4
        ArrayList<SortResult> results = new ArrayList<>();
        ArrayList<int[]> arr1 = IntegerPermutationsGenerator.getPermutations(n);
        int[] test;

        System.out.println("Testing for n = " + n);

        for (int i = 0; i < arr1.size(); i++) {


            test = arr1.get(i);
            int[] arrayClone = test.clone();

            //System.out.println("Unsorted array: ");
            //printArray(test);

            heapSort hs = new heapSort(test.length);
            for (int element : test)
            {
                hs.insert(element);

            }



            //System.out.println("Sorted Array");
            hs.sort();
            //hs.printHeap();
            //System.out.println("Number of comparisons : " + heapSort.getComparisons());
            results.add(new SortResult(arrayClone, test, heapSort.getComparisons()));


            heapSort.comparisons=0;
        }

        analyzeResults(results);

    }


    public static void testQuickSort()
    {
        ArrayList<int[]> arr1 = IntegerPermutationsGenerator.getPermutations(8);
        ArrayList<SortResult> results = new ArrayList<>();

        for (int[] test : arr1) {
            QuickSort.comparisonCount=0;
           QuickSort.quickSort(test,0, test.length-1);
            results.add(new SortResult(test.clone(), test, QuickSort.getComparisonCount()));
        }

        // Analyze results
        analyzeResults(results);


        System.out.println("--------------------------------");
    }


    public static void testShakerSort()
    {
        ArrayList<int[]> arr1 = IntegerPermutationsGenerator.getPermutations(8);
        ArrayList<SortResult> results = new ArrayList<>();

        for (int[] test : arr1)
        {
            ShakerSort.comparisonCount = 0;
            ShakerSort.shakerSort(test);
            results.add(new SortResult(test.clone(), test, ShakerSort.getComparisons()));
        }

        // Analyze results
        analyzeResults(results);
        System.out.println("--------------------------------");
    }



    public static void main (String[] args)
    {

        //testMergeSort();

        testQuickSort();

        //testHeapSort();

        //testShakerSort();

    }



}

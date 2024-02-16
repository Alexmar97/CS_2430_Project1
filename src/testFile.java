import java.util.ArrayList;

public class testFile
{



    private static void printArray(int[] n) {
        for (int e : n) {
            System.out.print(" " + e);
        }

        System.out.println();
    }



    public static void testMergeSort()
    {
        //Testing for n = 4, n=6, n=8
        ArrayList<int[]> arr1 = IntegerPermutationsGenerator.getPermutations(4);
        int [] test;

        System.out.println("Testing for n = 4");

        for(int i=0; i < arr1.size(); i++)
        {

            test = arr1.get(i);

            System.out.println("Unsorted array: ");
            printArray(test);

            MergeSort.comparisonCount = 0;
            MergeSort.mergeSort(test);

            System.out.println("Sorted Array: ");
            printArray(test);
            System.out.println("Number of comparisons: " + MergeSort.getComparisons());
            System.out.println("--------------------------------");

        }


        System.out.println("--------------------------------");
    }



    public static void testHeapSort()
    {
        //int numComparisons = 0;

        int n = 8;
        // Testing for n = 4
        ArrayList<int[]> arr1 = IntegerPermutationsGenerator.getPermutations(n);
        int[] test;

        System.out.println("Testing for n = " + n);

        for (int i = 0; i < arr1.size(); i++) {


            test = arr1.get(i);

            System.out.println("Unsorted array: ");
            printArray(test);

            heapSort hs = new heapSort(test.length);
            for (int element : test) {
                hs.insert(element);

            }

            System.out.println("Sorted Array");
            hs.sort();
            hs.printHeap();
            System.out.println("Number of comparisons : " + heapSort.getComparisons());

            heapSort.comparisons=0;
        }
        //System.out.println("Number of comparisons: " + numComparisons);
    }


    public static void testQuickSort()
    {
        //Testing for n = 4, n=6, n=8
        ArrayList<int[]> arr1 = IntegerPermutationsGenerator.getPermutations(4);
        int [] test;

        System.out.println("Testing for n = 4");

        for(int i=0; i < arr1.size(); i++)
        {

            test = arr1.get(i);

            System.out.println("Unsorted array: ");
            printArray(test);

            QuickSort.comparisonCount = 0;
            QuickSort.quickSort(test, 0, test.length-1);

            System.out.println("Sorted Array");
            printArray(test);
            System.out.println("Number of comparisons: " + QuickSort.getComparisonCount());

        }


        System.out.println("--------------------------------");
    }


    public static void testShakerSort()
    {
        //Testing for n = 4, n=6, n=8
        ArrayList<int[]> arr1 = IntegerPermutationsGenerator.getPermutations(4);
        int [] test;

        System.out.println("Testing for n = ");

        for(int i=0; i < arr1.size(); i++)
        {

            test = arr1.get(i);

            System.out.println("Unsorted array: ");
            printArray(test);

            ShakerSort.comparisonCount = 0;
            ShakerSort.ShakerSrt.shakerSort(test);

            System.out.println("Sorted Array");
            printArray(test);
            System.out.println("Number of comparisons: " + ShakerSort.ShakerSrt.getComparisons());

        }


        System.out.println("--------------------------------");
    }



    public static void main (String[] args)
    {

        testMergeSort();

        //testQuickSort();

        //testHeapSort();

        //testShakerSort();

    }



}

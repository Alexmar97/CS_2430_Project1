import java.util.ArrayList;

public class testFile
{

    private static void printArray(int[] n) {
        for (int e : n) {
            System.out.print(" " + e);
        }

        System.out.println();
    }

    public static void main (String[] args)
    {



        //Testing for n = 4, n=6, n=8
        ArrayList<int[]> arr1 = IntegerPermutationsGenerator.getPermutations(8);
        int [] test;

        System.out.println("Testing for n = 4");

        for(int i=0; i < arr1.size(); i++)
        {

            test = arr1.get(i);

            System.out.println("Unsorted array: ");
            printArray(test);

            MergeSort.comparisonCount = 0;
            MergeSort.mergeSort(test);

            System.out.println("Sorted Array");
            printArray(test);
            System.out.println("Number of comparisons: " + MergeSort.getComparisons());

        }


        System.out.println("--------------------------------");

    }



}

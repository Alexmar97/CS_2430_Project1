

    /**
     * Implementation of QuickSort algorithm. Original code from Bro Code YouTube
     * channel. Video link: https://www.youtube.com/watch?v=Vtckgz38QHs
     *
     * @author Bro Code, edited for project guidelines by Bibash Mangar
     */
    public class QuickSort
    {

        /**
         * Main class is edited to print out the array unsorted and after it is
         * sorted
         *
         */
        // keep track of comparisons made during array sorting
        protected static int comparisonCount = 0;

        public static void main(String args[])
        {
            // quick sort = moves smaller elements to left of a pivot.
            //			   recursively divide array in 2 partitions

            //                       run-time complexity = Best case O(n log(n))
            //				   		                   Average case O(n log(n))
            //				   		                   Worst case O(n^2) if already sorted
            //                       space complexity    = O(log(n)) due to recursion
            int[] array =
                    {
                            8, 2, 5, 3, 9, 4, 7, 6, 1
                    };
            int[] array2 =
                    {
                            1, 3, 5, 2, 6, 4, 7
                    };
            // print out unsorted array
            System.out.println("Unsorted Array:");
            for (int i : array)
            {
                System.out.print(i + " ");
            }
            // print out unsorted array2
            System.out.println("\nUnsorted Array2:");
            for (int i : array2)
            {
                System.out.print(i + " ");
            }
            // reset the comparison count
            comparisonCount = 0;

            // sort array
            quickSort(array, 0, array.length - 1);

            System.out.println("\nSorted Array:");
            for (int i : array)
            {
                System.out.print(i + " ");
            }
            // display number of comparisons
            System.out.println("\nNumber of comparisons for Array: " + comparisonCount);

            // Reset comparison count
            comparisonCount = 0;

            // reset comparison count again
            comparisonCount = 0;

            //sort array 2
            quickSort(array2, 0, array2.length - 1);

            System.out.println("\nSorted Array2:");
            for (int i : array2)
            {
                System.out.print(i + " ");
            }
            // Display the number of comparisons
            System.out.println("\nNumber of comparisons for Array2: " + comparisonCount);
        }

        protected static void quickSort(int[] array, int start, int end)
        {

            if (end <= start)
            {
                return; //base case
            }
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }

        protected static int partition(int[] array, int start, int end)
        {

            int pivot = array[end];
            int i = start - 1;

            for (int j = start; j <= end; j++)
            {
                // increment comparison count for each comparison
                comparisonCount++;
                if (array[j] < pivot)
                {
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            i++;
            int temp = array[i];
            array[i] = array[end];
            array[end] = temp;

            return i;
        }

        public static int getComparisonCount()
        {
            return comparisonCount;
        }

        // reset comparisonCount
        protected static void resetComparisonCount()
        {
            comparisonCount = 0;
        }
    }



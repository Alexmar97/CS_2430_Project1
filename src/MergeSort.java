public class MergeSort {




        //You need a sorting function
        //You need a merging function


        protected static int comparisonCount = 0;

        /*
        This method will divide the main array into a subarray. It is a recursive function though,
        so it will call itself again and subdivide the arrays multiple times into right/left arrays
        until getting arrays that are length 1. It will then call on the merge function
         */
        public static void mergeSort(int array[])
        {

            //comparisonCount = 0;
            int arrayLength = array.length;


            if(arrayLength <= 1)
                return; //Base case!


            int middle = arrayLength/2;


            //newArrays:
            int[] leftArray = new int[middle];
            int[] rightArray = new int[arrayLength - middle];


            //indices:
            int i = 0; //For left array
            int j = 0; //right array


            for(; i < arrayLength; i++)
            {
                //If counter i is less than middle possition, then this value from
                // main arr will go to the left arr
                if(i < middle)
                    leftArray[i] = array[i];

                    //If counter i is greater than middle possition, then this value from
                    // main arr will go to the right arr
                else
                {
                    rightArray[j] = array[i];
                    j++;
                }
            }


            mergeSort(leftArray);
            mergeSort(rightArray);
            merge(leftArray, rightArray, array);

            //System.out.println("Number of comparisons: "  + getComparisons());
           // getComparisons();


        }



        /*
        This is the method that will sort and merge every subarray that was created
         */
        public static void merge(int[] leftArray, int[] rightArray, int[] array)
        {
            //Counters (Indices):
            int mainIndex = 0; //For main array
            int leftIndex = 0; //for left array
            int rightIndex = 0; //for right array


            while(leftIndex < leftArray.length && rightIndex < rightArray.length)
            {
                comparisonCount++;
                //if left term is smaller than right one, then main array will place left term first
                if(leftArray[leftIndex] <= rightArray[rightIndex])
                {
                    //We assign leftArray's value to the mainArray and then increment both counters after the assignment
                    //right index stays intact since it will be compared to
                    // leftArray[l+1] in the next round
                    array[mainIndex++] = leftArray[leftIndex++];
                    //comparisonCount++;
                }


                //if right term is smaller than left one, then main array will place right term first
                else if (rightArray[rightIndex] <= leftArray[leftIndex])
                {
                    array[mainIndex++] = rightArray[rightIndex++];
                    //left index stays intact since it will be compared to
                    // righttArray[r+1] in the next round
                    //comparisonCount++;
                }
            }

            // Copy any remaining elements from the left subarray
            while (leftIndex < leftArray.length)
            {
                array[mainIndex++] = leftArray[leftIndex++];
                //comparisonCount++;
            }

            // Copy any remaining elements from the right subarray
            while (rightIndex < rightArray.length)
            {
                array[mainIndex++] = rightArray[rightIndex++];
                //comparisonCount++;
            }

            //System.out.println("Number of comparisons: "  + getComparisons());


        }


        public static int getComparisons()
        {
            //System.out.println();
            return comparisonCount;
        }



        public static void main(String[] args)
        {


        }





    }



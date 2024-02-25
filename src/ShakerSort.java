import java.util.Arrays;

public class ShakerSort {
    protected static int comparisonCount;

    public static int[] shakerSort(int[] arr) {
        comparisonCount = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // Move the largest element to the end
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    comparisonCount++;
                    swap(arr, i, i + 1);
                }
            }
            right--;

            // Move the smallest element to the beginning
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    comparisonCount++;
                    swap(arr, i, i - 1);
                }
            }
            left++;
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static int getComparisons() {
        return comparisonCount;
    }
}
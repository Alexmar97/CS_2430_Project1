// Generates an array list of integer arrays, containing permutations of N integers.
// Written by Will Stach based on this algorithm:
// https://www.w3resource.com/java-exercises/array/java-array-exercise-68.php

import java.util.ArrayList;

public class IntegerPermutationsGenerator {
    public static ArrayList<int[]> getPermutations(int n) {
        ArrayList<int[]> arr = new ArrayList<int[]>();

        int[] initial = new int[n];

        for (int i = 0; i < n; i++) {
            initial[i] = i;
        }

        addPermutations(arr, 0, initial);

        return arr;
    }

    private static void addPermutations(ArrayList<int[]> arrlist, int start, int[] nums) {
        if (start == nums.length - 1) {
            int[] newarr = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                newarr[i] = nums[i];
            }

            arrlist.add(newarr);

            return;
        }

        for (int j = start; j < nums.length; j++) {
            int temp = nums[j];
            nums[j] = nums[start];
            nums[start] = temp;
            addPermutations(arrlist, start + 1, nums);
            temp = nums[j];
            nums[j] = nums[start];
            nums[start] = temp;
        }
    }

    public static void main(String[] args) {
        ArrayList<int[]> testperms = getPermutations(5);

        for (int[] e : testperms) {
            System.out.print("{ ");

            for (int n : e) {
                System.out.print(n);
                System.out.print(", ");
            }

            System.out.print("}\n");
        }
    }
}

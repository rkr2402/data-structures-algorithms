package com.practice.problems.leetcode.contests.weekly.contest344;

import java.util.Arrays;

public class Problem3 {

    public int[] colorTheArray(int n, int[][] queries) {
        int[] res = new int[queries.length];
        int[] nums = new int[n];
        int count = 0;

        if (n == 1 || queries.length == 1) {
            return res;
        }


        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];

            if (index - 1 >= 0 && (nums[index - 1] != 0 && nums[index] != 0) && nums[index - 1] == nums[index]) {
                count--;
            }

            if (index + 1 <= n - 1 && (nums[index + 1] != 0 && nums[index] != 0) && nums[index] == nums[index + 1]) {
                count--;
            }

            nums[index] = value;

            if (index - 1 >= 0 && (nums[index - 1] != 0 && nums[index] != 0) && nums[index - 1] == nums[index]) {
                count++;
            }

            if (index + 1 <= n - 1 && (nums[index + 1] != 0 && nums[index] != 0) && nums[index] == nums[index + 1]) {
                count++;
            }

            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Problem3().colorTheArray(4, new int[][]{{0, 2}, {1, 2}, {3, 1}, {1, 1}, {2, 1}})));

        System.out.println(Arrays.toString(
                new Problem3().colorTheArray(4, new int[][]{{0, 100000}})));
    }
}

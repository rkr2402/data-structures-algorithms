package com.practice.problems.leetcode.contests.weekly.contest344;

import java.util.Arrays;

public class Problem4 {

    public int minIncrements(int n, int[] cost) {
        int[] res = new int[]{0};
        findMaxSumPath(0, n, cost, res);
        return res[0];
    }

    private int findMaxSumPath(int index, int n, int[] cost, int[] ans) {
        //base case
        if (index >= n) {
            return 0;
        }

        //recursive case
        int left = findMaxSumPath((2 * index) + 1, n, cost, ans);
        int right = findMaxSumPath(((2 * index) + 2), n, cost, ans);
        ans[0] = ans[0] + Math.abs(left - right);
        return cost[index] + Math.max(left, right);

    }

    public static void main(String[] args) {
        Problem4 obj = new Problem4();
        System.out.println(obj.minIncrements(7, new int[]{1, 5, 2, 2, 3, 3, 1}));
    }
}

package com.practice.problems.leetcode.contests.weekly.contest344;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem1 {

    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefixDistinct = new int[n];
        int[] suffixDistinct = new int[n];
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            prefixDistinct[i] = set.size();
            if(i == n -1) {
                suffixDistinct[i] = 0;
                break;
            }
            for (int j = i + 1; j < n; j++) {
                set2.add(nums[j]);
            }
            suffixDistinct[i] = set2.size();
            set2.clear();
        }

        for (int i = 0; i < n; i++) {
            int curr = prefixDistinct[i] - suffixDistinct[i];
            result[i] = curr;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem1 obj = new Problem1();
        Arrays.stream(obj.distinctDifferenceArray(new int[]{1, 2, 3, 4, 5})).forEach(num -> System.out.print(num + " "));
        System.out.println();
        Arrays.stream(obj.distinctDifferenceArray(new int[]{3, 2, 3, 4, 2})).forEach(num -> System.out.print(num + " "));
    }
}

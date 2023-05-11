package com.practice.problems.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class Problem46$Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        getPermutation(nums, taken, result, new ArrayList<Integer>());
        return result;
    }

    private void getPermutation(int[] nums, boolean[] taken, List<List<Integer>> result, List<Integer> curr) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (taken[i]) continue;

            taken[i] = true;
            curr.add(nums[i]);
            getPermutation(nums, taken, result, curr);
            taken[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}

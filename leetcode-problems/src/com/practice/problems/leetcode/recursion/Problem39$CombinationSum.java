package com.practice.problems.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class Problem39$CombinationSum {

    private void findCombination(int[] candidates, int target, List<List<Integer>> result, List<Integer> currentList, int index) {
        if (index >= candidates.length || target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(currentList));
            }
            return;
        }

        //pick element at index
        currentList.add(candidates[index]);
        findCombination(candidates, target - candidates[index], result, currentList, index);
        currentList.remove(currentList.size() - 1);

        //not pick element at index
        findCombination(candidates, target, result, currentList, index + 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    public static void main(String[] args) {
        Problem39$CombinationSum obj = new Problem39$CombinationSum();
        List<List<Integer>> result = obj.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println("result size:" + result.size());
        result.forEach(list -> {
            System.out.print("list: ");
            for (Integer i : list) {
                System.out.print(" " + i);
            }
            System.out.println();
        });
    }
}

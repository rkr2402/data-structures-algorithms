package com.practice.problems.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem40$CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findUniqueCombination(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private void findUniqueCombination(int[] candidates, int target, int index,List<List<Integer>> result, List<Integer> currentList) {
        if(index >= candidates.length || target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(currentList));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if(i != index && candidates[i] == candidates[i-1]) {
                continue;
            }

            currentList.add(candidates[i]);
            findUniqueCombination(candidates, target - candidates[i], i + 1, result, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem40$CombinationSum2 obj = new Problem40$CombinationSum2();
        //List<List<Integer>> result = obj.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        List<List<Integer>> result = obj.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
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

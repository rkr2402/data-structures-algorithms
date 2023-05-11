package com.practice.problems.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class Problem60$PermutationSequence {

    //Optimized solution using K
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            fact = fact * i;
            nums.add(i);
        }
        nums.add(n);

        k = k - 1;
        String result = "";

        while (true) {
            int numIndex = k / fact;
            result = result + nums.get(numIndex);
            nums.remove(numIndex);
            if(nums.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / nums.size();
        }

        return result;
    }

    /* My Solution


    private void computePermutation(int n, int k, List<String> permutations, String curr, boolean[] boolArr) {

        if (curr.length() == n) {
            permutations.add(curr);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (boolArr[i]) continue;

            boolArr[i] = true;
            computePermutation(n, k, permutations, curr + i + "", boolArr);
            boolArr[i] = false;
        }
    }

    public String getPermutation(int n, int k) {
        List<String> permutations = new ArrayList<>();
        boolean[] chosen = new boolean[n + 1];

        computePermutation(n, k, permutations, "", chosen);

        for (String str : permutations) {
            System.out.print(str + " ");
        }
        System.out.println();
        return permutations.get(k - 1);
    }*/

    public static void main(String[] args) {
        Problem60$PermutationSequence obj = new Problem60$PermutationSequence();
        System.out.println(obj.getPermutation(3, 3));
    }
}

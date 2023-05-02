package com.practice.problems.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class Problem131$PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        getPalindromeSubString(s, result, new ArrayList<>(), 0);
        return result;
    }

    private void getPalindromeSubString(String inputString, List<List<String>> result, List<String> currentList, int index) {
        if (index >= inputString.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = index; i < inputString.length(); ++i) {
            String subString = inputString.substring(index, i + 1);
            if(isPalindrome(subString)) {
                currentList.add(subString);
                getPalindromeSubString(inputString, result, currentList, i + 1);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem131$PalindromePartitioning obj = new Problem131$PalindromePartitioning();
//        System.out.println(obj.isPalindrome("abcb"));
        List<List<String>> result = obj.partition("aab");
        System.out.println("result size:" + result.size());
        result.forEach(list -> {
            System.out.print("string: ");
            for (String i : list) {
                System.out.print(" " + i);
            }
            System.out.println();
        });
    }
}

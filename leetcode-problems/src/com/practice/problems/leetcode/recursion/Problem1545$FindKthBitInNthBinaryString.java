package com.practice.problems.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem link: https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
 */
public class Problem1545$FindKthBitInNthBinaryString {

    private void findAllStrings(int n, List<String> stringList, String currString) {
        if(stringList.size() == n) {
            return;
        }

        char[] bytes = currString.toCharArray();
        StringBuilder binary = new StringBuilder();
        for(char b : bytes) {
            binary.append(b == '1' ? "0" : "1");
        }
        currString = currString + "1" + binary.reverse();
        stringList.add(currString);
        findAllStrings(n , stringList, currString);
    }

    public char findKthBit(int n, int k) {
        List<String> stringsList = new ArrayList<>();
        stringsList.add("1");
        findAllStrings(n, stringsList, "0");
        return stringsList.get(n - 1).charAt(k - 1);
    }

    public static void main(String[] args) {
        Problem1545$FindKthBitInNthBinaryString obj = new Problem1545$FindKthBitInNthBinaryString();
        System.out.println(obj.findKthBit(3, 1));
        System.out.println(obj.findKthBit(4, 11));
    }
}

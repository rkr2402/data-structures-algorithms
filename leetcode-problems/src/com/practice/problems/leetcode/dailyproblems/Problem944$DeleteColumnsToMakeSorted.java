package com.practice.problems.leetcode.dailyproblems;

public class Problem944$DeleteColumnsToMakeSorted {

    /*public int minDeletionSize(String[] strs) {
        if (strs.length <= 1) return 0;

        int count = 0;
        char[] prev = new char[strs[0].length()];
        boolean[] isSorted = new boolean[strs[0].length()];
        for (int i = 0; i < strs[0].length(); i++) {
            prev[i] = strs[0].charAt(i);
            isSorted[i] = true;
        }

        for (int string = 1; string < strs.length; string++) {
            String str = strs[string];
            for (int i = 0; i < str.length(); i++) {
                if(prev[i] > str.charAt(i) && isSorted[i]) {
                    count++;
                    isSorted[i] = false;
                }
                prev[i] = str.charAt(i);
            }
        }

        return Math.min(count, strs[0].length());
    }*/

    public int minDeletionSize(String[] strs) {
        // String length.
        int K = strs[0].length();

        // Variable to store the count of columns to be deleted.
        int answer = 0;
        // Iterate over each index in the string.
        for (int col = 0; col < K; col++) {
            // Iterate over the strings.
            for (int row = 1; row < strs.length; row++) {
                // Characters should be in increasing order,
                // If not, increment the counter.
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem944$DeleteColumnsToMakeSorted obj = new Problem944$DeleteColumnsToMakeSorted();
        System.out.println(obj.minDeletionSize(new String[]{"abc", "bce", "cae"}));
        System.out.println(obj.minDeletionSize(new String[]{"cba","daf","ghi"}));
        System.out.println(obj.minDeletionSize(new String[]{"a","b"}));
        System.out.println(obj.minDeletionSize(new String[]{"zyx","wvu","tsr"}));
        System.out.println(obj.minDeletionSize(new String[]{"egguij","gjsnnk","lstgon","ztzrqv"}));
    }
}

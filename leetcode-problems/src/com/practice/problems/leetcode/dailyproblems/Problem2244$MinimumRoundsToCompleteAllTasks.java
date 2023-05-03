package com.practice.problems.leetcode.dailyproblems;

import java.util.Map;
import java.util.TreeMap;

public class Problem2244$MinimumRoundsToCompleteAllTasks {

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> taskMap = new TreeMap<>();

        for (Integer difficultyLevel : tasks) {
            Integer count = 0;
            if((count = taskMap.get(difficultyLevel)) == null) {
                taskMap.put(difficultyLevel, 1);
            } else {
                taskMap.put(difficultyLevel,++count);
            }
        }

        int result = 0;

        for(Map.Entry<Integer,Integer> entry : taskMap.entrySet()) {
            if(entry.getValue() < 2) return -1;

            int count = entry.getValue();
            if(count % 3 == 0) {
                result = result + count/3;
            } else if(count % 3 == 1) {
                result = result + (count/3) + 1;
            } else {
                result = result + (count/3) + 1;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        Problem2244$MinimumRoundsToCompleteAllTasks obj = new Problem2244$MinimumRoundsToCompleteAllTasks();
        System.out.println(obj.minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
        System.out.println(obj.minimumRounds(new int[]{2, 3, 3}));
    }
}

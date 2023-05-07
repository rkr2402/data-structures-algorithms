package com.practice.problems.leetcode.contests.weekly.contest344;

import java.util.*;

public class FrequencyTracker {

    private Map<Integer, Integer> numbersCountMap = null;
    private Map<Integer, LinkedList<Integer>> numbersFrequencyMap = null;


    public FrequencyTracker() {
        numbersCountMap = new HashMap<>();
        numbersFrequencyMap = new HashMap<>();
    }

    public void add(int number) {
        Integer count;

        if((count = numbersCountMap.get(number)) != null) {
            int currCount = count;
            count++;
            numbersCountMap.put(number, count);
            //update numbersFrequencyMap
            updateNumbersFrequencyMap(number, currCount, count);
        } else {
            numbersCountMap.put(number, 1);
            //update numbersFrequencyMap
            updateNumbersFrequencyMap(number, 0, 1);
        }
    }

    private void updateNumbersFrequencyMap(int number, int currentCount, int newCount) {
        LinkedList<Integer> nums;
        //remove num from current list
        if(currentCount != 0 && (nums = numbersFrequencyMap.get(currentCount)) != null) {
            nums.remove(new Integer(number));
            if(nums.isEmpty()) {
                numbersFrequencyMap.remove(currentCount);
            } else {
                numbersFrequencyMap.put(currentCount, nums);
            }
        }

        if(newCount < 1) {
            return;
        }
        //add num to list
        nums = null;
        if((nums = numbersFrequencyMap.get(newCount)) != null) {
            nums.add(number);
            numbersFrequencyMap.put(newCount, nums);
        } else {
            nums = new LinkedList<>();
            nums.add(number);
            numbersFrequencyMap.put(newCount, nums);
        }
    }


    public void deleteOne(int number) {
        Integer count;
        if((count = numbersCountMap.get(number)) != null) {
            int currCount = count;
            count--;
            numbersCountMap.put(number, count);
            if(count == 0) numbersCountMap.remove(number);
            //update numbersFrequencyMap
            updateNumbersFrequencyMap(number, currCount, count);
        }
    }

    public boolean hasFrequency(int frequency) {
        return numbersFrequencyMap.containsKey(frequency);
    }

    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        frequencyTracker.add(3);
        frequencyTracker.add(3);
        System.out.println(frequencyTracker.hasFrequency(2));

        FrequencyTracker frequencyTracker2 = new FrequencyTracker();
        frequencyTracker2.add(1);
        frequencyTracker2.deleteOne(1);
        System.out.println(frequencyTracker2.hasFrequency(1));

        FrequencyTracker frequencyTracker3 = new FrequencyTracker();
        frequencyTracker3.add(5);
        frequencyTracker3.add(4);
        frequencyTracker3.deleteOne(6);
        frequencyTracker3.deleteOne(4);
        frequencyTracker3.deleteOne(7);
        System.out.println(frequencyTracker3.hasFrequency(1));

        FrequencyTracker frequencyTracker4 = new FrequencyTracker();
        frequencyTracker4.deleteOne(6);
        System.out.println(frequencyTracker4.hasFrequency(1));//false
        frequencyTracker4.deleteOne(5);
        frequencyTracker4.add(10);
        System.out.println(frequencyTracker4.hasFrequency(1));//true
        System.out.println(frequencyTracker4.hasFrequency(1));//true
        frequencyTracker4.add(2);
        frequencyTracker4.deleteOne(10);
        frequencyTracker4.add(9);
        System.out.println(frequencyTracker4.hasFrequency(1));//true
        frequencyTracker4.add(10);
        frequencyTracker4.deleteOne(2);
        System.out.println(frequencyTracker4.hasFrequency(1));//true
        System.out.println(frequencyTracker4.hasFrequency(1));//true
        System.out.println(frequencyTracker4.hasFrequency(2));//false
        frequencyTracker4.deleteOne(7);
        frequencyTracker4.deleteOne(7);

        FrequencyTracker frequencyTracker5 = new FrequencyTracker();
        frequencyTracker5.add(6);
        frequencyTracker5.add(9);
        frequencyTracker5.add(6);
        frequencyTracker5.add(6);
        System.out.println(frequencyTracker5.hasFrequency(3));
    }
}

package com.practice.problems.leetcode.dailyproblems;

import java.util.Arrays;
import java.util.Collections;

public class Problem1833$MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        int icecreamCount = 0;

        int[] costs1 = Arrays.stream(costs).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        Arrays.sort(costs);
//        costs = Collections.reverseOrder(this);

        while (icecreamCount < costs.length && costs[icecreamCount] <= coins) {
            coins = coins - costs[icecreamCount];
            icecreamCount += 1;
        }

        return icecreamCount;
    }

    private int f(int[] costs, int coins, int index) {
        //base case
        if(index == 0) {
            return coins >= costs[0] ? 1 : 0;
        }

        //recursive case
        int notTake = f(costs, coins, index - 1);
        int take = Integer.MIN_VALUE;
        if(coins >= costs[index])
            take = 1 + f(costs, coins - index, index - 1);

        return Math.max(take, notTake);
    }

    public static void main(String[] args) {
        Problem1833$MaximumIceCreamBars obj = new Problem1833$MaximumIceCreamBars();
        System.out.println(obj.maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));//4
        System.out.println(obj.maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));//0
        System.out.println(obj.maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));//6
    }
}

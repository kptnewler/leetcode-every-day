package com.newler.leetcode.array;
// [70]、爬楼梯
// 2020年6月2日21:11:13
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划


public class ClimbingStairs {
    /**
     * 斐波拉契数列
     * f1: 1
     * f2: 2
     * f3  f(2) + f(1) 3
     * f4  f(2)+f(3)
     * f5
     */
    class Solution {
        /**
         * dp公式
         */
        public int climbStairs(int n) {
            int[] dp = new int[n];
            if (n > 0) {
                dp[0] = 1;
            }
            if (n>1) {
                dp[1] = 2;
            }
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }

            return dp[n-1];
        }
    }


    /**
     * 斐波拉契数列
     */
    class Solution2 {
        public int climbStairs(int n) {
            if (n==1) {
                return 1;
            }
            int first = 1;
            int second = 2;
            int third ;
            // a[0] = a[1]  a[1] = a[2]，类似这种操作
            for (int i = 3; i <= n; i++) {
                third = first + second;
                first = second;
                second = third;
            }

            return second;
        }
    }

    /**
     * 解法三：斐波拉契公式
     */
}
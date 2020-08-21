package com.newler.leetcode.divideandconquer;
// [50]、Pow(x, n)
// 2020年8月17日15:10:39
//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找 
// 👍 471 👎 0


/**
 * 递归分治法
 */
public class PowxN {
    class Solution {
        public double myPow(double x, int n) {
            if (n < 0) {
                x = 1.0 / x;
                n = -n;
            }
            return fastCalc(x, n);
        }

        public double fastCalc(double x, int n) {
            if (n == 0) return 1.0;
            double result = fastCalc(x, n / 2);
            if (n % 2 == 0) {
                return result * result;
            } else {
                return result * result * x;
            }
        }
    }

    /**
     * 非递归
     */
    class Solution2 {
        public double myPow(double x, int n) {
            if (n < 0) {
                x = 1.0 / x;
                n = -n;
            }
            double result = 1;
            while (n > 0) {
                if (n % 2 == 1) {
                    result *= x;
                }
                x *= x;
                n /=2;
            }
            return result;
        }
    }

}


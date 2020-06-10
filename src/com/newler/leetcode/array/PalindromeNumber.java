package com.newler.leetcode.array;
// [9]、回文数
// 2020年6月10日21:04:31
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学


public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPalindrome(1222221);
    }
    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            if (x < 10) return true;
            int tmpX = x;
            int count = -1;
            while (tmpX > 0) {
                tmpX = tmpX / 10;
                count++;
            }

            int i = 0;
            int j = count;
            while (i<j && x > 0) {
                int left = x / (int)Math.pow(10.0, count);
                int right = x % 10;
                if (left != right) return false;
                x = x % (int)Math.pow(10.0, count)/10;
                i++;
                j--;
                count-=2;
            }
            return true;
        }
    }

    /**
     * 反转一半
     */
    class Solution2 {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            if (x < 10) return true;
            if (x % 10 ==0) return true;

            int reverseNum = 0;
            while (x > reverseNum) {
                reverseNum = reverseNum*10 + x %10;
                x  /= 10;
            }

            return reverseNum == x || x == reverseNum/10;
        }
    }
}


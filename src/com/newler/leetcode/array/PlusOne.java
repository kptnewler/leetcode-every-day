package com.newler.leetcode.array;
// [66]、加一

//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组


import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {9,9,9};
        solution.plusOne(nums);
    }

    /**
     * 自己想的
     */
    static class Solution {
        public int[] plusOne(int[] digits) {
            int plus = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                int result = digits[i] + (i == digits.length-1 ? 1:0) + plus;
                digits[i] =  result % 10;
                plus = result / 10;
            }

            // 如果最高位为1，那么后面所有的位数均为0
            if (plus == 1) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            }
            return digits;
        }
    }

    /**
     * 简洁写法
     */
    class Solution2 {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10;
                if (digits[i] != 0) return digits;
            }
            digits = new int[digits.length+1];
            digits[0] = 1;
            return digits;
        }
    }
}
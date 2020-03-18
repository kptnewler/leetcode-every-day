package com.newler.leetcode.other;
// [268]、缺失数字

//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
//
// 示例 1:
//
// 输入: [3,0,1]
//输出: 2
//
//
// 示例 2:
//
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
//
//
// 说明:
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
// Related Topics 位运算 数组 数学


public class MissingNumber {
    /**
     * 解法一：求和
     */
    class Solution {

        public int missingNumber(int[] nums) {
            int sum = nums.length * (nums.length+1) / 2;
            for (int num : nums) {
                if (num >= 0 && num <= nums.length) {
                    sum -= num;
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
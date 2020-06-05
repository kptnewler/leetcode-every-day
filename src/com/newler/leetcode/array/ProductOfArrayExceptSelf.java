package com.newler.leetcode.array;
// [238]、除自身以外数组的乘积
// 2020年6月4日18:40:44
//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。
//
//
//
// 示例:
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6]
//
//
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
//
// 进阶：
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
// Related Topics 数组


import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};
        Solution solution = new Solution();
        int[] ints = solution.productExceptSelf(nums);
        Arrays.stream(ints).forEach(System.out::println);
    }

    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] suffix = new int[nums.length];
            int[] prefix = new int[nums.length];
            int[] results = new int[nums.length];
            prefix[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                prefix[i] = nums[i-1] * prefix[i - 1];
            }
            suffix[nums.length - 1] = 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] * nums[i+1];
            }

            for (int i = 1; i < nums.length - 1; i++) {
                results[i] = prefix[i] * suffix[i];
            }

            return results;
        }
    }


    class Solution2 {
        public int[] productExceptSelf(int[] nums) {
            int[] results = new int[nums.length];

            int k = 1;
            for (int i = 0; i < nums.length; i++) {
                // 始终保存nums[i] 左边的乘积
                results[i] = k;
                k *= nums[i];
            }

            k = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                results[i] *= k;
                k *= nums[i];
            }
            return results;
        }
    }
}


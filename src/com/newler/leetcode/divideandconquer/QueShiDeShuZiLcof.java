package com.newler.leetcode.divideandconquer;
// [剑指 Offer 53 - II]、0～n-1中缺失的数字
// 2021年3月10日21:01:10
//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 数组 二分查找 
// 👍 111 👎 0


public class QueShiDeShuZiLcof {
    public static void main(String[] args) {
        int nums[] = {0,1,2,3,4,5,6,7,8};
        Solution solution = new Solution();
        solution.missingNumber(nums);
    }
    static class Solution {
        public int missingNumber(int[] nums) {
            int start = 0, end = nums.length- 1;
            while (start < end) {
                int mid = (start + end) / 2;
                if (nums[mid] <= mid) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            if (nums[start] == start) {
                return start+1;
            }
            return start;
        }
    }

}


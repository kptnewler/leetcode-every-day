package com.newler.leetcode.binary;
// [34]、在排序数组中查找元素的第一个和最后一个位置

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 887 👎 0


import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = searchLeft(nums, target);
            int right = searchRight(nums, target);
            return new int[]{left, right};
        }

        private int searchLeft(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    right = mid - 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (left < nums.length) {
                return left;
            }
            return -1;
        }

        private int searchRight(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            // 终止条件是 left = right + 1，left最坏情况是 num.length 可能引发数组越界
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left < nums.length) {
                return right;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
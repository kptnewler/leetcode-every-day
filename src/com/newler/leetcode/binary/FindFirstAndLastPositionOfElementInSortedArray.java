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
            int l = 0, r = nums.length - 1;
            int first = -1, second = -1;
            int[] results = new int[2];
            Arrays.fill(results, -1);
            while (l <= r) {
                int mid = l + (r-l) / 2;
                if (target < nums[mid]) {
                    r = mid - 1;
                } else if (target > nums[mid]) {
                    l = mid + 1;
                } else {
                    int tmp = mid;
                    while (tmp > 0 && nums[tmp - 1] == nums[tmp]) {
                        tmp --;
                    }
                    results[0] = mid;
                    while (mid < nums.length && nums[mid + 1] == nums[mid]) {
                        mid++;
                    }
                    results[1] = mid;
                }
            }
            return results;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
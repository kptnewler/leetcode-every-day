package com.newler.leetcode.binary;
// [153]、寻找旋转排序数组中的最小值

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。 
//
// 请找出其中最小的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数都是 唯一 的 
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转 
// 
// Related Topics 数组 二分查找 
// 👍 338 👎 0


public class FindMinimumInRotatedSortedArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length-1;
            int mid = 0;
            // 单调递增
            if (nums[right] >= nums[left]) return nums[left];

            while (left < right) {
                mid = (left+right)/2;
                if (nums[mid] > nums[mid+1]) {
                    return mid+1;
                }

                if (nums[mid-1] > nums[mid]) {
                    return mid;
                }

                if (nums[mid] > nums[0]) {
                    // 如果中间值>起始值，左边单调递增，找右边
                    left = mid + 1;
                } else {
                    // 如果中间值<起始值，右边单调递增，找左边
                    right = mid - 1;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
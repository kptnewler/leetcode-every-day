package com.newler.leetcode.binary;
// [154]、寻找旋转排序数组中的最小值 II

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 注意数组中可能存在重复的元素。 
//
// 示例 1： 
//
// 输入: [1,3,5]
//输出: 1 
//
// 示例 2： 
//
// 输入: [2,2,2,0,1]
//输出: 0 
//
// 说明： 
//
// 
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。 
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 226 👎 0


public class FindMinimumInRotatedSortedArrayIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1;

            while (left < right) {
                int mid = (left+right) / 2;

                if (nums[mid] > nums[right]) {
                    // 如果大于右边界，说明左边整体比右边高，最小值在右边
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    // 如果小于右边界，说明左边整体比右边低，最小值在左边
                    // 由于mid也比right，最小值就可能包括mid
                    right = mid;
                } else {
                    // 如果相等，则不确定，缩小范围，去除重复值，继续判断
                    right--;
                }
            }
            return nums[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
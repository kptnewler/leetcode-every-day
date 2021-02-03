package com.newler.leetcode.binary;
// [33]、搜索旋转排序数组

//升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
// 
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 1159 👎 0

/**
 * 两种方法
 * 1、找极点，分段找
 * 2、直接干
 */
public class SearchInRotatedSortedArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 找到临界点
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,1,3};
        solution.search(nums, 3);
    }
    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            if (nums[right] < nums[left]) {
                while (left < right) {
                    int mid = (left + right) / 2;

                    if (nums[mid] > nums[right]) {
                        // 中间值比最右边值大，说明左边单调递增找右边
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            }
            System.out.println(left);

            // 分成两部分找
            Integer midIndex =findTragetIndex(nums, target, left, nums.length-1);
            if (midIndex != null) {
                 return midIndex;
            }
            midIndex = findTragetIndex(nums, target, 0,  left - 1);
            if (midIndex != null) return midIndex;
            return -1;
        }


        private Integer findTragetIndex(int[] nums, int target, int left, int right) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
            return null;
        }
    }

    class Solution2 {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = (right + left) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] > nums[right]) {
                    // 左边是单调增, 如果在左边界范围内，在左边找
                    if (nums[mid] > target && nums[left] <= target) {
                        right = mid-1;
                    } else {
                        left = mid+1;
                    }
                } else {
                    // 如果右边是单调增,在右边界范围内
                    if (nums[right] >= target && nums[mid] < target) {
                        left = mid+1;
                    } else {
                        right = mid-1;
                    }
                }
            }
            return -1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
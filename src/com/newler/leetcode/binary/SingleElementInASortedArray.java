package com.newler.leetcode.binary;
// [540]、有序数组中的单一元素
// 2021年2月7日23:20:48
//给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
//
// 示例 1:
//
//
//输入: [1,1,2,3,3,4,4,8,8]
//输出: 2
//
//
// 示例 2:
//
//
//输入: [3,3,7,7,10,11,11]
//输出: 10
//
//
// 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
// Related Topics 二分查找
// 👍 193 👎 0


public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int nums[] = {1,1,2,3,3,4,4,8,8};
        Solution solution = new Solution();
        System.out.println(solution.singleNonDuplicate(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int singleNonDuplicate(int[] nums) {
            if (nums.length == 1) return nums[0];
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;

                if (nums[mid] == nums[mid - 1]) {
                    if ((right - mid) % 2 == 1) {
                        left = mid + 1;
                    } else {
                        right = mid - 2;
                    }
                } else if (nums[mid+1] == nums[mid]) {
                    if ((mid - left) % 2== 1) {
                        right = mid - 1;
                    } else {
                        left = mid + 2;
                    }
                } else {
                    return nums[mid];
                }
            }
            return nums[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
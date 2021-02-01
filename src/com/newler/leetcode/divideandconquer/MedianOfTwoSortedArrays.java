package com.newler.leetcode.divideandconquer;
// [4]、寻找两个正序数组的中位数

//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3632 👎 0


public class MedianOfTwoSortedArrays {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length = nums1.length + nums2.length;
            if (length % 2 == 1) {
                // 如果是奇数，mid
                int k = length / 2 + 1;
                return getKeyElement(nums1, nums2, k, 0, 0);
            } else {
                // 如果是偶数, 分别是第mid - 1和mid
                int k1 = length / 2 + 1;
                int k2 = length / 2;
                return (getKeyElement(nums1, nums2, k1, 0, 0) +
                        getKeyElement(nums1, nums2, k2, 0, 0)) / 2.0;
            }
        }

        public int getKeyElement(int[] nums1, int[] nums2, int k, int index1, int index2) {
            // 极端情况，等于边界相当于全部排除
            if (index1 == nums1.length) {
                return nums2[index2 + k - 1];
            }

            if (index2 == nums2.length) {
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, nums1.length) - 1;
            int newIndex2 = Math.min(index2 + half, nums2.length) - 1;

            if (nums1[newIndex1] < nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                return getKeyElement(nums1, nums2, k, newIndex1+1, index2);
            } else {
                k -= (newIndex2 - index2 + 1);
                return getKeyElement(nums1, nums2, k, index1, newIndex2+1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
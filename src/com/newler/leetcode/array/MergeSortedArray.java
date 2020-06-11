package com.newler.leetcode.array;
// [88]、合并两个有序数组
// 2020年6月2日18:36:02
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 通过暴力，一个个比较，插入排序
 * 2. 将数量为n的数组，全部插入到数组m+n的后面，重新排序, 时间复杂度nlog(n)
 * 3. 一次性移动
 */
public class MergeSortedArray {
    /**
     * 先合并，再排序，时间复杂度O(m+n)
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = m, j = 0; i < m + n && j < n; i++, j++) {
                nums1[i] = nums2[j];
            }

            Arrays.sort(nums1);
        }
    }

    /**
     *
     */
    class Solution2 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] num1Copy = new int[m];
            int i = 0, j = 0, k = 0;
            System.arraycopy(nums1, 0, num1Copy, 0, m);

            while (i < m && j < n) {
                nums1[k++] = num1Copy[i] > nums2[j] ? nums2[j++] : num1Copy[i++];
            }

            if (i < m) {
                System.arraycopy(num1Copy, i, nums1, k, m + n - k);
            }
            if (j < n)
                System.arraycopy(nums2, j, nums1, k, m + n - k);
        }
    }

    class Solution3 {
        /**
         * 从后往前，大的放到后面
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m-1, j = n-1, k = m+n-1;
            while (i >=0 && j >= 0) {
                nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            }
            if (j >= 0) {
                System.arraycopy(nums2, 0, nums1, 0, j+1);
            }
        }
    }
}



package com.newler.leetcode.heap;

import com.newler.leetcode.utils.Swaps;
/**
* [215] 数组中的第 K 个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * 提示：
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
*/
public class FindKthLargest {
    public static void main(String[] args) {
        int[] arrays = {5,2,4,1,3,6,0};
        int a = findKthLargest(arrays, 4);
        System.out.println(a);
    }

    public static int findKthLargest(int[] nums, int k) {

        partation(nums, 0, nums.length - 1, k);
        return nums[k-1];
    }

    private static void selectKey(int[] nums, int start, int end) {
        int c = (start + end) / 2;
        if (nums[start] < nums[end]) {
            Swaps.swapIntArray(nums, start, end);
        }

        if (nums[start] > nums[c]) {
            Swaps.swapIntArray(nums, start, c);
        }
    }



    public static void partation(int[] nums, int start, int end, int k) {
        if (start >= end) return;
        selectKey(nums, start, end);

        int i = start;
        int j = end;
        int key = nums[start];
        while (i < j) {
            while (i < j && nums[j] < key) j--;
            if (i < j) nums[i++] = nums[j];

            while (i < j && nums[i] > key) i++;
            if (i < j) nums[j--] = nums[i];
        }

        nums[i] = key;

        if (i == k - 1) return;

        if (k - 1 < i) {
            partation(nums, start, i - 1, k);
        } else {
            partation(nums, i + 1, end, k);
        }
    }

}

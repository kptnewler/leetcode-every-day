package com.newler.leetcode.sort;
// [912]、排序数组
// 2021年3月16日20:35:04
//给你一个整数数组 nums，请你将该数组升序排列。 
// 排序算法训练合集
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 235 👎 0


import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortArray6(new int[]{5,1,1,2,0,0});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        /**
         * 冒泡排序，和相邻元素比较，比他大就调换位置
         */
            public int[] sortArray(int[] nums) {
                boolean flag = true;
                for (int i = 0; i < nums.length; i++) {
                    flag = true;
                    for (int j = 0; j < nums.length - i - 1; j++) {
                        if (nums[j] > nums[j+1]) {
                            int tmd = nums[j];
                            nums[j] = nums[j+1];
                            nums[j+1] = tmd;
                            flag = false;
                        }
                    }
                    if (flag) break;
                }
                return nums;
            }

        /**
         * 插入排序，前部分作为排序，后面和前面比较，比前面小，排序区就往后挪动位置
         * 稳定算法 O(n^2)
         */
        public int[] sorArray2(int[] nums) {
            // TODO 明天再來
            Arrays.sort(new int[]{1,2});
            return nums;
        }

        /**
         * 选择排序，找出最小的，放到第一个
         * O(n^2) 不稳定
         */
        public int[] sortArray3(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int minIndex = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[minIndex]) {
                        minIndex = j;
                    }
                }
                // 不相等才调换
                if (nums[minIndex] != nums[i]) {
                    int tmp = nums[i];
                    nums[i] = nums[minIndex];
                    nums[minIndex] = tmp;
                }
            }
            return nums;
        }

        /**
         * 归并排序
         */
        public int[] sortArray4(int[] nums) {
            subSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void subSort(int[] nums, int l, int r) {
            if (l >= r) return;
            int m = (l + r) / 2;

            subSort(nums, l, m);
            subSort(nums, m + 1, r);

            mergeSortArray(nums, l, m, r);
        }

        private void mergeSortArray(int[] nums, int l, int m, int r) {
            int[] tmpArray = new int[r - l + 1];
            int i = l, j = m + 1, k = 0;
            while (i <= m && j <= r) {
                // 谁小谁放到数组中
                if (nums[i] < nums[j]) {
                    tmpArray[k++] = nums[i++];
                } else {
                    tmpArray[k++] = nums[j++];
                }
            }

            // 还有剩余添加到末尾
            while (i <= m) {
                tmpArray[k++] = nums[i++];
            }

            while (j <= r) {
                tmpArray[k++] = nums[j++];
            }

            System.arraycopy(tmpArray, 0, nums, l, tmpArray.length);
        }

        /**
         * 快速排序
         */
        public int[] sortArray5(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        public void quickSort(int[] nums, int l, int r) {
            if (l >= r) return;
            int p = partition(nums, l, r);
            quickSort(nums, l, p - 1);
            quickSort(nums, p + 1, r);
        }

        /**
         * 分成两个部分处理区和非处理区
         * i为分区点
         * 小于分区点(l, i -1)
         * 大于分区点(i, r-1)
         * O(nlogn)
         */
        public int partition(int[] nums, int l, int r) {
            int partition = nums[r];

            // A[l...i-1]的元素都是小于 pivot 的，我们暂且叫它“已处理区间”
            int i = l;

            // 遍历未处理区
            for (int j = l; j < r; j++) {
                if (nums[j] < partition) {
                    swap(nums, i, j);
                    // 处理区扩大1
                    i++;
                }
            }

            swap(nums, i, r);

            return i;
        }

        public int[] sortArray6(int[] nums) {
            int n = nums.length;
            for (int i = (n - 1) / 2; i >= 0; i--) {
                heap(nums, i, nums.length);
            }
            for (int i = 0; i < n - 1; i++) {
                swap(nums, 0, nums.length - i - 1);
                heap(nums, 0, n-i-1);
            }
            return nums;
        }

        public void heap(int[] nums, int i, int n) {
            while (true) {
                int maxPos = i;
                if (i * 2 + 2 < n && nums[i * 2 + 2] > nums[maxPos]) {
                    maxPos = i * 2 + 2;
                }
                if (i * 2 + 1 < n && nums[i * 2 + 1] > nums[maxPos]) {
                    maxPos = i * 2 + 1;
                }
                if (maxPos == i) break;;
                swap(nums, maxPos, i);
                i = maxPos;
            }
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/**
 *           for (int i = 0; i < nums.length-1; i++) {
 *                 // 未处理区第一个元素
 *                 int a = nums[i+1];
 *                 // 处理区
 *                 int j = i;
 *                 // 从处理区从前往后比较
 *                 for (; j >= 0; j--) {
 *                     if (a < nums[j]) {
 *                          //  不断向后挪动位置 1->3->4->2  1->3->4->4 1->3->3->4 1->2->3->4
 *                         nums[j+1] = nums[j];
 *                     } else {
 *                         // 找到了跳出
 *                         break;
 *                     }
 *                 }
 *                 nums[j+1] = a;
 *             }
 *             return nums;
 */
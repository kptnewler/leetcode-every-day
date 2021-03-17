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
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 冒泡排序，和相邻元素比较，比他大就调换位置
         */
        public int[] sortArray(int[] nums) {
            boolean flag;
            for (int i = 0; i < nums.length; i++) {
                flag = false;
                for (int j = 0; j < nums.length - i - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int tmp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = tmp;
                        flag = true;
                    }
                }
                if (!flag) break;
            }
            return nums;
        }

        /**
         * 插入排序，前部分作为排序，后面和前面比较，比前面小，排序区就往后挪动位置
         */
        public int[] sorArray2(int[] nums) {
            // 前面是排序区
            for (int i = 1; i < nums.length; i++) {
                int value = nums[i];
                int j = i - 1;
                for (; j >= 0; j--) {
                    // 比前面小，往后移动
                    if (value < nums[j]) {
                        nums[j + 1] = nums[j];
                    } else {
                        break;
                    }
                }
                // 上面被--了
                nums[j + 1] = value;
            }
            return nums;
        }

        /**
         * 选择排序，找出最小的，放到第一个
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
            int i = l;
            int j = m + 1;
            int k = 0;
            while (i <= m && j <= r) {
                if (nums[i] < nums[j]) {
                    tmpArray[k++] = nums[i];
                    i++;
                } else {
                    tmpArray[k++] = nums[j];
                    j++;
                }
            }
            if (i <= m) {
                while (i <= m) {
                    tmpArray[k++] = nums[i++];
                }
            }

            if (j <= r) {
                while (j <= r) {
                    tmpArray[k++] = nums[j++];
                }
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
         * 处理区(l, i -1)
         * 非处理区(i, r-1)
         */
        public int partition(int[] nums, int l, int r) {
            int i = l;
            for (int j = l; j < r; j++) {
                // 如果比区点小，插入到处理区
                if (nums[j] < nums[r]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    // 处理区变大
                    i++;
                }
            }

            // 把区点换到处理区，一分为二
            int tmp = nums[i];
            nums[i] = nums[r];
            nums[r] = tmp;

            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


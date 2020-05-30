package com.newler.leetcode.array;
// [283]、移动零
// 2020年5月28日09:29:05
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针


import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int nums[] = {1,3,12,0,0};
        solution.moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
    /**
     * 时间复杂度0(n)
     * 保存当前为0的位置，找到下一个不为0的值，进行交换，蠢办法
     */
    static class Solution {
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    if (j < i) {
                        j = i+1;
                    }
                    while (j < nums.length) {
                        if (nums[j] != 0) {
                            nums[i] = nums[j];
                            nums[j] = 0;
                            break;
                        }
                        j++;
                    }
                }
            }
        }
    }

    static class Solution2 {
        /**
         * 高明的方法，双指针，当num[i]不为0时，赋值给j，num[i]置为0，依次将不为0的值往前挪动。
         */
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    if (i != j) {
                        nums[j] = nums[i];
                        nums[i] = 0;
                    }
                    j++;
                }
            }
        }
    }
}


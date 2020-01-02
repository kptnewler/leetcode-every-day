package com.newler;
//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。


import java.util.Arrays;

class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static int removeDuplicates(int[] nums) {
        int sum = 0;
        int index = -1;
        boolean first = true;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i] = Integer.MAX_VALUE;
                sum++;
            }
            // 找到第一个重复项
            if (first) {
                index = i;
                first = false;
            }
        }

        // 如果没有重复项直接输出
        if (index == -1) {
            return nums.length - sum;
        }

        // 交换位置，把重复项移动到最后
        for (int i = index; i < nums.length -1; i++) {
            if (nums[i+1] != Integer.MAX_VALUE) {
                int swap = nums[i+1];
                nums[i+1] = nums[index];
                nums[index] = swap;
                index++;
            }

        }
        return nums.length - sum;
    }
}

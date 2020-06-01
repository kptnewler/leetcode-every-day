package com.newler.leetcode.array;
// [1]、两数之和

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 1. 暴力搜索 o(n^2)
 * 2. 使用hash表 o(n),空间换时间
 * 3.
 */
public class TwoSum {
    class Solution {

        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> posMap = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                if (posMap.containsKey(target - nums[i])) {
                    return new int[] {i, posMap.get(target - nums[i])};
                }
                posMap.put(nums[i], i);
            }
            return new int[2];
        }
    }

}
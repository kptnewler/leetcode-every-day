package com.newler.leetcode.recursion;
// [47]、全排列 II
// 2020年8月26日18:42:07
//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 381 👎 0


import com.newler.leetcode.utils.Swaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {1,1,2};
        solution.permuteUnique(nums);
    }

    /**
     * 重复就使用user数组
     */
    static class Solution {
        private List<List<Integer>> results = new LinkedList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            boolean[] used = new boolean[nums.length];
            backTrack( nums, new ArrayList<>(), used);
            return results;
        }

        private void backTrack(int[] nums, List<Integer> paths, boolean[] used) {
            if (paths.size() == nums.length) {
                results.add(new ArrayList<>(paths));
            }

            for (int i = 0; i < nums.length; i++) {
                if ((i > 0 && nums[i] == nums[i - 1] &&!used[i-1]) || used[i]) {
                    continue;
                }
                paths.add(nums[i]);
                used[i] = true;
                backTrack(nums, paths, used);
                used[paths.size() - 1] = false;
                paths.remove(paths.size() - 1);
            }
        }
    }

}


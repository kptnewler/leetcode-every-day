package com.newler.leetcode.recursion;
// [40]、组合总和 II
// 2020年8月23日22:04:38
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIi {
    /**
     * 回溯算法+剪枝
     */
    class Solution {
        private List<List<Integer>> results = new LinkedList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backTrack(0, new ArrayList<>(), candidates, target);
            return results;
        }

        public void backTrack(int cur, List<Integer> paths, int[] candidates, int target) {
            if (target == 0) {
                results.add(new ArrayList<>(paths));
                return;
            }

            for (int i = cur; i < candidates.length; i++) {
                if (i > cur && candidates[i] == candidates[i - 1]) continue;
                if (target - candidates[i] >= 0) {
                    paths.add(candidates[i]);
                    backTrack(i + 1, paths, candidates, target - candidates[i]);
                    paths.remove(paths.size() - 1);
                } else {
                    break;
                }
            }
        }
    }

}
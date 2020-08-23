package com.newler.leetcode.recursion;
// [39]、组合总和

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,4};
//        solution.backTrack(7, new ArrayList<>(), nums, 0);
        Arrays.sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
    static class Solution {
        private List<List<Integer>> results = new LinkedList<List<Integer>>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            backTrack(target, new ArrayList<>(), candidates, 0);
            return results;
        }

        public void backTrack(int target, List<Integer> paths, int[] candidates, int cur) {
            if (0 == target) {
                results.add(new ArrayList<>(paths));
                return;
            }

            for (int i = cur; i < candidates.length; i++) {
                if (target-candidates[i] >= 0) {
                    paths.add(candidates[i]);
                    backTrack(target - candidates[i], paths, candidates, i);
                    paths.remove(paths.size()-1);
                } else {
                    break;
                }
            }
        }
    }

}
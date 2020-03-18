package com.newler.leetcode.queue;
// [78]、子集

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


import java.util.ArrayList;
import java.util.List;

public class Subsets {
    //leetcode submit region begin(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        solution.subsets(nums).forEach(list-> {
            list.forEach(System.out::print);
            System.out.println();
        });
    }
    static class Solution {
        /**
         * 题解1：某往后移动一位，就在前面数组的基础上增加一位
         * 比如1,2,3
         * 开始{[]}
         * 遍历到1时，在[]的基础上增加1,即为[1],{[],[1]}
         * 遍历到2时，在[],[1]的基础增加2，即为{[],[1],[2],[1,2]}
         * 遍历到3时，在{[],[1],[2],[1,2]}的基础上增加3，{[],[1],[2],[1,2],[1,3],[2,3][1,2,3],[3]}
         */
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            results.add(new ArrayList<>());

            for (int num : nums) {
                int size = results.size();
                for (int i = 0; i < size; i++) {
                    List<Integer> subsets = new ArrayList<>(results.get(i).size()+1);
                    subsets.addAll(results.get(i));
                    subsets.add(num);
                    results.add(subsets);
                }
            }

            return results;
        }
    }

}
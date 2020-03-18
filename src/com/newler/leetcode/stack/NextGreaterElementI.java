package com.newler.leetcode.stack;
// [496]、下一个更大元素 I

//给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其
//大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。 
//
// 示例 1: 
//
// 
//输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
//    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
//    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。 
//
// 示例 2: 
//
// 
//输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于num1中的数字2，第二个数组中的下一个较大数字是3。
//    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
// 
//
// 注意: 
//
// 
// nums1和nums2中所有元素是唯一的。 
// nums1和nums2 的数组大小都不超过1000。 
// 
// Related Topics 栈


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,4};
        Arrays.stream(solution.nextGreaterElement(nums1, nums2)).forEach(System.out::println);
    }

    /**
     * 解法1：暴力解决
     * o(n^2)，8ms,39.3
     */
    static class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] results = new int[nums1.length];
            Arrays.fill(results, -1);
            boolean find;
            for (int i = 0; i < nums1.length; i++) {
                find = false;
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        find = true;
                    }
                    if (find && nums2[j] > nums1[i]) {
                        results[i] = nums2[j];
                        break;
                    }
                }
            }
            return results;
        }
    }

    /**
     * 解法二：单调栈
     * O(n)
     */
    static class Solution2 {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>(nums2.length);
            int[] results = new int[nums1.length];
            // 栈存储索引
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums2.length; i++) {
                // 如果nums2[栈顶值]比nums2[当前值]小，说明离nums2[栈顶值]最近的右侧索引即为当前比较的索引
                // 如[5,3,4],栈内值为{5,3}，4比栈顶值3大
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    map.put(nums2[stack.pop()], nums2[i]);
                }
                stack.push(i);
            }

            // 如果栈最后有余下索引，说明其右侧无值比这些索引对应的值大
            for (int i = 0; i < nums1.length; i++) {
                results[i] = map.getOrDefault(nums1[i], -1);
            }

            return results;
        }
    }
}
package com.newler.leetcode.stack;
// [84]、柱状图中最大的矩形

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] nums = {2,1,5,6,2,3};
        solution.largestRectangleArea(nums);
    }
    static class Solution {
        public int largestRectangleArea(int[] heights) {
            int[] lefts = new int[heights.length];
            int[] rights = new int[heights.length];

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                lefts[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            stack.clear();

            for (int i = heights.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                rights[i] = stack.isEmpty() ? heights.length : stack.peek();
                stack.push(i);
            }

            int maxArea = 0;
            for (int i = 0; i < heights.length; i++) {
                maxArea = Math.max((rights[i] - lefts[i] - 1) * heights[i], maxArea);
            }
            return maxArea;
        }
    }

    static class Solution2 {
        public int largestRectangleArea(int[] heights) {
            LinkedList<Integer> stack = new LinkedList<>();
            int[] lefts = new int[heights.length];
            int[] rights = new int[heights.length];

            // 将自身压入，否则会出现right[i] = 0的情况
            Arrays.fill(rights, heights.length);
            // 我们找的是栈顶元素的左右边界
            for (int i = 0; i < heights.length; i++) {
                // 找右边界,第一个右边小于高度的值
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    rights[stack.pop()] = i;
                }
                // 左边界就是栈的相邻值，第一个左边小于高度的值
                lefts[i] = stack.isEmpty() ? -1 :stack.peek();
                stack.push(i);
            }

            int max = 0;
            for (int i = 0; i < heights.length; i++) {
                int area = (rights[i] - lefts[i] - 1) * heights[i];
                max = Math.max(area, max);
            }

            return max;
        }
    }

    static class Solution3 {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int maxArea = 0;
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    int h = heights[stack.pop()];
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    maxArea = Math.max((i-1 - left) * h , maxArea);
                }
                stack.push(i);
            }

            int right = 0;
            if (!stack.isEmpty()) {
                right = stack.peek()+1;
            }
            while (!stack.isEmpty()) {
                int h = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max((right - left - 1) * h, maxArea);
            }
            return maxArea;
        }
    }
}
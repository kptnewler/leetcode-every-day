package com.newler.leetcode.stack;
// [42]、接雨水

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


import java.util.Stack;
/**
 * 未完成
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height));
    }
    static class Solution {
        public int trap(int[] heights) {
            if (heights == null || heights.length == 0) return 0;
            int sum = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                    int current = stack.pop();
                    int right = i;
                    if (stack.isEmpty()) continue;
                    int left = stack.peek();
                    int height = Math.min(heights[right], heights[left]) - heights[current];
                    int width = right - left- 1;
                    sum += width * height;
                }
                stack.push(i);
            }
            return sum;
        }
    }
}
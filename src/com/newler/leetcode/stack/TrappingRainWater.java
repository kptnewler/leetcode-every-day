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


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 未完成
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }

    /**
     * 单调栈递减
     */
    static class Solution {
        public int trap(int[] heights) {
            Deque<Integer> stack = new ArrayDeque<>(heights.length);
            int count = 0;
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                    int current = stack.poll();
                    if (stack.isEmpty()) break;
                    int h = Math.min(heights[stack.peek()],heights[i]) - heights[current];
                    int w = i - stack.peek() - 1;
                    count += h * w;
                }

                stack.push(i);
            }
            return count;
        }
    }

    /**
     * 暴力求解
     */
    class Solution2 {
        public int trap(int[] heights) {
            int count = 0;
            for (int i = 1; i < heights.length - 1; i++) {
                int leftMax = 0;
                for (int j = 0; j < i; j++) {
                    leftMax = Math.max(heights[j], leftMax);
                }

                int rightMax = 0;
                for (int j = i + 1; j < heights.length; j++) {
                    rightMax = Math.max(heights[j], rightMax);
                }
                count += Math.max(Math.min(leftMax, rightMax) - heights[i], 0);
            }
            return count;
        }
    }

    /**
     * 用数组保存结果，空间换时间
     */
    class Solution3 {
        public int trap(int[] heights) {
            int[] leftMaxs = new int[heights.length];
            int[] rightMaxs = new int[heights.length];
            int count = 0;
            for (int j = heights.length - 2; j >= 0; j--) {
                rightMaxs[j] = Math.max(rightMaxs[j + 1], heights[j+1]);
            }
            for (int i = 1; i < heights.length; i++) {
                leftMaxs[i] = Math.max(leftMaxs[i-1], heights[i-1]);
            }
            for (int i = 1; i < heights.length - 1; i++) {
                count += Math.max(Math.min(leftMaxs[i], rightMaxs[i]) - heights[i], 0);
            }

            return count;
        }
    }

}
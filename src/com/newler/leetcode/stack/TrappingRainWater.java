package com.newler.leetcode.stack;
// [42]、接雨水
// 2020年6月14日23:37:20
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
        Solution3 solution = new Solution3();
        int[] height = {2,0,2};
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
        public int trap(int[] height) {
            int ans = 0;
            for (int i = 1; i < height.length - 1; i++) {
                int leftMax = 0, rightMax = 0;

                // 找右边最高的柱子
                for (int j = i; j < height.length; j++) {
                    rightMax = Math.max(height[j], rightMax);
                }

                // 找左边最高的柱子
                for (int j = i; j >= 0; j--) {
                    leftMax = Math.max(height[j], leftMax);
                }

                // 如果自己就是最高的话，
                // leftMax == rightMax == height[i]
                ans += Math.min(leftMax, rightMax) - height[i];
            }
            return ans;
        }
    }

    /**
     * 用数组保存结果，空间换时间
     */
    static class Solution3 {
        public int trap(int[] height) {
            if (height == null || height.length == 0) return 0;

            int ans = 0;
            // 数组充当备忘录
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];

            // 初始化base case
            leftMax[0] = height[0];
            rightMax[height.length - 1] = height[height.length - 1];

            // 从左到右计算leftMax
            for (int i = 1; i < height.length; i++) {
                leftMax[i] = Math.max(height[i], leftMax[i-1]);
            }
            // 从右到左计算rightMax
            for (int i = height.length - 2; i >= 0; i--) {
                rightMax[i] = Math.max(height[i], rightMax[i + 1]);
            }

            // 计算结果
            for (int i = 1; i < height.length - 1; i++) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }

            return ans;
        }
    }

    // 双指针
    class Solution5 {
        public int trap(int[] height) {
            if (height == null || height.length == 0) return 0;

             int ans = 0;
             int leftMax, rightMax;
             // 左右指针
             int left = 0, right = height.length - 1;

             // 初始化
             leftMax = height[0];
             rightMax = height[height.length - 1];

             while (left < right) {
                 // 更新左右两边柱子最大值
                 leftMax = Math.max(height[left], leftMax);
                 rightMax = Math.max(height[right], rightMax);

                 // 相当于ans += Math.min(leftMax, rightMax) - height[i]
                 if (leftMax < rightMax) {
                     ans += leftMax - height[left];
                     left++;
                 } else  {
                     ans += rightMax - height[right];
                     right--;
                 }
             }
             return ans;
        }
    }

}
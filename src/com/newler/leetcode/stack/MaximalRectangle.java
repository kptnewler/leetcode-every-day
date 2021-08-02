package com.newler.leetcode.stack;
// [85]、最大矩形

//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 示例: 
//
// 输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6 
// Related Topics 栈 数组 哈希表 动态规划


import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {
                {'0', '1'},
                {'1', '0'}
        };

        /**
         *         {'1','0','1','0','0'},
         *                 {'1','0','1','1','1'},
         *                 {'1','1','1','1','1'},
         *                 {'1','0','0','1','0'}
         */
        System.out.println(solution.maximalRectangle(matrix));
    }

    static class Solution {
        public int maximalRectangle(char[][] matrix) {
           if (matrix == null || matrix.length == 0) return 0;
           int[] heights = new int[matrix[0].length];
           int max = 0;
            // 从0行作为底，逐行递加，计算有多少连续个1，即为矩形高度
            // 如果出现1 0 高度重新归0
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
                }
                // 每行统计完毕，根据高度，使用单调栈求每个高度对应的最大宽度，最终计算求出最大面
                max = Math.max(getEachLineMaxArea(heights), max);
            }
            return max;
        }

        /**
         *转换为[84]、柱状图中最大的矩形
         */
        private int getEachLineMaxArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int maxLeftIndex, maxRightIndex, maxArea = 0;
            int[] left = new int[heights.length];
            int[] right = new int[heights.length];
            Arrays.fill(right, heights.length);
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    right[stack.pop()] = i;
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < heights.length; i++) {
                maxArea = Math.max(heights[i] * (right[i] - left[i] -1), maxArea);
            }

            return maxArea;
        }

        private int calcArea(int heights, int maxRightIndex, int maxLeftIndex) {
            int maxWidth = maxRightIndex - maxLeftIndex + 1;
            return maxWidth * heights;
        }
    }


}
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
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(solution.maximalRectangle(matrix));
    }

    static class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0 ) return 0;
            int max = 0;
            int heights[] = new int[matrix[0].length];
            Arrays.fill(heights, 0);
            for (int i = 0; i < matrix.length; i++) {
                // 从0行作为底，逐行递加，计算有多少连续个1，即为矩形高度
                for (int j = 0; j < matrix[i].length; j++) {
                    heights[j] = matrix[i][j] == '1' ? heights[j]+1 : 0;
                }

                // 每行统计完毕，根据高度，使用单调栈求每个高度对应的最大宽度，最终计算求出最大面积。
                max = Math.max(getEachLineMaxArea(heights), max);
            }
            return max;
        }

        private int getEachLineMaxArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int maxLeftIndex, maxRightIndex, maxArea = 0;
            for (int i = 0; i < heights.length; i++) {
                // 需要计算最大面积，就要找到离当前位置左边和右边最近比它小或相等的值，他们两者相邻位置就是离他最远的最大值了。
                // 然后以当前位置的高度相减乘左右两者之间的间距即为该位置的最大面积
                while (!stack.isEmpty() &&  heights[i] <= heights[stack.peek()]) {
                    int calcAreaIndex = stack.pop();
                    // 如果数组为空，说明它左边所有值都比当前值大，从0起都可以被扩展
                    maxLeftIndex = stack.isEmpty() ? 0:stack.peek() + 1 ;
                    maxRightIndex = i - 1;
                    maxArea = Math.max(maxArea, calcArea(heights[calcAreaIndex], maxRightIndex, maxLeftIndex));
                }
                stack.push(i);
            }

            if (!stack.isEmpty()) {
                maxRightIndex = stack.peek();
                while (!stack.isEmpty()) {
                    int calcAreaIndex = stack.pop();
                    maxLeftIndex = stack.isEmpty() ? 0:stack.peek() + 1 ;
                    maxArea = Math.max(maxArea, calcArea(heights[calcAreaIndex], maxRightIndex, maxLeftIndex));
                }
            }
            return maxArea;
        }

        private int calcArea(int heights, int maxRightIndex, int maxLeftIndex) {
            int maxWidth = maxRightIndex - maxLeftIndex + 1;
            return maxWidth * heights;
        }
    }


}
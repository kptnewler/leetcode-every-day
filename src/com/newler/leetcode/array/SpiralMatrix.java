package com.newler.leetcode.array;
// [54]、螺旋矩阵
// 2020年6月5日22:22:57
//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组


import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
        Solution solution = new Solution();
        System.out.println("数量:" + solution.spiralOrder(matrix).size());
        solution.spiralOrder(matrix).forEach(System.out::println);
    }
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return new ArrayList<>();
            int m = matrix[0].length;
            int n = matrix.length;
            List<Integer> results = new ArrayList<>(matrix.length * matrix[0].length);

            int left = 0, right = m-1, top = 0, bottom = n-1;
            while (left <= right && top <= bottom) {
                for (int i = left; i <= right; i++) {
                    results.add(matrix[top][i]);
                }
                for (int j = top+1; j <= bottom; j++) {
                    results.add(matrix[j][right]);
                }
                if (left < right && top < bottom) {
                    for (int i = right - 1; i > left; i--) {
                        results.add(matrix[bottom][i]);
                    }
                    for (int j = bottom; j > top; j--) {
                        results.add(matrix[j][left]);
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return results;
        }

    }
}


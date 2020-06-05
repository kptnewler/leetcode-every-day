package com.newler.leetcode.array;
// [54]、螺旋矩阵
// ${DATE}
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
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        Solution solution = new Solution();
        solution.spiralOrder(matrix).forEach(System.out::println);
    }
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix[0].length;
            int n = matrix.length;
            List<Integer> results = new ArrayList<>(matrix.length * matrix[0].length);

            int rowStart = 0;
            int colStart = 0;

            while (m>=0 && n>=0) {
                int i=colStart, j;
                for (j = rowStart; j < m - 1; j++) {
                    results.add(matrix[i][j]);
                }

                for (i = colStart; i < n - 1; i++) {
                    results.add(matrix[i][j]);
                }

                for (; j > rowStart; j--) {
                    results.add(matrix[i][j]);
                }

                for (; i > colStart; i--) {
                    results.add(matrix[i][j]);
                }

                colStart++;
                rowStart++;
                m -=2;
                n -=2;
            }
            return results;
        }

    }
}


package com.newler.leetcode.binary;
// [240]、搜索二维矩阵 II

//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -109 <= matix[i][j] <= 109 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 分治 矩阵 
// 👍 672 👎 0


public class SearchA2dMatrixIi{
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 起始点在 row = 0，表示纵向最小
     * col = matrix.length -1,表示横向最大
     * 如果target < [col][row]，说明在更小的区域，纵向最小不能移动，横向上移 col--
     * 如果target > [col][row] ,说明在更大的区域，横向最大不能移动，纵向右移 row++
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int row = 0, col = matrix.length -1;
        while (col >= 0 && row < matrix[0].length) {
            if (target < matrix[col][row]) {
                col--;
            } else if (target > matrix[col][row]) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
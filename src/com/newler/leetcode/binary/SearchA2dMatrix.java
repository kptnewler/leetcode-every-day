package com.newler.leetcode.binary;
// [74]、搜索二维矩阵
// 2021年2月5日18:51:26
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
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
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 309 👎 0


public class SearchA2dMatrix {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 行index * 列长+列Index
        public boolean searchMatrix(int[][] matrix, int target) {
           if (matrix.length == 0)return false;
           int l = 0, r = matrix.length * matrix[0].length - 1;
           int rowLength = matrix[0].length;
           while (l <= r) {
               int mid =  l + (r-l)/2;
               if (target < matrix[mid/rowLength][mid%rowLength]) {
                    r = mid - 1;
               } else if (target > matrix[mid/rowLength][mid%rowLength]){
                   l = mid + 1;
               } else {
                   return true;
               }
           }
           return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


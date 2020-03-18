package com.newler.leetcode.stack;
// [503]、下一个更大元素 II

//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
// 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈


import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementIi {
    /**
     * 单调栈
     */
    class Solution {
        //  0 5 2 4 6 3 1
        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int[] results = new int[nums.length];
            Arrays.fill(results, -1);

            // 第一遍找出右边离得最近的最大值,[0 5 2 4 6 3 1]
            // 第一遍留下来的是[5,3,1]留下来index大的在栈顶
            // 第二遍，从左边第一个0开始，当遍历到5时，1弹出，循环右边最大值5，以此类推
            int loopSize = 2;
            while (loopSize > 0) {
                for (int i = 0; i < nums.length; i++) {
                    while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                        results[stack.pop()] = nums[i];
                    }
                    stack.push(i);
                }
                loopSize --;
            }
            return results;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
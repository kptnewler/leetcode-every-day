package com.newler.leetcode.stack;
// [581]、最短无序连续子数组

//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 
// 👍 566 👎 0


import java.util.LinkedList;

public class ShortestUnsortedContinuousSubarray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            LinkedList<Integer> stack = new LinkedList<>();
            int l = nums.length;
            int r = 0;
            for (int i = 0; i < nums.length; i++) {
                // 找到左边界
                while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                    l = Math.min(stack.pop(), l);
                }
                stack.push(i);
            }
            stack.clear();
            for (int i = nums.length -1; i >= 0; i--) {
                // 找到右边界
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    r = Math.max(stack.pop(), r);
                }
                stack.push(i);
            }

            return r - l > 0 ? r-l+1 : 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
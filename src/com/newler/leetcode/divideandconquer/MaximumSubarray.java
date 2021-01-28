package com.newler.leetcode.divideandconquer;
// [53]、最大子序和

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2824 👎 0


public class MaximumSubarray {
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 解法1 遍历
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum =  nums[0];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum > maxSum) {
                    maxSum = sum;
                }
                if (sum < 0) {
                    sum = 0;
                }
            }
            return maxSum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    class Solution2 {
        class Result {
            int lsum;
            int rsum;
            int isum;
            int msum;

            public Result(int lsum, int rsum, int isum, int msum) {
                this.lsum = lsum;
                this.rsum = rsum;
                this.isum = isum;
                this.msum = msum;
            }
        }
        public int maxSubArray(int[] nums) {
            return pushUp(0, nums.length-1, nums).isum;
        }

        public Result pushUp(int l, int r, int[] nums) {
            if (l >= r) {
                return new Result(nums[r], nums[r], nums[r], nums[r]);
            }

            int mid = (l+r)/2;
            Result lResult = pushUp(l, mid, nums);
            Result rResult = pushUp(mid+1, r, nums);
            return merge(lResult, rResult);
        }

        public Result merge(Result lResult, Result rResult) {
            // 总和
            int mSum = lResult.msum + rResult.msum;
            // 左端点最大子数组和
            int lSum = Math.max(lResult.lsum, lResult.msum+rResult.lsum);
            // 右端点最大子数组和
            int rSum = Math.max(rResult.rsum, lResult.rsum+rResult.msum);

            // 左右区间合并最大子数组和,有可能在左边，有可能在右边，有可能跨越m
            int iSum = Math.max(Math.max(rResult.isum, lResult.isum), rResult.lsum+lResult.rsum);
            return new Result(lSum, rSum, iSum, mSum);
        }
    }
}
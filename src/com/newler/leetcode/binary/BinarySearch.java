package com.newler.leetcode.binary;

public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.search(new int[]{-1,0,3,5,9,12}, 9);
    }
    static class Solution {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            int result = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) {
                    return result;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            }
            return result;
        }
    }
}

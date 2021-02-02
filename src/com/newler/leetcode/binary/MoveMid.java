package com.newler.leetcode.binary;

public class MoveMid {
    static class Solution {

        int findMidNum(int[] nums) {
            if(nums.length == 0) {
                return -1;
            }
            int maxIndex = findMaxIndex(nums);
            int midIndex = (nums.length-1) / 2+maxIndex+1;
            System.out.println(nums[midIndex]);
            return nums.length-1 - maxIndex + nums[nums.length / 2];
        }
        int findMaxIndex(int[] nums)
        {
            int begin = 0;
            int end = nums.length - 1;
            int mid =  (begin + end)/2;

            while(mid > 0 && mid < nums.length -1)
            {
                // 属于在峰顶,如6,7,1
                if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
                    return mid;
                }else if (nums[mid] < nums[mid+1] && nums[mid] >= nums[0]){
                    // 只要比开头大，表示完全递增或先递增再递减
                    begin = mid + 1;
                    mid = (begin+end) / 2;
                } else {
                    end = mid- 1;
                    mid = (begin+end)/2;
                }
            }

            if(mid == 0){
                return 0;
            }
            if(mid == nums.length-1){
                return nums.length-1;
            }
            return -1;
        }
    }
}

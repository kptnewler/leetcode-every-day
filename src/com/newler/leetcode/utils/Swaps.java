package com.newler.leetcode.utils;

public class Swaps {
    public static void swapIntArray(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

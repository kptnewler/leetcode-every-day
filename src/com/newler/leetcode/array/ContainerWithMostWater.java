package com.newler.leetcode.array;
// [11]、盛最多水的容器
// 2020年5月29日09:59:56
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针

/**
 * 1. 暴力，从第一个柱状开始，依次和后面组合形成容器，计算出面积，不断比较，时间复杂度O(n^2)
 * 2. 双指针
 */
public class ContainerWithMostWater{
class Solution {
    /**
     * 思路：双指针，缩短搜索空间
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            max = Math.max(Math.min(height[left], height[right]) * (right-left), max);
            // 移动高度比较低的指针，因为木桶效应，面积取决最短的那个，所以移动去提高短板
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}

}


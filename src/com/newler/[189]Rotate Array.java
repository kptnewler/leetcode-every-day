package com.newler;

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class RotateArray {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        Arrays.stream(nums).forEach(System.out::println);
    }

    /**
     * 解法一
     * 从第一个元素开始，根据步长计算下一个移动到的索引值，交换两者位置
     * 计算被交换的元素，需要移动到的索引值，继续交换，直到所有元素都被移动到新的位置
     * 1,2,3,4,5,6,7，k = 3
     * 1的新索引为0+3，需要和4进行交换，4,2,3,1,5,6,7
     * 4的新索引为3+3，需要和7进行交换，7,2,3,1,5,6,4
     * 7的新索引(6+3)%7=2,需要和3进行交换，3,2,7,1,5,6,4
     * 3的新索引2+3,需要和6进行交换，6,2,7,1,5,3,4
     * 6的新索引为(5+3)%7=1，需要和2进交换，2,6,7,1,5,3,4
     * 2的新索引为1+3，需要和5进行交换，5,6,7,1,2,3,4
     * 至此交换完毕
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int index = 0;
        // 指向需要交换元素的新索引值
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            int next_index = (index + k) % nums.length;
            // 两者值相同，说需要交换的元素已经在下一个位置上，则交换下一个元素
            if (next_index == j) {
                j++;
                index = j;
                continue;
            }
            int tmp = nums[j];
            nums[j] = nums[next_index];
            nums[next_index] = tmp;

            index = next_index;
        }
    }

    // 解法二，逐个移动，暴力
    public static void rotate2(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int moveNum = nums[nums.length - 1];
            for (int j = nums.length -2; j >= 0 ; j--) {
                nums[j+1] = nums[j];
            }
            nums[0] = moveNum;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

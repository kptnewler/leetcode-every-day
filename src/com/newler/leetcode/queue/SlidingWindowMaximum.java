package com.newler.leetcode.queue;
// [239]、滑动窗口最大值

//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//
// 返回滑动窗口中的最大值。
//
//
//
// 示例:
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// 提示：
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
//
//
//
// 进阶：
//
// 你能在线性时间复杂度内解决此题吗？
// Related Topics 堆 Sliding Window


import java.util.*;

public class SlidingWindowMaximum{

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {7,2,4};
        Arrays.stream(solution.maxSlidingWindow(nums, 2)).forEach(System.out::println);
    }
    /**
     * 反馈1：没有考虑[],0边界条件
     * 反馈2： 保存值，不能直接和队头比较，要和maxQueue中保存值依次比较移除
     * 反馈3： 17ms 47MB 时间复杂度为O(n*k)
     * 解法：用maxQueue保存最大值，，dataQueue保存滑动窗口值
     * 1. 先将k个值添加到dataQueue中
     * 2. 将k个值添加到maxQueue中。
     * 3. 在添加过程中，执行findMax函数，每个添加值从maxQueue末尾开始依次比较，如果比末尾值大则直接移除末尾值，最后添加到maxQueue，返回队头值即为max值
     * 4. 每次滑动1位，即移除dataQueue队头值，如果maxQueue队头值和它相同也移除，新值添加到dataQueue队尾
     * 5. 按照3步骤添加到maxQueue中
     */
    static class Solution {
        private Queue<Integer> dataQueue;
        private LinkedList<Integer> maxQueue;
        private int[] maxArray;
        public int[] maxSlidingWindow(int[] nums, int k) {
            dataQueue = new ArrayDeque<>(k);
            maxQueue = new LinkedList<>();
            maxArray = new int[nums.length - k + 1];

            int max = Integer.MIN_VALUE;
            maxQueue.offer(max);
            if (nums.length == 0) {
                return new int[0];
            }
            for (int i = 0; i < nums.length; i++) {
                // 将前K个数字添加到队列中
                if (i < k) {
                    dataQueue.offer(nums[i]);
                    maxArray[0] = findMax(nums, i);
                    continue;
                }

                // 滑动过程中最大值被移除
                if (dataQueue.peek().intValue() == maxQueue.peek().intValue()) {
                    maxQueue.poll();
                }
                dataQueue.poll();
                dataQueue.offer(nums[i]);
                maxArray[i - k + 1] = findMax(nums, i);
            }

            return maxArray;
        }

        private int findMax(int[] nums, int i) {
            int max;
            // 把比当前值小的，都移除掉
            while (!maxQueue.isEmpty() && nums[i] > maxQueue.getLast()) {
                maxQueue.removeLast();
            }
            maxQueue.offer(nums[i]);
            max = maxQueue.peek();
            return max;
        }
    }

    /**
     * 解法二 修改保存下标，不保存队列
     * 均摊之后时间复杂度为o(n)
     */
    static class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }

            LinkedList<Integer> maxQueue = new LinkedList<>();
            int[] maxArray = new int[nums.length - k + 1];

            for (int i = 0; i < nums.length; i++) {
                // 如果移除的值和maxQueue中保存值相同
                if (maxQueue.peek()!=null && i-k == maxQueue.peekFirst()) {
                    maxQueue.pollFirst();
                }

                // 如果队列为空直接添加
                while (!maxQueue.isEmpty() && nums[i] > nums[maxQueue.getLast()]) {
                    maxQueue.pollLast();
                }
                maxQueue.offer(i);
                if (maxQueue.peekFirst() != null && i >= k-1) {
                    maxArray[i - k + 1] = nums[maxQueue.peekFirst()];
                }
            }
            return maxArray;
        }
    }
}
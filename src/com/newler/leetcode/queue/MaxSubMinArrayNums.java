package com.newler.leetcode.queue;

import java.util.*;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/5fe02eb175974e18b9a546812a17428e?orderByHotValue=1&page=1&onlyReference=false
 * 来源：牛客网
 *
 * 给定数组 arr 和整数 num，共返回有多少个子数组满足如下情况：
 * max(arr[i...j] - min(arr[i...j]) <= num
 * max(arr[i...j])表示子数组arr[i...j]中的最大值，min[arr[i...j])表示子数组arr[i...j]中的最小值。
 *
 * 输入
 * 5 2
 * 1 2 3 4 5
 *
 * 输出
 * 12
 *
 * (1,2) (1,3) (1,2,3) (2,3)(2,4)(2,3,4)(3,4)(3,5)(3,4,5)(4,5)
 */
public class MaxSubMinArrayNums {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int array[] = {1,2,3,4,5};
        System.out.println(solution.getNum(array, 2));
    }
    /**
     * 先用爆搜
     */
    static class Solution {
        private int getNum(int[] array, int num) {
            LinkedList<Integer> minQueue = new LinkedList<>();
            LinkedList<Integer> maxQueue = new LinkedList<>();

            int j = 0;
            int i = 0;
            int sum = 0;
            while (i < array.length) {
                while (!minQueue.isEmpty() && array[j] <= array[minQueue.getLast()]) {
                    minQueue.pollLast();
                }
                minQueue.push(j);

                while (!maxQueue.isEmpty() && array[j] > array[maxQueue.getLast()]) {
                    maxQueue.pollLast();
                }
                maxQueue.push(j);

                if (j < array.length-1 && array[maxQueue.peekFirst()] - array[minQueue.peekFirst()] <= num) {
                    j++;
                } else {
                    sum += j-i;
                    i++;
                    j = i;
                    minQueue.clear();
                    maxQueue.clear();
                }
            }
            return sum;
        }
    }

    static class Solution2 {
        private int getNum(int[] arr, int num) {

            // 初始化子数组的最大值候选数组的下标
            LinkedList<Integer> qmax = new LinkedList<>();
            // 初始化子数组的最小值候选数字的下标
            LinkedList<Integer> qmin = new LinkedList<>();
            int res = 0;
            int i = 0;
            int j = 0;
            // 求以arr[i]开头的子数组中有多少个满足条件的
            while (i < arr.length) {
                while (j < arr.length) {
                    // 更新j++后的最大值和最小值
                    while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                        qmax.pollLast();
                    }
                    qmax.addLast(j);
                    while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                        qmin.pollLast();
                    }
                    qmin.addLast(j);
                    if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                        // [i,j]不满足条件，则[i,j+1]...[i,arr.length-1]均不满足条件
                        break;
                    }
                    j++;
                }
                // [i,i]...[i,j-1]均满足条件，共有j-1-i+1个
                res += j - i;
                // 更新i++后的最大值和最小值
                if (qmax.peekFirst() == i) {
                    qmax.pollFirst();
                }
                if (qmin.peekFirst() == i) {
                    qmin.pollFirst();
                }
                i++;
            }
            return res;
        }
    }
}

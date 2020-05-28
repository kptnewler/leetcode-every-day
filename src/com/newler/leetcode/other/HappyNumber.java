package com.newler.leetcode.other;
// [202]、快乐数
// 2020年4月30日18:30:49
//编写一个算法来判断一个数 n 是不是快乐数。
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果 可以变为 1，那么这个数就是快乐数。 
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。 
//
// 
//
// 示例： 
//
// 输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学


import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.isHappy(19);
    }

    /**
     * 解法一： 普通解法
     */
    static class Solution {
        public boolean isHappy(int n) {
            HashSet<Integer> integers = new HashSet<>(20);
            int sum = n;
            while (sum != 1) {
                sum = 0;
                while (n != 0) {
                    sum += Math.pow(n%10, 2);
                    n /= 10;
                }
                n = sum;
                if (integers.contains(sum)) {
                    return false;
                } else {
                    integers.add(sum);
                }
            }
            return true;
        }
    }

    /**
     * 解法二，类似单链表找环，快慢指针，一个执行1步，一个执行两步，如果相遇表示是个环
     */
    static class Solution2 {
        public boolean isHappy(int n) {
            int x = n;
            int y = n;
            while (true) {
                x = calc(x);
                if (x == 1) return true;
                y = calc(calc(y));
                if (y == 1) return true;

                if (x == y) return false;
            }
        }

        private int calc(int value) {
            int sum = 0;
            while (value != 0) {
                sum += Math.pow(value % 10, 2);
                value /= 10;
            }
            return sum;
        }
    }

}


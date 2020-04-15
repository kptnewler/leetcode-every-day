package com.newler.leetcode.linklist;
import java.math.BigInteger;
import java.lang.StringBuilder;
// [445]、两数相加 II
// 2020年4月14日09:29:07
//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表


import com.newler.leetcode.data.ListNode;

import java.math.BigInteger;

public class AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addTwoNumbers(new ListNode(5), new ListNode(5));
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            while (cur1 != null) {
                s1.append(cur1.val);
                cur1 = cur1.next;
            }

            while (cur2 != null) {
                s2.append(cur2.val);
                cur2 = cur2.next;
            }

            ListNode cur = s1.length() > s2.length() ? l1 : l2;
            ListNode head = s1.length() > s2.length() ? l1 : l2;
            ListNode pre = null;
            String sum = new BigInteger(s1.toString()).add(new BigInteger(s2.toString())).toString();

            for (int i = 0; i < sum.length(); i++) {
                if (cur == null) {
                    cur = new ListNode(0);
                    pre.next = cur;
                }
                cur.val = sum.charAt(i) - '0';
                pre = cur;
                cur = cur.next;
            }

            return head;
        }
    }

}


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
import java.util.Stack;

public class AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addTwoNumbers(new ListNode(5), new ListNode(5));
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();
            ListNode head = null, newListNode = null;
            int n1, n2, sum, ans = 0;
            while (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }

            while (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }

            while (!s1.isEmpty() || !s2.isEmpty()) {
                n1 = s1.isEmpty() ? 0 : s1.pop();
                n2 = s2.isEmpty() ? 0 : s2.pop();
                sum = n1 + n2 + ans;
                if (head == null) {
                    newListNode = head = new ListNode(sum % 10);
                } else {
                    newListNode.next = new ListNode(sum % 10);
                    newListNode = newListNode.next;
                }
                ans = sum / 10;

            }


            return head;
        }
    }

}


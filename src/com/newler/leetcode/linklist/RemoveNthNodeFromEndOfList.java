package com.newler.leetcode.linklist;
// [19]、删除链表的倒数第N个节点

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？


import com.newler.leetcode.data.ListNode;

import java.util.List;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

    }

    /**
     * 解法一
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int size = 0;
            ListNode h = head;
            while (h != null) {
                size++;
                h = h.next;
            }

            h = head;
            int a = size - n;
            if (a == 0) {
                h = h.next;
                return h;
            }
            while (a > 1) {
                h = h.next;
                a--;
            }

            ListNode tmp;
            tmp = h.next.next;
            h.next = tmp;

            return head;
        }
    }

    /**
     * 解法二
     */
    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode last = head;
            ListNode pre = head;
            while (last != null) {
                last = last.next;
                n--;
            }

            // 删除的头结点
            if (n == 0) {
                head = head.next;
                return head;
            }

            // 删除节点位置，超出链表大小
            if (n > 0) return null;

            while (++n != 0) {
                pre = pre.next;
            }

            pre.next = pre.next.next;

            return head;
        }
    }

}


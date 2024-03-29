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
     * 解法
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) return null;

            ListNode preHead = new ListNode(0);
            preHead.next = head;
            ListNode cur = head;
            ListNode pre = preHead;
            // 先走n步，背下来
            for (int i = 0; i < n; i++) {
                cur = cur.next;
            }

            while (cur !=null) {
                cur = cur.next;
                pre = pre.next;
            }

            pre.next = pre.next.next;
            return preHead.next;
        }
    }

}


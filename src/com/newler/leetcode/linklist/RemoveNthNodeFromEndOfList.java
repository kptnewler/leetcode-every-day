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
            ListNode preHead = new ListNode(0);
            preHead.next = head;
            ListNode slow = preHead;
            ListNode fast = head;
            // 先走n步，两者间隔n个格子
            // 比如 1-> 2-> 3
            //      s       f 领先 1个格子，即删除倒数第几个。
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }

            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next.next;
            return preHead.next;
        }
    }

}


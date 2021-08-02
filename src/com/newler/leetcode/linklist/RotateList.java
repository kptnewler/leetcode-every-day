package com.newler.leetcode.linklist;
// [61]、旋转链表
// 2020年4月28日9:25:53
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针


import com.newler.leetcode.data.ListNode;

public class RotateList {

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) return head;
            if (k==0) return head;

            int size = 1;
            ListNode tail = head, cur = head;
            while (tail.next != null) {
                tail = tail.next;
                size++;
            }
            tail.next = head;

            for (int i = 0; i < size -1 - (k % size); i++) {
                cur = cur.next;
            }

            ListNode newHead = cur.next;
            cur.next = null;
            return newHead;
        }
    }
}


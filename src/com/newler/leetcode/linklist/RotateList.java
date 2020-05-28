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
            int len = 0;
            if (head == null || k == 0) return head;
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
                len++;
            }
            // 一个周期
            len += 1;
            if (k % len == 0) return head;

            // 最后一个节点的next指向头节点
            cur.next = head;
            cur = head;
            int i = 0;
            while (i < len - k % len) {
                cur = cur.next;
                i++;
            }
            head = cur.next;
            cur.next = null;

            return head;
        }
    }
}


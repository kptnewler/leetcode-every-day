package com.newler.leetcode.linklist;
// [234]、回文链表
// 2020年3月26日10:08:00
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针


import com.newler.leetcode.data.ListNode;

public class PalindromeLinkedList {

    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head.next == null) return true;
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode tail = reservedLinkList(slow);
            while (tail != null && head != null) {
                if (tail.val != head.val) return false;
                tail = tail.next;
                head = head.next;
            }
            return true;
        }

        private ListNode reservedLinkList(ListNode node) {
            ListNode pre = null;
            ListNode next = null;
            ListNode cur = node;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }

}


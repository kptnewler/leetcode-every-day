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
            ListNode slow = head, fast = head;
            while (fast!=null &&fast.next !=null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode cur = slow, pre = null, next;
            while (cur !=null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            ListNode l = head, r = pre;
            while (r != null) {
                if (l.val != r.val) return false;
                l = l.next;
                r = r.next;
            }

            return true;
        }
    }

}


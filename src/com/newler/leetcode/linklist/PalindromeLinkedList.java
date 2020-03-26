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

import java.util.List;
import java.util.Stack;

public class PalindromeLinkedList {

    class Solution {
        public boolean isPalindrome(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            ListNode tail = head;
            ListNode mid = head;
            while (tail != null && tail.next != null) {
                tail = tail.next.next;
                mid = mid.next;
            }

            while (mid != null) {
                stack.push(mid);
                mid = mid.next;
            }

            while (!stack.isEmpty()) {
                if (head.val != stack.pop().val) {
                    return false;
                }
                head = head.next;
            }

            return true;
        }
    }

}


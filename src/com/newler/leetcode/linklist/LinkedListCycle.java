package com.newler.leetcode.linklist;
// [141]、环形链表
// 2020年4月1日09:19:39
//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针


import com.newler.leetcode.data.ListNode;

public class LinkedListCycle {

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode fast = head, slow = head;
            while (true) {
                if (fast == null || fast.next == null) return false;
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) return true;
            }
        }
    }
}


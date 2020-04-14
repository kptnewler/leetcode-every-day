package com.newler.leetcode.linklist;
// [203]、移除链表元素
// 2020年4月13日09:08:30
//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表


import com.newler.leetcode.data.ListNode;

public class RemoveLinkedListElements {

    /**
     * 解题思路：创造一个虚拟指针
     */
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode cur = head;
            head = pre;

            while (cur != null) {
                if (cur.val == val) {
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }

                cur = cur.next;
            }
            return head.next;
        }
    }
}


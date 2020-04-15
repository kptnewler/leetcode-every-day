package com.newler.leetcode.linklist;
// [83]、删除排序链表中的重复元素

//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表


import com.newler.leetcode.data.ListNode;


public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {1,1,1};
        solution.deleteDuplicates(new ListNode(nums));
    }

    /**
     * 解题思路：前一个节点和后一个节点比较，相同删除前一个节点
     */
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
            ListNode cur = head;
            ListNode pre = new ListNode(0);
            pre.next = head;
            head = pre;
            while (cur.next != null) {
                // 如果前一个节点被删除，则pre不移动位置
                if (cur.val == cur.next.val) {
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
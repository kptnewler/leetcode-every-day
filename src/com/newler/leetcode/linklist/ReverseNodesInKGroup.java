package com.newler.leetcode.linklist;
// [25]、K 个一组翻转链表
// 2020年4月10日14:04:27
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表


import com.newler.leetcode.data.ListNode;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = new ListNode(nums);

        Solution solution = new Solution();
        solution.reverseKGroup(head, 2);
    }

    /**
     * 1. 先k个节点逆序
     * 2. 把第k个节点的next指向开始节点
     */
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k < 2) return head;
            ListNode cur = null, next = head;
            int len = 0;
            while (head != null) {
                head = head.next;
                len ++;
            }

            ListNode lastKHead = next;
            ListNode curKHead = next;
            for (int i = 0; i < (len / k) + 1; i++) {
                int step = k;
                if (len - i*k >= k) {
                    cur = null;
                    while (next != null && step > 0) {
                        ListNode tmp = next.next;
                        next.next = cur;
                        cur = next;
                        next = tmp;
                        step--;
                    }
                }

                if (i == 0) {
                    head = cur;
                    curKHead = next;
                    continue;
                }

                if (len - i*k >= k) {
                    lastKHead.next = cur;
                    lastKHead = curKHead;
                    curKHead = next;
                } else {
                    lastKHead.next = next;
                }

            }
            return head;
        }
    }

}


package com.newler.leetcode.linklist;
// [92]、反转链表 II
// 2020年3月24日10:03:44
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表


import com.newler.leetcode.data.ListNode;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {1,2,3,4,5};
        ListNode head = new ListNode(nums);
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        solution.reverseBetween(head, 2, 4);
    }

    static class Solution {
        /**
         * 找到区间链表，反转，然后接头和尾
         */
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null) return null;
            ListNode preHead = new ListNode(-1);
            preHead.next = head;
            // 保存左边界前一个节点
            ListNode lpre = preHead;
            ListNode rNext = head;
            for (int i = 0; i < m - 1; i++) {
                lpre = lpre.next;
            }

            for (int i = 0; i < n - 1; i++) {
                rNext = rNext.next;
            }

            ListNode l = lpre.next;
            ListNode r = rNext;
            // 保存右边界前一个节点
            rNext = rNext.next;

            // 截断取出需要反转的链表
            lpre.next = null;
            r.next = null;
            ListNode cur = l, pre = null, next;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            lpre.next = r;
            if (l!=null) {
                l.next = rNext;
            }

            return lpre.next;
        }
    }

    /**
     *头插法
     */
    class Solution2 {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode preHead = new ListNode(-1);
            preHead.next = head;
            ListNode pre = preHead;
            for (int i = 0; i < m-1; i++) {
                pre = pre.next;
            }
            ListNode cur = pre.next;
            ListNode next;
            for (int i = m; i < n; i++) {
                next = cur.next;
                // 一直指向下一个node，所以不需要cur = next了
                cur.next = cur.next.next;
                // 插入到前面的指向当前头结点
                next.next = pre.next;
                pre.next = next;
            }
            return preHead.next;
        }
    }
}


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
        Solution2 solution = new Solution2();
        int nums[] = {1,2,3,4,5};
        ListNode head = new ListNode(nums);

        solution.reverseBetween(head, 2, 4);
    }

    static class Solution {
        /**
         * 1、找反转链表左边界前一个节点lPre，右边界节点 r
         * 2、找左边界l = lPre.next 右边界后一个节点 RNext = r.next
         * 3、切断反转链表的联系
         * 4、反转链表
         * 5、左边界前一个节点接右节点 lPre.next = r 左边界点接右边界后一个节点l.next = rNext
         */
        public ListNode reverseBetween(ListNode head, int m, int n) {
            // -1 1 2 3 4 5
            ListNode preHead = new ListNode(-1);
            preHead.next = head;
            ListNode pre = preHead;
            // 第一步、找两个边界值，保存左边界前节点，右边界后节点
            // 反转链表最后一个节点
            ListNode lastReverseNode = head;
            for (int i = 0; i < m - 1; i++) {
                pre = pre.next;
            }

            for (int i = 0; i < n - 1; i++) {
                lastReverseNode = lastReverseNode.next;
            }
            // 反转链表左边界
            ListNode startReverseNode = pre.next;
            ListNode cur = lastReverseNode.next;

            // 切断联系
            pre.next = null;
            lastReverseNode.next = null;

            reverseNode(startReverseNode);

            // 头结尾，尾接头
            pre.next = lastReverseNode;
            startReverseNode.next = cur;
            return preHead.next;
        }

        private void reverseNode(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur!=null) {
                ListNode next =cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
        }
    }

    /**
     *头插法
     */
    static class Solution2 {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode preHead = new ListNode(-1);
            preHead.next = head;
            ListNode pre = preHead;
            for (int i = 0; i < m-1; i++) {
                pre = pre.next;
            }

            // i+1 = m;
            ListNode cur = pre.next;

            // 就是把next 插入到pre 和 cur之间
            for (int i = m; i < n; i++) {
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = cur;
                pre.next = next;
            }

            return preHead.next;
        }
    }
}


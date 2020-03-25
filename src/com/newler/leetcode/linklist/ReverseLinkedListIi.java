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
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        solution.reverseBetween(listNode1, 1, 2);
    }

    static class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null) {
                return head;
            }
            ListNode reverseHead = head;
            ListNode preReverseHead = null;
            while (m > 1 && reverseHead != null) {
                preReverseHead = reverseHead;
                reverseHead = reverseHead.next;
                m--;
                n--;
            }

            while (n > 1 && reverseHead != null && reverseHead.next != null) {
                ListNode nextReverseHead = reverseHead.next;
                // 先移除
                reverseHead.next = reverseHead.next.next;
                // 再插入
                if (preReverseHead == null) {
                    nextReverseHead.next = head;
                    head = nextReverseHead;
                } else  {
                    ListNode tmp = preReverseHead.next;
                    preReverseHead.next = nextReverseHead;
                    nextReverseHead.next = tmp;
                }
                n--;
            }
            return head;
        }
    }
}


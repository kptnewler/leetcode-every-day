package com.newler.leetcode.linklist;

import com.newler.leetcode.data.ListNode;
// [21]、合并两个有序链表

//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
// 输入：1->2->4, 0->3->5
//输出：1->1->2->3->4->4
//
// Related Topics 链表
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(5);

        l1 = mergeTwoLists(l1,l2);
        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
    /**
     * 解法插入排序，双指针
     *
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 !=null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next =new ListNode(l1.val);
                l1 = l1.next;
            } else  {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }
}


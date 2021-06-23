package com.newler.leetcode.linklist;

import com.newler.leetcode.data.ListNode;
// [21]、Merge Two Sorted Lists

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
        ListNode listNode = head;
        ListNode first = l1, second = l2;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                listNode.next = first;
                first = first.next;
            } else {
                listNode.next = second;
                second = second.next;
            }
            listNode = listNode.next;
        }

        if (first != null) {
            listNode.next = first;
        }

        if (second != null) {
            listNode.next = second;
        }

        return head.next;
    }
}


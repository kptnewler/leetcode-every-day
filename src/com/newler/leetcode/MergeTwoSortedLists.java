package com.newler.leetcode;
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
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode f1,f2;
        f1 = l1;

        // l2插入l1头部
        while (l2 != null) {
            if (l1.val > l2.val) {
                f2 = l2.next;
                //l2插入到l1的头部
                l2.next = l1;
                // l1重新指向头
                l1 = l2;
                // l2后移
                l2 = f2;
                f1 = l1;
            } else {
                break;
            }
        }

        // l2插入l1中间
        while (l2 != null && l1.next != null) {
            if (l1.val <= l2.val && l1.next.val >= l2.val) {
                f2 = l2.next;
                // 插入l2
                l2.next = l1.next;
                l1.next = l2;
                // l2后移
                l2 = f2;
            }
           l1 = l1.next;
        }

        // l2插入l1尾部
        if (l2 != null) {
            l1.next = l2;
        }
        return f1;
    }

}


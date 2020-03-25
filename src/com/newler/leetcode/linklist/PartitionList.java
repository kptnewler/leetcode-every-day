package com.newler.leetcode.linklist;
// [86]、分隔链表
// 2020年3月25日10:29:38
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针


import com.newler.leetcode.data.ListNode;

/**
 * 交换值，交换节点
 */
public class PartitionList {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(1);
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        solution.partition(listNode1, 0);
    }

    /**
     * 1，遇到比x小的，都插入到最前面
     * 2. 遇到比x大或等于，都插入到最后面
     * 3. 两个指针，一个指向小于x的节点，一个指向大于或等于x的节点
     */
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null ) return null;
            ListNode lessThanXTail = null;
            ListNode moreThanXTail = null;
            ListNode lessThanXHead = null;
            ListNode moreThanXHead = null;

            ListNode next = null;

            while (head != null) {
                next = head.next;
                head.next = null;
                if (head.val < x) {
                    if (lessThanXTail != null) {
                        lessThanXTail.next = head;
                    } else {
                        lessThanXHead = head;
                    }
                    lessThanXTail = head;
                } else {
                    if (moreThanXTail != null) {
                        moreThanXTail.next = head;
                    } else {
                        moreThanXHead = head;
                    }
                    moreThanXTail = head;
                }

                head = next;
            }

            if (lessThanXTail == null) {
                return moreThanXHead;
            }

            lessThanXTail.next = moreThanXHead;

            return lessThanXHead;

        }
    }
}


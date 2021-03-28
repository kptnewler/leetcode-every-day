package com.newler.leetcode.linklist;
// [21]、合并两个有序链表

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1598 👎 0


import com.newler.leetcode.data.ListNode;

import java.util.List;

public class MergeTwoSortedLists {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static void main(String[] args) {
        ListNode listNode1= new ListNode(new int[] {1,2,4});
        ListNode listNode2 = new ListNode(new int[] {1,3,4});
        Solution solution = new Solution();
        solution.mergeTwoLists(listNode1, listNode2);
    }

    static class Solution {

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head1, head2;
            head1 = l1;
            head2 = l2;
            ListNode pre1 = null;
            while (head1 != null && head2 != null) {
                    ListNode next = head2.next;
                    if (head2.val <= head1.val) {
                        // 插入到头节点
                        if (pre1 == null) {
                            head2.next = head1;
                            l1 = head2;
                        } else {
                            head2.next = pre1.next;
                            pre1.next = head2;
                        }
                        pre1 = head2;
                        head2 = next;
                    } else {
                        pre1 = head1;
                        head1 = head1.next;
                    }
                }

            if (head2 != null) {
                if (pre1 != null) {
                    pre1.next = head2;
                } else {
                    return l2;
                }
            }
            return l1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
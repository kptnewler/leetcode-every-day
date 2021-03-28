package com.newler.leetcode.linklist;
// [82]、删除排序链表中的重复元素 II
// 2021年3月25日18:39:02
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 551 👎 0


import com.newler.leetcode.data.ListNode;

public class RemoveDuplicatesFromSortedListIi {
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
        Solution solution = new Solution();
        int[] arr = {1,1,1,2,3};
        ListNode head = new ListNode(arr);
        solution.deleteDuplicates(head);
    }
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode cur = head, pre = null;

            while (cur != null) {
                // 继续后探
                while (cur.next!=null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // pre不为空，则不是前后节点关系，说明存在重复
                if (pre!=null && pre.next != cur) {
                    pre.next = cur.next;
                    cur = cur.next;
                    continue;
                }
                // pre为空，cur不为head，说明存在重复
                if (pre == null && cur != head) {
                    head = cur.next;
                    pre = null;
                    cur = head;
                    continue;
                }
                pre = cur;
                cur = cur.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


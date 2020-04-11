package com.newler.leetcode.linklist;
// [24]、两两交换链表中的节点
// 2020年4月9日09:28:41
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表


import com.newler.leetcode.data.ListNode;

public class SwapNodesInPairs {


//leetcode submit region begin(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        solution.swapPairs(new ListNode(nums));
    }

    /**
     * 解法：让cur.next指向下下个节点即next.next，下个节点next指向cur，让前一个节点指向next.
     * 1->2->3->4
     * 1. 让cur-1指向next.next-3，next-2指向cur-1 即为2->1->3->4
     * 2. 让pre-1指向next-4，cur-3指向next.next-null，4指向cur-3，即为2->1->3->4
     * 一定要注意边界条件
     *
     */
    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return head;
            ListNode next, cur, pre;
            pre = null;
            cur = head;
            next = head.next;
            head = head.next;
            while (cur.next != null) {
                cur.next = next.next;
                next.next = cur;
                if (pre != null) {
                    pre.next = next;
                }
                pre = cur;
                cur = cur.next;
                if (cur == null) break;
                next = cur.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


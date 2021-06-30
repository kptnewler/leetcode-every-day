package com.newler.leetcode.linklist;
// [206]、反转链表

//反转一个单链表。 
// 2020年3月23日09:45:29
// 示例: 
//
// 输入: 2->1->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表


import com.newler.leetcode.data.ListNode;

import java.util.List;

public class ReverseLinkedList {


//leetcode submit region begin(Prohibit modification and deletion)

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        Solution2 solution = new Solution2();
        solution.reverseList(new ListNode(nums));
    }

    /**
     * 整个思路如1->2->3->4->5
     * 1. 先删除1->3->4->5,再插入 2->1->3-4->5， cur永远指向节点1，head节点指向2
     * 2. 先删除2->1->4->5,再插入 3->2->1-4->5， cur永远指向节点1，head节点指向3
     * 以此类推
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) return null;
            ListNode  cur = head;
            while (cur.next != null) {
                // 保存删除节点
                ListNode tmp = cur.next;
                // 删除节点
                cur.next = cur.next.next;
                // 把节点插入到头部
                tmp.next = head;
                // 重新指向头节点
                head = tmp;
            }

            return head;
        }
    }

     static class Solution2 {
        /**
         * 当前节点的next指向前一个节点，以此类推
         */
         public ListNode reverseList(ListNode head) {
             if (head == null) return null;
             ListNode cur = head;
             ListNode pre = null;
             while (cur != null) {
                 ListNode next =cur.next;
                 cur.next = pre;
                 pre = cur;
                 cur = next;
             }

             return pre;
         }
     }
}


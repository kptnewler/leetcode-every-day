package com.newler.leetcode.linklist;
// [面试题 02.01]、移除重复节点
// 2020年4月12日09:23:34
//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 链表


import com.newler.leetcode.data.ListNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicateNodeLcci {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {1, 1, 1, 1, 2};
        solution.removeDuplicateNodes(new ListNode(nums));
    }

    /**
     * 通过后一个和前面的比较，时间复杂度为O(n^2)
     */
    static class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null) return null;
            ListNode start = head;


            while (start.next != null) {
                ListNode pre = start;
                ListNode cur = start.next;
                while (cur!=null) {
                    if (start.val == cur.val) {
                        pre.next = cur.next;
                    } else {
                        pre = cur;
                    }
                    cur = cur.next;
                }

                start = start.next;

                if (start == null) {
                    break;
                }
            }

            return head;
        }
    }

    /**
     * 使用hashmap，K为node.val，V为node，如果后面node.val已经在hashmap中则直接移除
     */
    class Solution2 {
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null) return null;
            Map<Integer, ListNode> hashMap = new LinkedHashMap<>();
            ListNode pre = head;
            ListNode cur = head.next;
            hashMap.put(head.val, head);
            while (cur!= null) {
                if (hashMap.containsKey(cur.val)) {
                    pre.next = cur.next;
                } else {
                    hashMap.put(cur.val, cur);
                    pre = cur;
                }
                cur = cur.next;
            }

            return head;
        }
    }
}
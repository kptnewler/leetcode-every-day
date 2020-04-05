package com.newler.leetcode.linklist;
// [138]、复制带随机指针的链表
// ${DATE}
//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。 
//
// 要求返回这个链表的 深拷贝。 
//
// 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示： 
//
// 
// val：一个表示 Node.val 的整数。 
// random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
// Related Topics 哈希表 链表


import com.newler.leetcode.data.ListNode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {


//leetcode submit region begin(Prohibit modification and deletion)

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node1.random = null;
        node2.next = node3;
        node2.random = null;
        node3.next = node4;
        node3.random = null;
        node4.next = node5;
        node4.random = null;

        Solution2 solution2 = new Solution2();
        solution2.copyRandomList(node1);
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node tmp = head;
            Map<Node, Node> copyNodeMap = new HashMap<>();
            while (tmp != null) {
                copyNodeMap.put(tmp, new Node(tmp.val));
                tmp = tmp.next;
            }

            tmp = head;
            while (tmp != null) {
                Node copyNode = copyNodeMap.get(tmp);
                if (copyNode.next != null) {
                    copyNode.next = copyNodeMap.get(tmp.next);
                }
                if (copyNode.random != null) {
                    copyNode.random = copyNodeMap.get(tmp.random);
                }
                tmp = tmp.next;
            }

            return copyNodeMap.get(head);
        }
    }

    static class Solution2 {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node cur = head;
            Node next;
            // 把复制连接插入到cur和next之间，如1->2->3 变成1->1'->2->2'->3'->3
            while (cur != null) {
                next = cur.next;
                cur.next = new Node(cur.val);
                cur.next.next = next;
                cur = next;
            }

            Node copyCur = null;
            cur = head;
            while (cur != null) {
                copyCur = cur.next;
                copyCur.random = cur.random == null ? null : cur.random.next;
                cur = cur.next.next;
            }

            cur = head;
            Node res = head.next;
            while (cur != null) {
                next = cur.next.next;
                copyCur = cur.next;
                cur.next = next;
                copyCur.next = next == null ? null : next.next;
                cur = next;
            }

            return res;
        }
    }
}


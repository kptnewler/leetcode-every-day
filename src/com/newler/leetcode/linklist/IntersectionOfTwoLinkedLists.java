package com.newler.leetcode.linklist;
// [160]、相交链表
// 2020年3月30日09:41:40
//编写一个程序，找到两个单链表相交的起始节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 
// Related Topics 链表


import com.newler.leetcode.data.ListNode;

/**
 * 这题相交表示节点相交，相交的节点相同，并不是单单值相同
 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int nums1[] = {1,2,3,4,5};
        int nums2[] = {1,2,3,4,5};
        ListNode listNodeA = new ListNode(nums1);
        ListNode listNodeB = new ListNode(nums1);

        solution.getIntersectionNode(listNodeA, listNodeB);
    }

    /**
     * 解法二:更妙
     * 如果长度A，B链表长度不相等 , A = a + c, B = b+c, c是公共部分
     * 如果A比B短，A先走完就去走B。
     * 走一个循环，A+B = B+A， 总长度相同
     * 整个走的过程如下，一次走完长度相同，如果链表相交下次必然碰到一起
     * a1->a2->a3->ab1->ab2->b1->b2->ab1->ab2
     * b1->b2->ab1->ab2->a1->a2->a3->ab1->ab2
     *
     */
    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA = headA, curB = headB;
            // 如果长度不相等 null ！= curB，curA则切换到对方
            // 如果两者长度相等，但是不匹配，null = null，则返回null。
            while (curA != curB) {
                curA = curA == null ?  headB: curA.next;
                curB = curB == null ? headA : curB.next;
            }
            return curA;
        }
    }
}


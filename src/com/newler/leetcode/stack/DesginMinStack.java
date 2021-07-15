package com.newler.leetcode.stack;
// [155]、最小栈

//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) -- 将元素 x 推入栈中。
// pop() -- 删除栈顶的元素。
// top() -- 获取栈顶元素。
// getMin() -- 检索栈中的最小元素。
//
//
// 示例:
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
// Related Topics 栈 设计


import com.newler.leetcode.data.ListNode;

import java.util.Stack;

public class DesginMinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    /**
     * 解法1：自己思考，使用链表，如果pop的值为min，重新遍历找到新的min，pop min的时间复杂度为O(n)
     * 9ms,52.1MB
     */
    static class MinStack {
        private ListNode head;
        private int min = Integer.MAX_VALUE;

        public MinStack() {

        }

        public void push(int x) {
            if (x < min) {
                min = x;
            }
            if (head == null) {
                head = new ListNode(x);
                return;
            }

            ListNode newNode = new ListNode(x);
            newNode.next = head;
            head = newNode;
        }

        public void pop() {
            if (head == null) {
                return;
            }

            // 如果移除的是最小值，那么重新找个最小值
            if (head.val == min) {
                ListNode minNode = head.next;
                min = Integer.MAX_VALUE;
                while (minNode != null) {
                    if (minNode.val < min) {
                        min = minNode.val;
                    }
                    minNode = minNode.next;
                }
            }
            head = head.next;
        }

        public int top() {
            if (head != null) {
                return head.val;
            }
            return -1;
        }

        public int getMin() {
            return min;
        }
    }

    /**
     * 解法2：空间换时间，使用两个栈，dataStack保存数据，minStack用于保存最小值，
     * 解法一面临的问题是如果最小值弹出，需要重新从stack找到最小值
     * 现在采用minStack保存最小值，如果最小值弹出，新的最小值还是minStack中，消除了o(n)
     * 时间复杂度为8ms，
     */
    static class MinStack2 {
        /** initialize your data structure here. */
        private Stack<Integer> dataStack;
        int min = Integer.MAX_VALUE;
        public MinStack2() {
            dataStack = new Stack<>();
        }

        public void push(int x) {
            if (x <= min) {
                // 先保存上个最小值
                dataStack.push(min);
                min = x;
            }
            dataStack.push(x);
        }

        public void pop() {
            int x = dataStack.pop();
            if (x == min) {
                min = dataStack.pop();
            }
        }

        public int top() {
            return dataStack.isEmpty() ? -1 : dataStack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}


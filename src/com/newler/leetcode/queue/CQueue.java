package com.newler.leetcode.queue;
// [面试题09]、用两个栈实现队列

//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
// 分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//
//
// 示例 1：
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
//
//
// 示例 2：
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
//
//
// 提示：
//
//
// 1 <= values <= 10000
// 最多会对 appendTail、deleteHead 进行 10000 次调用
//
// Related Topics 栈 设计


import java.util.Stack;

/**
 * 解法1：倒水方式，一个保存正向序列，一个保存负向序列，1，2,3；3,2,1
 * 	130 ms
 */
public class CQueue {
    private Stack<Integer> tailStack;
    private Stack<Integer> headStack;

    public CQueue() {
        tailStack = new Stack<>();
        headStack = new Stack<>();
    }

    public void appendTail(int value) {
        headStack.push(value);
    }

    public int deleteHead() {
        // tailStack 为空才重新从headStack中添加
        if (tailStack.isEmpty()) {
            while (!headStack.isEmpty()) {
                tailStack.push(headStack.pop());
            }
        }
        return tailStack.isEmpty() ? -1 : tailStack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

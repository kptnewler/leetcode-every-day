package com.newler.leetcode.stack;

import java.util.Stack;

/**
 * 摘要：一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。除此之外  ，
 * 可以申请新的变量，但不能申请额外的数据结构。如何完成排序
 *
 * 解法插入排序，sortStack中从顶到低从小到大排序，然后再导入到dataStack中即为从大到小
 * dataStack中弹出的dsPopValue和sortStack栈顶ssPeekValue比较，
 * 如果dsPopValue>ssPeekValue，sortStack逐个弹出栈顶元素，
 * 直到sortStack为空或者遇到比dsPopValue更大的值为止，再把dsPopValue压入到sortStack中
 * 如果dsPopValue<=ssPeekValue，直接压入
 */
public class StackSort {
    public static void main(String[] args) {
        Stack<Integer> dataStack = new Stack<>();
        dataStack.push(5);
        dataStack.push(2);
        dataStack.push(3);
        dataStack.push(1);

        sort(dataStack);

        dataStack.forEach(System.out::println);

    }

    private static void sort(Stack<Integer> dataStack) {

        Stack<Integer> sortStack = new Stack<>();

        while (!dataStack.isEmpty()) {
            int popValue = dataStack.pop();
            while (!sortStack.isEmpty() && popValue > sortStack.peek()) {
                dataStack.push(sortStack.pop());
            }
            sortStack.push(popValue);
        }

        while (!sortStack.isEmpty()) {
            dataStack.push(sortStack.pop());
        }
    }
}

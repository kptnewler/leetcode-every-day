package com.newler.leetcode.data;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public ListNode(int[] arr) {
        //任何函数的处理都需要考虑边界条件，
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr 是一个空的节点");
        }
        this.val = arr[0];
        //this就是当前对象节点
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            //创建新的节点将数组中的值保存到节点中
            cur.next = new ListNode(arr[i]);
            //将新创建的节点设置为当前节点
            cur = cur.next;
        }
    }
}

package com.newler.leetcode.hashmap;
// [146]、LRU 缓存机制
// ${DATE}
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1274 👎 0


import com.sun.jmx.snmp.SnmpOid;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LruCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class LRUCache {
        HashMap<Integer, Node> hashMap;
        int size = 0;
        int capacity;
        Node head, tail;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            hashMap = new HashMap<>(capacity);
        }

        public int get(int key) {
            Node node = hashMap.get(key);
            if (node == null) return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) return;

            // 如果键存在
            if (hashMap.containsKey(key)) {
                Node node = hashMap.get(key);
                node.value = value;
                moveToHead(node);
                return;
            }

            if (capacity == size) {
                removeNode(tail);
            }
            Node node = new Node(value, key, null, null);
            addNode(node);

        }

        /**
         * 相互指向
         */
        private void removeNode(Node node) {
            if (node.pre != null) {
                node.pre.next = node.next;
            }

            if (node.next != null) {
                node.next.pre = node.pre;
            }

            if (node == head) {
                head = node.next;
            }

            if (node == tail) {
                tail = node.pre;
            }
            hashMap.remove(node.key);

            size--;
        }

        /**
         *头插法 插入节点
         */
        private void addNode(Node node) {
            if (head != null) {
                node.next = head;
                node.pre = null;
                head.pre = node;
                head = node;
            }
            if (head == null) {
                head =tail= node;
            }
            hashMap.put(node.key, node);
            size++;

        }

        private void moveToHead(Node node) {
            if (node == head) return;
            removeNode(node);
            addNode(node);
        }

        class Node {
            int key;
            int value;
            Node pre;
            Node next;
            public Node(int value, int key, Node pre, Node next) {
                this.value = value;
                this.key = key;
                this.pre = pre;
                this.next = next;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}


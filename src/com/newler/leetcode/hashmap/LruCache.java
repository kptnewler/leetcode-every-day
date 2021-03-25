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


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LruCache {
    public static void main(String[] args) {
        LinkedHashMap lruCache = new LinkedHashMap<Integer, Integer>(2, 0.75f, true);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(2);
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
            int value = -1;
            if (node != null) {
                value = node.value;
                if (node != head) {
                    // 挪动到头结点
                    removeNode(node);
                    addHead(node);
                }
            }
            return value;
        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            Node node = hashMap.get(key);
            // 判断在不在链表中
            if (node != null) {

                // 在链表中，直接删除旧节点
                removeNode(node);
                size--;
            }

            // 判断有没有满
            if (size == capacity) {
                if (tail != null) {
                    // 满了挪作最后一个
                    hashMap.remove(tail.key);
                    removeNode(tail);
                    size--;
                }
            }

            // 再插入到头结点
            Node newNode = new Node(value, key, null, head);
            addHead(newNode);
            hashMap.put(key, newNode);
            size++;
        }

        private void removeNode(Node node) {
            Node next = node.next;
            Node pre=  node.pre;
            if (next != null) {
                next.pre = pre;
            }

            if (pre != null) {
                pre.next = next;
            }

            if (node == tail) {
                tail = pre;
            }
            if (node == head) {
                head = next;
            }
        }

        private void addHead(Node node) {
            node.pre = null;
            node.next = head;
            if (head != null) {
                head.pre = node;
            }
            if (tail == null) {
                tail = node;
            }
            head = node;
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


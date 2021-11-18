package chapter5_hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author koujn
 * @date 2021/11/18 10:56
 */

/**
 * 题目：请设计实现一个最近最少使用(Least Recently Used , LRU) 缓存，要求如下两个操作的时间复杂度都是O(1)
 * 1.get(key) : 如果缓存中存在键key,则返回它对应的值;否则返回-1。
 * 2.put(key,value) : 如果缓存中之前包含key，则它的值设为value;否则添加键key及对应的值value。
 * 在添加一个键时，如果缓存容量已经满了，则在添加新键之前删除最近最少使用的键(缓存中最长时间没有被使用过的元素)。
 */
public class Questions_31 {

    static class ListNode{
        public int key;
        public int value;
        private ListNode next;
        private ListNode prev;

        public ListNode(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    static class LRUCache {
        private ListNode head;
        private ListNode tail;
        private Map<Integer,ListNode> map;
        int capacity;

        public LRUCache(int cap) {
            this.capacity = cap;
            map = new HashMap<>();
            head = new ListNode(-1,-1);
            tail = new ListNode(-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            ListNode node = map.get(key);
            if( node == null ) {
                return -1;
            }
            moveToTail(node,node.value);
            return node.value;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                moveToTail(map.get(key),value);
            }else {
                if(map.size() == capacity) {
                    ListNode toBeDeleted = head.next;
                    deleteNode(toBeDeleted);
                    map.remove(toBeDeleted.key);
                }
                ListNode node = new ListNode(key, value);
                insertToTail(node);
                map.put(key,node);
            }
        }

        private void moveToTail(ListNode node, int newValue) {
            deleteNode(node);
            node.value = newValue;
            insertToTail(node);
        }

        private void deleteNode(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void insertToTail(ListNode node) {
            tail.prev.next = node;
            node.prev = tail.prev.next;
            node.next = tail;
            tail.prev = node;
        }
    }
}

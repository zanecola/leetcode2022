package questions.leetcode.editor.en;

//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise 
//return -1. 
// void put(int key, int value) Update the value of the key if the key exists. 
//Otherwise, add the key-value pair to the cache. If the number of keys exceeds 
//the capacity from this operation, evict the least recently used key. 
// 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10⁴ 
// 0 <= value <= 10⁵ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
//
// Related Topics Hash Table Linked List Design Doubly-Linked List 👍 16255 👎 7
//16


//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise 
//return -1. 
// void put(int key, int value) Update the value of the key if the key exists. 
//Otherwise, add the key-value pair to the cache. If the number of keys exceeds 
//the capacity from this operation, evict the least recently used key. 
// 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10⁴ 
// 0 <= value <= 10⁵ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
//
// Related Topics Hash Table Linked List Design Doubly-Linked List 👍 16255 👎 7
//16


import java.util.HashMap;
import java.util.Map;

public class Q146LruCache {
    public static void main(String[] args) {
        var cache = new Q146LruCache().new LRUCache(2);
        cache.put(2, 6);
        cache.put(1, 5);
        cache.put(2, 2);
        cache.put(4, 1);
        cache.get(1);
        cache.get(2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        class MyNode {
            int key;
            int value;
            MyNode pre;
            MyNode next;

            MyNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            MyNode() {
            }
        }

        Map<Integer, MyNode> map = new HashMap<>();

        MyNode head;
        MyNode tail;

        final int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
            this.head = new MyNode();
            this.tail = new MyNode();

            head.next = tail;
            tail.next = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;

            var node = map.get(key);

            var pre = node.pre;
            var next = node.next;

            pre.next = next;
            next.pre = pre;

            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;

            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.get(key).value = value;
                this.get(key);
                return;
            }
            MyNode node = new MyNode(key, value);

            if (map.keySet().size() == cap) {
                map.remove(tail.pre.key);
                tail.pre = tail.pre.pre;
                tail.pre.next = tail;
            }

            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;

            map.put(key, node);
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
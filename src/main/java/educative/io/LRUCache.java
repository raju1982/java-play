package educative.io;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
LRU design -
An LRU cache should support the operations: lookup, insert and delete.
Apparently, in order to achieve fast lookup, we need to use hash.
By the same token, if we want to make insert/delete fast, something like linked list should come to your mind.
Since we need to locate the least recently used item efficiently, we need something in order like queue, stack or sorted array.

To combine all these analyses -
 we can use queue implemented by a doubly linked list to store all the resources.
 a hash table with resource identifier as key and address of the corresponding queue node as value is needed.
*/

/*
The LRU cache is a hash table of keys and double linked nodes.
The hash table makes the time of get() to be O(1).
The list of double linked nodes make the nodes adding/removal operations O(1).
*/

public class LRUCache {
    //doubly linked node (queue implementation)
    final Node head = new Node(0, 0);
    final Node tail = new Node(0, 0);
    //hashmap
    final Map<Integer, Node> map;
    final int capacity;

    //
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int res = -1;
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            insertToHead(n);
            res = n.value;
        }
        return res;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            //remove node from doubly link list
            remove(n);
            //update value of node
            n.value = value;
            //add node to head - > headNode -> Node n -> existing nodes
            insertToHead(n);
        } else {
            if (map.size() == capacity) {
                //remove key-value[node] from hash map
                //Last Recently Used Cache Eviction
                map.remove(tail.prev.key);
                //remove node from tail of doubly link list
                remove(tail.prev);
            }
            Node n = new Node(key, value);
            //add node to head - > headNode -> Node n -> existing nodes
            insertToHead(n);
            //add key-value[node] in hashmap
            map.put(key, n);
        }
    }

    //update double link list
    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    //headNode -> Node n -> existing nodes
    private void insertToHead(Node n) {
        Node headNext = head.next;
        head.next = n;
        headNext.prev = n;
        n.prev = head;
        n.next = headNext;
    }

    class Node {
        Node prev, next;
        int key, value;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(4, 40);
        lruCache.put(4, 60);
    }

}


/*
An unbounded thread-safe queue based on linked nodes. This queue orders elements FIFO (first-in-first-out). T
 */

class ConcurrentLRUCache<Key, Value> {

    private final int maxSize;
    private ConcurrentHashMap<Key, Value> map;
    private ConcurrentLinkedQueue<Key> queue;

    public ConcurrentLRUCache(final int maxSize) {
        this.maxSize = maxSize;
        map = new ConcurrentHashMap<Key, Value>(maxSize);
        //queue has only keys to identify least recently used item efficiently
        queue = new ConcurrentLinkedQueue<Key>();
    }

    public void put(final Key key, final Value value) {
        //null check

        if (map.containsKey(key)) {
            // remove the key from queue.
            queue.remove(key);
        }

        while (queue.size() >= maxSize) {
            // remove the key from queue head.
            //Last Recently Used Cache Eviction
            Key oldestKey = queue.poll();
            if (null != oldestKey) {
                map.remove(oldestKey);
            }
        }
        // add key to queue tail.
        queue.add(key);
        //override value in map.
        map.put(key, value);
    }

    public Value get(final Key key) {
        return map.get(key);
    }
}
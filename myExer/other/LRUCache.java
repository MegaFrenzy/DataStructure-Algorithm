package other;

import java.util.HashMap;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-07-31 11:11
 */
public class LRUCache {
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }
    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private DLinkedNode head, tail;
    private int capacity;
    private int count;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.pre = null;
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }

    private DLinkedNode pollNode(DLinkedNode node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
        node.pre = null;
        node.post = null;
        return node;
    }
    private void moveToHead(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            //取出并放到队头
            DLinkedNode temp = pollNode(node);
            moveToHead(temp);
            return temp.value;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            moveToHead(newNode);
            count++;
            if (count > capacity) {
                DLinkedNode delNode = pollNode(tail.pre);
                cache.remove(delNode.key);
                count--;
            }
        } else {
            node.value = value;
            moveToHead(pollNode(node));
        }
    }


}

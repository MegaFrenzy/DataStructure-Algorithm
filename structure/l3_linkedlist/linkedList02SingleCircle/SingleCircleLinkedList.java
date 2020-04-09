package l3_linkedlist.linkedList02SingleCircle;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-02 09:56
 */
public class SingleCircleLinkedList {
    private ListNode first;
    private ListNode tail;

    public ListNode getFirst() {
        return first;
    }

    public void add(ListNode node) {
        if (node == null)
            return;
        if (first == null) {
            first = node;
            tail = node;
            node.next = node;
            return;
        }
        tail.next = node;
        tail = node;
        node.next = first;


    }

    public void print() {
        if (tail == null) {
            System.out.println("there is no node");
            return;
        }

        ListNode cursor = first;
        do {
            System.out.println(cursor);
            cursor=cursor.next;
        } while (cursor!=first);
        System.out.println("-----");

    }
}

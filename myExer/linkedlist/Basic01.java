package linkedlist;


import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-10 19:03
 */
public class Basic01 {

    //24. 两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cursor = dummy;
        while (cursor != null) {
            cursor = _swapPairs(cursor);
        }

        return dummy.next;
    }

    //head -> n1 -> n2 ... nk -> nk+1
    //head -> nk -> nk-1 ... n1 -> nk+1
    //
    private ListNode _swapPairs(ListNode head) {
        ListNode n1 = head.next;
        ListNode nk = head;
        for (int i = 0; i < 2; i++) {
            nk = nk.next;
            if (nk == null) {
                return null;
            }
        }
        ListNode nkNext = nk.next;

        ListNode temp = null;
        ListNode cur = head.next;
        ListNode pre = null;
        while (cur != nkNext) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = nk;
        n1.next = nkNext;
        return n1;
    }

    //一个链表，假设第一个节点我们定为下标为1，第二个为2，
    // 那么下标为奇数的结点是升序排序，偶数的结点是降序排序，
    // 如何让整个链表有序？（分离链表，合并两个有序链表）
    private void solution(ListNode head) {
        ListNode[] nodes = mergeLinkedList(head);
        System.out.println(nodes[0].print());
        System.out.println(nodes[1].print());

        nodes[1] = reverseList(nodes[1]);
        System.out.println(nodes[1].print());
    }

    public ListNode[] mergeLinkedList(ListNode head) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode n1 = dummy1;
        ListNode n2 = dummy2;

        ListNode cursor = head;
        while (cursor != null && cursor.next != null) {
            n1.next = new ListNode(cursor.val);
            n1 = n1.next;
            n2.next = new ListNode(cursor.next.val);
            n2 = n2.next;
            cursor = cursor.next.next;
        }
        if (cursor != null) {
            n1.next = new ListNode(cursor.val);
        }
        ListNode[] nodes = new ListNode[2];
        nodes[0] = dummy1.next;
        nodes[1] = dummy2.next;
        return nodes;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(9);
        n1.next = n2;
        ListNode n3 = new ListNode(4);
        n2.next = n3;
        ListNode n4 = new ListNode(8);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode n6 = new ListNode(7);
        n5.next = n6;
        ListNode n7 = new ListNode(6);
        n6.next = n7;

        Basic01 b = new Basic01();
        b.solution(n1);


    }

}


package linkedlist;

import l3_linkedlist.linkedList02SingleCircle.ListNode;

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

}

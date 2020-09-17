package linkedlist;


/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-09-14 00:43
 */
public class LeetCode25reverseK {
    public static void main(String[] args) {
        LeetCode25reverseK l = new LeetCode25reverseK();
        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next = new ListNode(10);
        ListNode res = l.Lc25reverseKGroup(head, 3);
        String ss = res.print();
        System.out.println(ss);
    }
    private boolean isEnd = false;
    public ListNode Lc25reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cursor = dummy;

        while (cursor != null || !isEnd) {
            cursor = reverseK(cursor, k);
        }
        return dummy.next;

    }

    private ListNode reverseK(ListNode preHead, int k) {

        ListNode n1 = preHead.next;
        ListNode nk = preHead;
        for (int i = 0; i < k; i++) {
            nk = nk.next;
            if (nk == null) {
                isEnd = true;
                ListNode newHead = reverseBase(preHead.next, null);
                preHead.next = newHead;
                return null;
            }
        }
        ListNode nkNext = nk.next;

        ListNode cur = n1;
        ListNode newHead = reverseBase(cur, nkNext);

        preHead.next = newHead;
        n1.next = nkNext;
        return n1;
    }

    private ListNode reverseBase(ListNode cur, ListNode bound) {
        if (cur == null || cur.next == null) return cur;
        ListNode temp = null;
        ListNode pre = null;
        while (cur != bound) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

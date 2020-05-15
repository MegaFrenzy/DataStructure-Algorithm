package linkedlist;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-09 09:07
 */
public class MergeSort {
    public static void main(String[] args) {
        Node n1 = new Node(6);
        n1.next = new Node(1);
//        n1.next.next = new Node(3);
        //n1.toPrint();

        MergeSort ms = new MergeSort();
        Node res = ms.mergeSort0(n1);
        res.toPrint();
    }

    private Node mergeSort0(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node midNode = findMidNode(head);
        Node n1 = mergeSort0(head);
        Node n2 = mergeSort0(midNode);
        return merge(n1, n2);
    }

    private Node merge(Node n1, Node n2) {
        Node dummy = new Node(Integer.MIN_VALUE);
        Node p = dummy;
        while (n1 != null && n2 != null) {
            if (n1.value <= n2.value) {
                p.next = n1;
                n1 = n1.next;
            } else {
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }
        if (n1 != null) {
            p.next = n1;
        }
        if (n2 != null) {
            p.next = n2;
        }
        return dummy.next;
    }

    private Node findMidNode(Node head) {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node midHead = slow.next;
        slow.next = null;
        return midHead;
    }

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        void toPrint() {
            Node cursor = this;
            while (cursor != null) {
                System.out.print(cursor.value + " ");
                cursor = cursor.next;
            }
        }
    }
}

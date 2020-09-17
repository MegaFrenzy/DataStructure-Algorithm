package l3_linkedlist.linkedList02SingleCircle;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-02 10:35
 */
public class Josephu {
    public static void main(String[] args) {
        count(1, 2, 25);
    }

    public static void count(int startNo, int countNo, int nums) {
        //参数检测
        if (startNo < 1 || countNo < 0 || nums < 1 || startNo > nums)
            return;
        //节点添加
        SingleCircleLinkedList list = new SingleCircleLinkedList();
        for (int i = 0; i < nums; i++) {
            ListNode node = new ListNode(i + 1);
            list.add(node);
        }
        //辅助结点的设定
        ListNode startCursor = list.getFirst();
        for (int i = 1; i < startNo; i++) {
            startCursor = startCursor.next;
        }
        ListNode preCursor = startCursor;
        while (preCursor.next != startCursor) {
            preCursor = preCursor.next;
        }

        //游戏循环
        while (startCursor != preCursor) {
            for (int i = 1; i < countNo; i++) {
                startCursor = startCursor.next;
                preCursor = preCursor.next;
            }
            System.out.printf("no.%d game over\n", startCursor.value);
            preCursor.next = startCursor.next;
            startCursor.next = null;
            startCursor = preCursor.next;
        }
        System.out.printf("no.%d win\n", startCursor.value);


    }
}

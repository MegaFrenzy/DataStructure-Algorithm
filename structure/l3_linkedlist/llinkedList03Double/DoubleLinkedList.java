package l3_linkedlist.llinkedList03Double;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-01 20:20
 */
public class DoubleLinkedList {

    private HeroNode head;

    public DoubleLinkedList() {
        head = new HeroNode();
    }

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode node) {
        HeroNode cursor = head;
        while (cursor.hasNext()) {
            cursor = cursor.next;
        }
        cursor.next = node;
        node.pre = cursor;
    }

    public void addByOrder(HeroNode node) {

        HeroNode cursor = head;
        boolean bSame = false;
        while (cursor.hasNext()) {
            if (cursor.next.hero.no == node.hero.no) {
                bSame = true;
                break;
            }
            if (cursor.next.hero.no > node.hero.no) {
                break;
            }
            cursor = cursor.next;
        }
        if (!bSame) {
            node.next = cursor.next;
            if (cursor.next != null) {
                cursor.next.pre = node;
            }
            node.pre = cursor;
            cursor.next = node;
        } else {
            System.out.println("the number" + node.hero.no + "already exists ");
        }
    }

    public void delete(int no) {
        if (head.next == null)
            return;
        HeroNode cursor = head.next;
        boolean bFound = false;
        while (cursor.hasNext()) {
            if (cursor.hero.no == no) {
                bFound = true;
                break;
            }
            cursor = cursor.next;
        }
        if (bFound) {
            cursor.pre.next = cursor.next;
            //如果是最后一个节点需要先判断，否则会出现空指针异常
            if (cursor.hasNext()) {
                cursor.next.pre = cursor.pre;
            }
        } else {
            System.out.println("can not find the node" + no + " to delete");
        }

    }

    public void update(HeroNode node) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode cursor = head;
        boolean bSame = false;
        while (cursor.hasNext()) {
            cursor = cursor.next;
            if (cursor.hero.no == node.hero.no) {
                bSame = true;
                break;
            }

        }
        if (bSame) {
            cursor.hero.name = node.hero.name;
            cursor.hero.nickname = node.hero.nickname;
        }
    }

    public void list() {
        HeroNode cursor = head;
        while (cursor.next != null) {
            System.out.println(cursor = cursor.next);
        }
        System.out.println("-----------------");
    }
}

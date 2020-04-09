package l3_linkedlist.linkedList01Single;

import l3_linkedlist.Hero;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-02-29 23:25
 */
public class SingleLinkedList {
    private HeroNode head;

    public SingleLinkedList() {
        head = new HeroNode();
    }

    public void add(HeroNode node) {
        HeroNode cursor = head;
        while (cursor.hasNext()) {
            cursor = cursor.next;
        }
        cursor.next = node;
    }

    public HeroNode getHead() {
        return head;
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
            cursor.next = node;
        } else {
            System.out.println("the number" + node.hero.no + "already exists ");
        }

    }

    public void Update(HeroNode node) {
        //判断是否为空
        if(head.next==null){
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

    public void delete(int no) {
        HeroNode cursor = head;
        boolean bFound = false;
        while (cursor.hasNext()) {
            if (cursor.next.hero.no == no) {
                bFound = true;
                break;
            }
            cursor = cursor.next;
        }
        if (bFound) {
            System.out.printf("no.%d has been delete\n",no);
            cursor.next = cursor.next.next;
//            HeroNode cursorHelper = cursor.next;
//            cursor.next=cursorHelper.next;
//            cursorHelper.next=null;
//            cursorHelper=null;
        }else{
            System.out.println("can not find the node"+ no +" to delete");
        }
    }

    public int getLength(HeroNode head){
        HeroNode cursor = head;
        int length=0;
        while(cursor.hasNext()){
            length++;
            cursor=cursor.next;
        }
        return length;

    }
    public void list() {
        HeroNode cursor = head;
        while (cursor.next!=null) {
            System.out.println(cursor = cursor.next);
        }
        System.out.println("-----------------");
    }



}

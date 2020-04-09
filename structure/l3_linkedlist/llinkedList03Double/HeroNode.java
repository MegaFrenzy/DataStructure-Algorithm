package l3_linkedlist.llinkedList03Double;

import l3_linkedlist.Hero;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-01 20:23
 */
public class HeroNode {
    public Hero hero;
    public HeroNode pre;
    public HeroNode next;

    public HeroNode() {

    }

    public HeroNode(Hero hero) {
        this.hero = hero;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "hero=" + hero +
                '}';
    }
    public boolean hasNext(){
        return next!=null;
    }

}

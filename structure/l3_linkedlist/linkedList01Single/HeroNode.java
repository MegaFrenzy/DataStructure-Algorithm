package l3_linkedlist.linkedList01Single;

import l3_linkedlist.Hero;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-02-29 23:31
 */
public class HeroNode {
    public Hero hero;
    public HeroNode next;

    public HeroNode(Hero hero) {
        this.hero = hero;
    }

    public HeroNode() {
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "hero=" + hero +
                //", next=" + next +
                '}';
    }
    public boolean hasNext(){
        return next!=null;
    }
}

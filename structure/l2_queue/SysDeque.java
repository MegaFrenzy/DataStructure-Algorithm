package l2_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-07 16:59
 */


/**
 * Summary of Queue methods (Interface)
 * 	            Throws exception    Returns special value
 *     Insert	    add(e)	            offer(e)
 *     Remove	    remove()	        poll()
 *     Examine	    element()	        peek()
 */


/**
 * Summary of Deque methods (Interface)
 * First            Element (Head)                  Last Element (Tail)
 * Throws   exception	    Special value	Throws exception	Special value
 * Insert	addFirst(e)	    offerFirst(e)	addLast(e)	        offerLast(e)
 * Remove	removeFirst()	pollFirst()	    removeLast()	    pollLast()
 * Examine	getFirst()	    peekFirst()	    getLast()	        peekLast()
 */
public class SysDeque {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        //d  b  c  a
//        deque.offerFirst("a");
//        deque.offerFirst("c");
//        System.out.println(deque);
//        deque.offerFirst("b");
//        deque.offerFirst("d");
//        System.out.println(deque);
//        System.out.println(deque.peekFirst());
//        System.out.println(deque.peekLast());
//        System.out.println(deque);
//        while (deque.size() > 0) {
//            System.out.println(deque.pollFirst());
//        }

        System.out.println(deque);
        System.out.println("===========");
        deque.addLast(1);
        deque.addLast(3);
        deque.addLast(5);
//        System.out.println(deque.removeLast() * deque.getLast());
        System.out.println(deque.getLast() * deque.removeLast());
    }
}

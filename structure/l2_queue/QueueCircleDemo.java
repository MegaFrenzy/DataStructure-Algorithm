package l2_queue;

import java.util.Scanner;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-02-29 21:06
 */
public class QueueCircleDemo {
    public static void main(String[] args) {
        QueueCircle queue = new QueueCircle(4);
        boolean token=true;
        Scanner scanner = new Scanner(System.in);
        char ch;
        while(token){
            System.out.println("s:show the queue");
            System.out.println("e:exit program");
            System.out.println("a:add a number into queue");
            System.out.println("g:get a number into queue");
            System.out.println("h:show the head number");
            ch = scanner.next().charAt(0);
            switch(ch){
                case 's':
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    token=false;
                    scanner.close();
                    break;
                case 'a':
                    System.out.println("please input a num to add");
                    try {
                        queue.addQueue(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.printf("the num got is %d\n",queue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = queue.headQueue();
                        System.out.println("head = " + head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }

        }
        System.out.println("exit...");

    }
}

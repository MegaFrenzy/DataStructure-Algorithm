package thread;

import java.util.Date;
import java.util.LinkedList;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-28 14:18
 */
public class ProducerConsumerModel {
    public static void main(String[] args) {
        EventStorage es = new EventStorage();
        Producer producer = new Producer(es);
        Consumer consumer = new Consumer(es);
        new Thread(producer).start();
        new Thread(consumer).start();

    }

}

class Producer implements Runnable {
    EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.put();
        }
    }
}

class Consumer implements Runnable {
    EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.get();
        }
    }
}

class EventStorage {
    int maxSize;
    LinkedList<Date> list;

    public EventStorage() {
        this.maxSize = 10;
        this.list = new LinkedList<>();
    }

    public synchronized void put() {
        while (list.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(new Date());
        System.out.println("仓库里有了" + list.size()+"个产品");
        notify();
    }

    public synchronized void get() {
        while (list.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到"+list.poll()+",仓库里还有" + list.size()+"个产品");
        notify();
    }

}

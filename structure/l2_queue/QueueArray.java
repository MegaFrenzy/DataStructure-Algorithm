package l2_queue;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-02-29 20:27
 */
public class QueueArray implements Queue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public QueueArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    @Override
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public void addQueue(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        arr[++rear] = num;
    }

    @Override
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        return arr[++front];
    }

    @Override
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }

    }

    @Override
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("the queue is empty");
        }

        return arr[front+1];
    }
}

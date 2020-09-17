package l2_queue;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-02-29 22:09
 */
public class QueueCircle implements Queue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public QueueCircle(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    @Override
    public void addQueue(int num) {
        if (isFull()) {
            throw new RuntimeException("the queue is full");
        }
        arr[rear++] = num;
        rear %= maxSize;
        System.out.println(num + "has been added");
    }

    @Override
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("the queue is empty");
        }
        int head = arr[front++];
        front %= maxSize;
        return head;
    }

    @Override
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("the queue is empty");
        }
        int num = (rear - front + maxSize) % maxSize;
        for (int i = front; i < front + num; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    @Override
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("the queue is empty");
        }
        return arr[front];
    }
}

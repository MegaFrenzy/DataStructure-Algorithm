package l2_queue;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-02-29 20:25
 */
public interface Queue {
    public boolean isFull();
    public boolean isEmpty();
    public void addQueue(int num);
    public int getQueue();
    public void showQueue();
    public int headQueue();

}

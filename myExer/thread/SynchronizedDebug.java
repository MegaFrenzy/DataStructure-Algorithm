package thread;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-27 18:41
 */
public class SynchronizedDebug implements Runnable{
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("我是对象锁的代码块形式，我叫"
                    + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }

    private  synchronized static void method1() {

    }

    public static void main(String[] args) {
        SynchronizedDebug instance = new SynchronizedDebug();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }
}

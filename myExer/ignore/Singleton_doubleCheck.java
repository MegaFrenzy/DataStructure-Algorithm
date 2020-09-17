package ignore;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-18 08:38
 */
public class Singleton_doubleCheck {
    private Singleton_doubleCheck() {

    }

    private volatile static Singleton_doubleCheck instance;

    public static Singleton_doubleCheck getInstance() {
        if (instance == null) { //没有这层，后续获取实例都要加锁获取，有性能损失
            synchronized (Singleton_doubleCheck.class) {

                if (instance == null) {
                    //当两个线程同时第一次申请时，如果没有判空就会构建2个实例
                    instance = new Singleton_doubleCheck();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton_doubleCheck ins = getInstance();
        Singleton_doubleCheck ins2 = getInstance();
        System.out.println(ins == ins2);
    }


}

package thread;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-26 20:31
 */
public class LeetCode1115 {



    class FooBar {
        private int n;
        private int count;
        private Object obj;

        public FooBar(int n) {
            this.n = n;
            this.count = 1;
            this.obj = new Object();
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (true) {
                    synchronized (obj) {
                        if (count == 1) {
                            // printFoo.run() outputs "foo". Do not change or remove this line.
                            printFoo.run();
                            count = 2;
                            obj.notifyAll();
                            break;
                        } else {
                            obj.wait();
                        }
                    }
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (true) {
                    synchronized (obj) {
                        if (count == 2) {
                            // printBar.run() outputs "bar". Do not change or remove this line.
                            printBar.run();
                            count = 1;
                            obj.notifyAll();
                            break;
                        } else {
                            obj.wait();
                        }
                    }
                }

            }
        }
    }
}


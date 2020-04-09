package l5_recurtion;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-04 16:08
 */
public class P3Queen {

    private int maxSize;
    private int arr[];
    private int count;
    public P3Queen(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }
    public void calc(){
        count =0;
        execute(0);
        System.out.printf("总共%d种解法",count);
    }

    public void execute(int input) {
        if (input == maxSize) {
            print();
            count++;
            return;
        }
        for(int i=0;i<maxSize;i++){
            arr[input]=i;
            if(isRight(input)){
                execute(input+1);
            }
        }

    }

    public boolean isRight(int no) {

        for(int i = 0; i< no; i++){
            if(arr[i]==arr[no]||Math.abs(no-i)==Math.abs(arr[no]-arr[i])){
                return false;
            }
        }
        return true;
    }

    public void print() {
        for(int i = 0; i< maxSize; i++){
            System.out.printf("%4d",arr[i]);
        }
        System.out.println();
    }
}


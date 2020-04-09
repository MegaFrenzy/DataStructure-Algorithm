package dynamicprogram1;

/**
 * @Description: 从给定数组中选数要求和最大，所选数不能相邻
 * @Author: MegaFrenzy
 * @CreateTime: 2020-04-01 22:22
 */
public class FindMaxSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 7, 8, 3};
        System.out.println(findMaxSum(arr));
    }

    public static int findMaxSum(int[] arr) {
        int[] opt = new int[arr.length];
        //initialization
        opt[0]=arr[0];
        opt[1]=Math.max(arr[0],arr[1]);
        //转移方程:f[i]=max{f[i-2]+arr[i],f[i-1]}//选和不选两种情况
        for (int i = 2; i < arr.length; i++) {
            opt[i]=Math.max(opt[i-2]+arr[i],opt[i-1]);
        }
        return opt[arr.length-1];
    }
}

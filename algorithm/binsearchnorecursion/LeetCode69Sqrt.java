package binsearchnorecursion;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-13 21:02
 */
public class LeetCode69Sqrt {
    public static void main(String[] args) {
        LeetCode69Sqrt l = new LeetCode69Sqrt();
        double v = l.mySqrt(2);
        System.out.println(v);
    }
    private double mySqrt(int x) {

        double start = 0.0, end = x, mid = 0.0;
        double error = 1e-5;
        double res = 0.0;
        while (start + error < end) {
            mid = start + (end - start) / 2;
            if (mid * mid > x) {
                end = mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                start = mid;
                break;
            }
        }
        return start;

    }
}

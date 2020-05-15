package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-10 18:37
 */
public class LeetCode78SubSet {
    public static void main(String[] args) {
        List<List<Integer>> list = new LeetCode78SubSet().subsets(new int[]{1, 2, 3});
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (nums == null) return list;
        list.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int loopNum = list.size();
            for (int j = 0; j < loopNum; j++){
                List<Integer> ele = list.get(j);
                ArrayList<Integer> newEle = new ArrayList<>(ele);
                ele.add(nums[i]);
                list.add(newEle);
            }
        }

        return list;
    }

    public List<List<Integer>> subsets0(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null) return list;
        recursion0(nums, 0, new ArrayList<>(), list);
        return list;

    }

    private void recursion0(int[] A, int idx, List<Integer> ele, List<List<Integer>> list) {
        if (idx == A.length) {
            list.add(ele);//new ArrayList<>(ele) 与 ele 的区别
            return;
        }
        recursion0(A, idx + 1, ele, list);
        ele.add(A[idx]);
        recursion0(A, idx + 1, ele, list);

        ele.remove(ele.size() - 1);
    }
}

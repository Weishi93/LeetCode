package leetcode;

import java.util.ArrayList;
import java.util.List;

public class p679 {
    public static boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i : nums) {
            list.add((double)i);
        }
        return helper(list);
    }

    private static boolean helper(List<Double> list) {
        System.out.println(list);
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 1e-6;
        }

        boolean res = false;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                double val1 = list.get(i);
                double val2 = list.get(j);
                list.remove(i);
                list.remove(j - 1);

                // +
                list.add(val1 + val2);
                res |= helper(list);
                list.remove(list.size() - 1);

                // -
                list.add(val1 - val2);
                res |= helper(list);
                list.remove(list.size() - 1);
                list.add(val2 - val1);
                res |= helper(list);
                list.remove(list.size() - 1);

                // *
                list.add(val1 * val2);
                res |= helper(list);
                list.remove(list.size() - 1);

                // /
                list.add(val1 / val2);
                res |= helper(list);
                list.remove(list.size() - 1);
                list.add(val2 / val1);
                res |= helper(list);
                list.remove(list.size() - 1);

                list.add(i, val1);
                list.add(j, val2);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 8, 3, 8};
        System.out.println(judgePoint24(nums));
    }
}

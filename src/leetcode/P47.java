package leetcode;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Wei Shi on 6/24/17.
 */
public class P47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, res, used, new ArrayList<Integer>());
        return res;
    }

    private static void helper(int[] nums, List<List<Integer>> res, boolean[] used, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            helper(nums, res, used, list);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = permuteUnique(nums);
        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }
        BigDecimal k = new BigDecimal(10);
        System.out.println(k.toString());
    }
}

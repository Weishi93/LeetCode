package leetcode;

import java.util.Arrays;

/**
 * Created by Wei Shi on 11/3/16.
 */
public class p41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length;) {
            int n = nums[i];
            if (n >= 1 && n <= nums.length && nums[n - 1] != n) {
                nums[i] = nums[n - 1];
                nums[n - 1] = n;
            } else {
                i++;
//                continue;
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, -1, 1};
        p41 some = new p41();
//        some.firstMissingPositive(arr);
        int[] dp = new int[]{1,2,5,6};
        System.out.println(Arrays.binarySearch(dp, 0, 3, 4));
    }
}

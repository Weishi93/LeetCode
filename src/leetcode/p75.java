package leetcode;

import java.util.Arrays;

/**
 * Created by Wei Shi on 7/25/17.
 */
public class p75 {
    public static void sortColors(int[] nums) {
        int c0 = 0, c1 = 0;
        for (int num : nums) {
            if (num == 0) {
                c0++;
            } else if (num == 1) {
                c1++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < c0) {
                nums[i] = 0;
            } else if (i < c0 + c1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,1,2,1,0,0,0,1,1,2,2,2,2,2,2,2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

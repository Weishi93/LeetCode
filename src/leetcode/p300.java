package leetcode;

import java.util.Arrays;

/**
 * Created by Wei Shi on 9/7/17.
 */
public class p300 {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            System.out.println(i);
            if (nums[i] > dp[count]) {
                count++;
                dp[count] = nums[i];
            } else {
                dp[search(dp, nums[i], count)] = nums[i];
            }
            System.out.println(Arrays.toString(dp));
        }
        return count;
    }

    private static int search(int[] dp, int key, int right) {
        int left = 0, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            System.out.println("left: " + left + " right: " + right + " mid: " + mid);
            if (dp[mid] == key) {
                return mid;
            } else if (dp[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
        lengthOfLIS(nums);
//        int[] dp = {4,5,6,19};
//        search(dp, 7, dp.length - 1);
    }
}

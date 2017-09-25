package leetcode;

public class p81 {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[left]) { //mid在左边
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < nums[left]) { // mid在右边
                if (target < nums[mid] || target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                left++;
            }
        }
//
        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }



    public static void main(String[] args) {
        int[] nums = new int[]{45,57,79,23,31,38};
        System.out.println(search(nums, 31));
    }
}
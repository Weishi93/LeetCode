package leetcode;
import java.util.*;

public class p324 {
	public void wiggleSort(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int s;
        if(nums.length % 2 == 0) {
            s = nums.length / 2 - 1;
        } else {
            s = nums.length / 2;
        }
        int l = nums.length - 1;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                nums[i] = copy[s--];
            } else {
                nums[i] = copy[l--];
            }
        }
    }

	public static void main(String[] args) {
		p324 a = new p324();
		// TODO Auto-generated method stub
		int[] nums = {1,1,4,5,6,1};
		a.wiggleSort(nums);
		int[] some = Arrays.copyOf(nums, 4);
		System.out.print(Arrays.toString(some));
	}

}

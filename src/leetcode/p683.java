package leetcode;

import java.util.TreeSet;

public class p683 {
    public static int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            set.add(flowers[i]);
            Integer ceiling = set.ceiling(flowers[i] + 1), floor = set.floor(flowers[i] - 1);
            if (ceiling != null && ceiling - flowers[i] == k + 1) {
                return i + 1;
            }
            if (floor != null && flowers[i] - floor == k + 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {6,5,8,9,7,1,10,2,3,4};
        kEmptySlots(a, 2);
    }
}

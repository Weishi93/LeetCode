package leetcode;

import java.util.HashSet;
import java.util.Set;

public class p681 {
    public static String nextClosestTime(String time) {
        String[] words = time.split(":");
        int t1 = Integer.valueOf(words[0]), t2 = Integer.valueOf(words[1]);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < time.length(); i++) {
            if (i == 2) continue;
            set.add(time.charAt(i) - '0');
        }
        for (int i = t1; i < 48; i++) {
            for (int j = 0; j < 60; j++) {
                if (i == t1 && j <= t2) continue;
                System.out.println("helper on " + i + " " + j);
                if (helper(i, j, set)) {
                    return construct(i, j);
                }
            }
        }
        return "";
    }
    private static boolean helper(int i, int j, Set<Integer> set) {
        String tmp = construct(i, j);
        System.out.println(tmp);
        for (int k = 0; k < 5; k++) {
            if (k == 2) continue;
            System.out.println("set contains " + tmp.charAt(k) + " ? " + set.contains(tmp.charAt(k) - '0'));
            if (!set.contains(tmp.charAt(k) - '0')) {
                return false;
            }
        }
        return true;
    }

    private static String construct(int i, int j) {
        if (i > 23) {
            i -= 24;
        }
        StringBuilder tmp = new StringBuilder();
        if (i < 10) {
            tmp.append(0);
        }
        tmp.append(i);
        tmp.append(":");
        if (j < 10) {
            tmp.append(0);
        }
        tmp.append(j);
        return tmp.toString();
    }

    public static void main(String[] args) {
        String s = "23:59";
        System.out.println(nextClosestTime(s));
    }
}

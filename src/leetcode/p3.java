package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Wei Shi on 11/4/16.
 */
public class p3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, i = 0, j = 0, start = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                if (j - i > res) {
                    res = j - i;
                    start = i;
                }
            } else {
                set.remove(s.charAt(i++));
            }
        }
        System.out.println(s.substring(start, start + res));
        return res;
    }

    public static void main(String[] args) {
        p3 some = new p3();
        System.out.println(some.lengthOfLongestSubstring("abcabck"));
    }
}

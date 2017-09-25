package leetcode;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Wei Shi on 2/27/17.
 */
public class P139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (res[i]) {
                for (String str : wordDict) {
                    if (s.substring(i, str.length() + i).equals(str)) {
                        res[i + str.length()] = true;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(res));
        return res[s.length()];
    }

    public static void main(String[] args) {
//        String s = "leetcode";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");
//        wordBreak(s, wordDict);
        System.out.println(Arrays.toString(countBits(20)));
        int[] arr = new int[21];
        for (int i = 0; i < 21; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));
    }
    private static int[] countBits(int n) {
        if (n < 1) {
            return new int[]{0};
        }
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }
}

package leetcode;

/**
 * Created by Wei Shi on 11/28/16.
 */
public class p388 {
    public static int lengthLongestPath(String input) {
        String[] words = input.split("\n");
        int[] stack = new int[words.length + 1];
        int res = 0;
        for (String s : words) {
            int level = s.lastIndexOf("\t") + 1;
            stack[level + 1] = stack[level] + s.length() - level + 1;
            res = Math.max(res, stack[level + 1] - 1);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "\tdir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
//        String[] words = s.split("\n");
//        String a = "\t\tfile1.ext";
//        for (String i : words) System.out.println(i);
//        System.out.println(a.length() - 2);
        System.out.println(lengthLongestPath(s));
    }
}

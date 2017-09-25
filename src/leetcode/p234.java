package leetcode;

import java.util.*;

public class p234 {
    public boolean isPalindrome(ArrayList<Integer> ary) {
        ArrayList<Integer> array = ary;

        int length = array.size();
        if(length % 2 == 0) {
            for(int i = length / 2 - 1, j = length / 2; i >= 0 && j < length; i--, j++) {
                if(array.get(i) != array.get(j)) {
                    return false;
                }
            }
            return true;
        } else {
            for(int i = length / 2 - 1, j = length / 2 + 1; i >= 0 && j < length; i--, j++) {
                if(array.get(i) != array.get(j)) {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
    	Integer[] array = {10914, 10914};
    	ArrayList<Integer> ary = new ArrayList<>(Arrays.asList(array));
    	p234 some = new p234();
    	some.isPalindrome(ary);
    }
}

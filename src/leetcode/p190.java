package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wei Shi on 11/16/16.
 */
public class p190 {
    public static int reverseBit(int n) {
        StringBuilder reverse = new StringBuilder(Integer.toString(n, 2)).reverse();
        while (reverse.length() != 32) {
            reverse.append(0);
        }
        return Integer.parseUnsignedInt(reverse.toString(), 2);
    }

    public static void main(String[] args) {
//        System.out.println(Integer.toString(43261596, 2));
//        System.out.println(Integer.parseInt(Integer.toString(43261596, 2), 2));
//        System.out.println(reverseBit(2147483648));
    }
}

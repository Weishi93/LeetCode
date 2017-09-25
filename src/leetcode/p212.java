package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wei Shi on 11/9/16.
 */
public class p212 {
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (int k = 0; k < words.length; k++) {
            if (res.contains(words[k])) continue;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {

                    if (search(board, i, j, words[k], 0)) res.add(words[k]);
                }
            }
        }
        return res;
    }

    private static boolean search(char[][] board, int i, int j, String word, int ind) {
        if (ind >= word.length()) return true;
        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != word.charAt(ind)) return false;
        board[i][j] = '*';
        boolean res = search(board, i, j - 1, word, ind + 1)
                || search(board, i, j + 1, word, ind + 1)
                || search(board, i - 1, j, word, ind + 1)
                || search(board, i + 1, j, word, ind + 1);
        board[i][j] = word.charAt(ind);
        return res;
    }

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        System.out.println(list.contains("a"));
//        list.add("a");
//        System.out.println(list.contains("a"));
//        list.add(new String("a"));
//        System.out.println(list.contains("a"));
        char[][] board = new char[][]{new char[]{'a', 'a'}};
        String[] words = new String[]{"a"};
        System.out.println(findWords(board, words));
    }
}

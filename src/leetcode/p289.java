package leetcode;

import java.util.Arrays;

/**
 * Created by Wei Shi on 10/12/16.
 */
public class p289 {
    int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public void gameOfLife(int[][] board) {
        int[][] res = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[] tmp = checkNeighbor(board, i, j);
                if (board[i][j] == 1) { // this cell is live
                    if (tmp[0] < 2 || tmp[0] > 3) {
                        res[i][j] = 0;
                    } else {
                        res[i][j] = 1;
                    }
                } else { //this cell is dead
                    if (tmp[1] == 3) {
                        res[i][j] = 1;
                    } else {
                        res[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = res[i][j];
            }
        }
    }

    private int[] checkNeighbor(int[][] board, int i, int j) {
        int[] res = new int[2];
        for (int[] d : dir) {
            int status = checkCell(board, i + d[0], j + d[1]);
            if (status == 0) {
                res[1]++;
            } else if (status == 1){
                res[0]++;
            }
        }
        return res;
    }

    private int checkCell(int[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return -1;
        }
        return board[i][j];
    }

    public static void main(String[] args) {
        p289 p = new p289();
        int[][] board = new int[][]{{1, 0, 1}, {0, 1, 1}, {0, 0, 1}, {1, 1, 1}};
        p.gameOfLife(board);
        System.out.println(Arrays.toString(board));
    }
}

package leetcode;

import java.util.PriorityQueue;

/**
 * Created by Wei Shi on 11/9/16.
 */
public class p378 {
    public static int kthSmallest(int[][] matrix, int k) {
        // int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int j = 0; j < matrix.length; j++) {
            pq.offer(new int[]{matrix[j][0], j, 0});
        }
        while(k-- > 1 && !pq.isEmpty()) {
            int[] tmp = pq.poll();
            if (tmp[2] == matrix[tmp[1]].length - 1) continue;
            pq.offer(new int[]{matrix[tmp[1]][tmp[2] + 1], tmp[1], tmp[2] + 1});
        }
        return pq.poll()[0];
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{new int[]{1,5,9}, new int[]{10,11,13}, new int[]{12,14,15}};
        System.out.println(kthSmallest(m, 4));
    }
}

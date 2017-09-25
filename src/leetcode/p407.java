package leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Created by Wei Shi on 11/10/16.
 */
public class p407 {
    public static int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int res = 0;
        int[][] left = new int[heightMap.length][heightMap[0].length];
        int[][] right = new int[heightMap.length][heightMap[0].length];
        int[][] up = new int[heightMap.length][heightMap[0].length];
        int[][] down = new int[heightMap.length][heightMap[0].length];
        for (int i = 0; i < heightMap.length; i++) {
            int max = heightMap[i][0];
            for (int j = 1; j < heightMap[i].length; j++) {
                left[i][j] = Math.max(max, heightMap[i][j]);
                max = left[i][j];
            }
        }

        for (int i = 0; i < heightMap.length; i++) {
            int max = heightMap[i][heightMap[i].length - 1];
            for (int j = heightMap[i].length - 2; j >= 0; j--) {
                right[i][j] = Math.max(max, heightMap[i][j]);
                max = right[i][j];
            }
        }

        for (int i = 0; i < heightMap[0].length; i++) {
            int max = heightMap[0][i];
            for (int j = 1; j < heightMap.length; j++) {
                up[j][i] = Math.max(max, heightMap[j][i]);
                max = up[j][i];
            }
        }

        for (int i = 0; i < heightMap[0].length; i++) {
            int max = heightMap[heightMap.length - 1][i];
            for (int j = heightMap.length - 2; j >= 0 ; j--) {
                down[j][i] = Math.max(max, heightMap[j][i]);
                max = down[j][i];
            }
        }

        for (int i = 0; i < heightMap.length; i++) {
            for (int j = 0; j < heightMap[i].length; j++) {
                int tmp1 = Math.min(left[i][j], right[i][j]);
                int tmp2 = Math.min(up[i][j], down[i][j]);
                int tmp = Math.min(tmp1, tmp2);
                if (tmp > heightMap[i][j]) {
                    res += tmp - heightMap[i][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{new int[]{12,13,1,12},new int[]{13,4,13,12}, new int[]{13,8,10,12}, new int[]{12,13,12,12}, new int[]{13,13,13,13}};
        System.out.println(trapRainWater(arr));
    }
}

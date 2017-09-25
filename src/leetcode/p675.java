package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class p675 {
    public static int cutOffTree(List<List<Integer>> forest) {
        int res = 0, height = forest.size(), width = forest.get(0).size();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int[][] dp = new int[height * width][height * width];
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new Node(forest.get(i).get(j), i, j));
                }
            }
        }
        Node prev = new Node(1, 0, 0);
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = distance(forest, dp, prev.row, prev.col, node.row, node.col);
            System.out.println("From " + prev.row +"&" + prev.col + " to " + node.row + "&" + node.col + " dist: " + dist);
            if (dist == Integer.MAX_VALUE) {
                return -1;
            } else {
                dp[prev.row * width + prev.col][node.row * width + node.col] = dist;
                dp[node.row * width + node.col][prev.row * width + prev.col] = dist;
                res += dist;
                prev = node;
            }
        }
        return res;
    }

    private static int distance(List<List<Integer>> forest, int[][] dp, int x1, int y1, int x2, int y2) {
        if (x1 < 0 || x1 >= forest.size() || y1 < 0 || y1 >= forest.get(x1).size() || forest.get(x1).get(y1) == 0) return Integer.MAX_VALUE;
        if (x1 == x2 && y1 == y2) return 0;

        if (dp[x1 * forest.get(0).size() + y1][x2 * forest.get(0).size() + y2] != 0) {
            return dp[x1 * forest.get(0).size() + y1][x2 * forest.get(0).size() + y2];
        }
        int val = forest.get(x1).get(y1);
        forest.get(x1).set(y1, 0);
        int up = distance(forest, dp,x1 - 1, y1, x2, y2);
        int down = distance(forest, dp,x1 + 1, y1, x2, y2);
        int left = distance(forest, dp, x1, y1 - 1, x2, y2);
        int right = distance(forest, dp, x1, y1 + 1, x2, y2);
        forest.get(x1).set(y1, val);
        System.out.println("up" + up + "down" + down + "left" + left + "right" + right);
        int res = Math.min(up, Math.min(down, Math.min(left, right)));
        if (res != Integer.MAX_VALUE) {
            dp[x1 * forest.get(0).size() + y1][x2 * forest.get(0).size() + y2] = res + 1;
            return res + 1;
        } else {
            dp[x1 * forest.get(0).size() + y1][x2 * forest.get(0).size() + y2] = res;
            return res;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();
        List<Integer> l1, l2, l3;
        l1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        l2 = new ArrayList<Integer>(Arrays.asList(0, 0, 4));
        l3 = new ArrayList<Integer>(Arrays.asList(7, 6, 5));
        forest.add(l1);
        forest.add(l2);
        forest.add(l3);
        System.out.println(cutOffTree(forest));
    }
}
class Node {
    int val, row, col;
    public Node(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
}

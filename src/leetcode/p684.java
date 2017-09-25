package leetcode;

import java.util.*;

public class p684 {
    static class QU {
        int[] arr;
        public QU(int capacity) {
            arr = new int[capacity];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }

        public int root(int p) {
            while (p != arr[p]) {
                p = arr[p];
            }
            return p;
        }

        public void connect(int p, int q) {
            int rootP = root(p), rootQ = root(q);
            arr[rootP] = rootQ;
        }

        public boolean isConnected(int p, int q) {
            return root(p) == root(q);
        }
    }
    public static int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] res = null;
        for (int[] arr : edges) {
            if (!map.containsKey(arr[0])) {
                map.put(arr[0], new HashSet<Integer>());
                map.get(arr[0]).add(arr[0]);

            }
            if (!map.containsKey(arr[1])) {
                map.put(arr[1], new HashSet<Integer>());
                map.get(arr[1]).add(arr[1]);
            }
            Set<Integer> set0 = map.get(arr[0]), set1 = map.get(arr[1]);
            System.out.println(set0.toString() + " and " + set1.toString());
            if (set0 == set1) {
                res = arr;
            } else {
                set0.addAll(set1);
                for (Integer i : set1) {
                    map.put(i, set0);
                }
                set1.clear();
            }
        }
        return res;
    }

    public static int[] findRedundantConnection2(int[][] edges) {
        QU qu = new QU(edges.length);
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = null;
        for (int[] arr : edges) {
            if (!map.containsKey(arr[0])) {
                map.put(arr[0], map.size());
            }
            if (!map.containsKey(arr[1])) {
                map.put(arr[1], map.size());
            }
            if (qu.isConnected(map.get(arr[0]), map.get(arr[1]))) {
                res = arr;
            } else {
                qu.connect(map.get(arr[0]), map.get(arr[1]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] edges = {{2,3},{5,2}, {1,5}, {4,2}, {4,1}};
        System.out.println(Arrays.toString(findRedundantConnection2(edges)));
    }
}

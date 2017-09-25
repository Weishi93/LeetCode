package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Wei Shi on 11/3/16.
 */
public class p451 {
    public String frequencySort(String s) {
        int[] arr = new int[256];
        for (char ch : s.toCharArray()) {
            arr[ch]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                new Comparator<Integer>() {
                    public int compare(Integer n1, Integer n2) {
                        return arr[n2] - arr[n1];
                    }
                }
        );
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                pq.add(i);
            }
        }
        StringBuilder res = new StringBuilder();
        while (pq.size() != 0) {
            int tmp = pq.poll();
            for (int i = 0; i < arr[tmp]; i++) {
                res.append((char)tmp);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        p451 送么 = new p451();
        System.out.println(送么.frequencySort("tree"));
    }
}

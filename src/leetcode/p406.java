package leetcode; /**
 * Created by Wei Shi on 11/16/16.
 */
import java.util.*;
public class p406 {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                return p1[0]!=p2[0]?Integer.compare(p2[0],p1[0]): Integer.compare(p1[1],p2[1]);
            }
        });
//        for (int[] i : people) {
//            System.out.println(Arrays.toString(i));
//        }
        List<int[]> list = new ArrayList<>();
        for (int[] ppl: people) list.add(ppl[1], ppl);
        return list.toArray(new int[people.length][] );
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
//        Arrays.sort(people, new Comparator<int[]>() {
//            public int compare(int[] a, int[] b) {
//                if (a[0] != b[0]) {
//                    return b[0] - a[0];
//                } else {
//                    return a[1] - b[1];
//                }
//            }
//        });
        int[][] res = reconstructQueue(people);
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
    }
}

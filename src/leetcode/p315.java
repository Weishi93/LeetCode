package leetcode;
import  java.util.*;
/**
 * Created by Wei Shi on 10/28/16.
 */
public class p315 {
//      public static List<Integer> countSmaller(int[] nums) {
//        Integer[] res = new Integer[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            res[i] = 0;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] < nums[i]) {
//                    res[i] = res[i] + 1;
//                }
//            }
//        }
//        return Arrays.asList(res);
//    }
//    class Node {
//        Node left, right;
//        int val, sum, dup = 1;
//        Node(int v, int s) {
//            val = v;
//            sum = s;
//        }
//    }
//
//
//    public List<Integer> countSmaller(int[] nums) {
//        Integer[] res = new Integer[nums.length];
//        Node root = null;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            root = insert(nums[i], i, root, res, 0);
//        }
//        return Arrays.asList(res);
//    }
//
//    private Node insert(int num, int i, Node node, Integer[] res, int preSum) {
//        if (node == null) {
////            System.out.println("when implement: " + node);
//            node = new Node(num, 0);
////            System.out.println("after implement: " + node + "\n");
//            res[i] = preSum;
//        } else if (num == node.val) {
//            node.dup++;
//            res[i] = node.sum + preSum;
//        } else if (num > node.val) {
//            node.right = insert(num, i, node.right, res, preSum + node.sum + node.dup);
////            System.out.println("when declare: " + node.right);
//        } else {
//            node.sum++;
//            node.left = insert(num, i, node.left, res, preSum);
////            System.out.println("when declare: " + node.left);
//        }
//        return node;
//    }

//    class Node {
//        Node left, right;
//        int val, sum, dup, flag;
//        Node(int v, int s) {
//            val = v;
//            sum = s;
//            dup = 1;
//            flag = 0;
//        }
//    }
//    public List<Integer> countSmaller(int[] nums) {
//        Integer[] res = new Integer[nums.length];
//        Node root = new Node(nums[nums.length - 1], 0);
//        res[res.length - 1] = 0;
//        for (int i = nums.length - 2; i >= 0; i--) {
//            insert(nums[i], root, res, i);
//        }
//        return Arrays.asList(res);
//    }
//
//    private void insert(int num, Node node, Integer[] res, int i) {
//        if (num == node.val) {
//            node.dup++;
//            node.flag++;
////            res[i] = node.sum;
////            Node tmp = node.right;
////            while (tmp != null) {
////                tmp.sum++;
////                tmp = tmp.right;
////            }
//        } else if (num < node.val) {
//            if (node.left != null) {
//                insert(num, node.left, res, i);
//            } else {
//                node.left = new Node(num, node.sum);
//                res[i] = node.left.sum;
//            }
//            node.sum++;
//            node.flag++;
//        } else {
//            if (node.right != null) {
//                if (node.flag != 0) {
//                    node.right.sum += node.flag;
//                    node.right.flag = node.flag;
//                    node.flag = 0;
//                }
//                insert(num, node.right, res, i);
//            } else {
//                node.right = new Node(num, node.sum + node.dup);
//                res[i] = node.right.sum;
//                node.flag = 0;
//            }
//        }
//    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<>();
        int size = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = bs(sorted, nums[i], size++);
            sorted.add(res[i], nums[i]);
        }
        return Arrays.asList(res);
    }

    private int bs(List<Integer> sorted, int num, int size) {
        int left = 0, right = size, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (num < sorted.get(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        p315 some = new p315();
        System.out.println(some.countSmaller(nums));
    }
}
